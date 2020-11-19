import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JCafeDeadLineList extends JFrame implements ActionListener, PropertyChangeListener {

	JTable table;
	DefaultTableModel model;
	JPanel pnlTable, pnlBtn;
	JButton  btnSet, btnReset; //btnApply,
	int row;

	int firstChk;
	String[][] content; // 모델에 add시킬 배열 //필요한 모든 데이터를 가지고 있을 예정
	JCafeGetStockData gst = new JCafeGetStockData();
	
	public JCafeDeadLineList() {

		table = new JTable();
		// 수량만 수정 가능
		table.setModel(new DefaultTableModel(new Object[][] {

		},

				new String[] { "재료명", "실 재고량", "단위", "전일재고량", "표준재고량", "loss/over", "비고" })

		{
			boolean[] columnEditables = new boolean[] { false, true, false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		// 모델을 변수에 담지 않고 무명클래스로 만들어서 테이블에서 모델을 따로 받아옴
		model = (DefaultTableModel) table.getModel();

		// 재고 등록을 위한 데이터를 가져오는 클래스를 생성
		
		content = new String[gst.inventoryArray[0].length][7];
		for (int i = 0; i < gst.inventoryArray[0].length; i++) {
			content[i][0] = gst.inventoryArray[0][i];
			content[i][1] = "";
			content[i][2] = gst.inventoryArray[2][i];
			content[i][3] = gst.inventoryArray[1][i];
			content[i][4] = (Integer.parseInt(gst.inventoryArray[1][i]) - gst.useTotal[i]) + "";
			content[i][5] = "0";
			content[i][6] = "";
			model.addRow(content[i]);

		}
		table.addPropertyChangeListener(this);

		this.setSize(500, 530);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		pnlTable = new JPanel();
		JScrollPane sp = new JScrollPane(table);
		pnlTable.add(sp);

		pnlBtn = new JPanel();
		//btnApply = new JButton("적용");
		btnSet = new JButton("완료");
		btnReset = new JButton("초기화");

		//pnlBtn.add(btnApply);
		pnlBtn.add(btnSet);
		pnlBtn.add(btnReset);
		btnSet.addActionListener(this);
		btnReset.addActionListener(this);

		this.add(pnlTable);
		this.add(pnlBtn, "South");
		this.setVisible(true);

	}

	public JCafeDeadLineList(JCafeManagerMenu jCafeManagerMenu) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSet) {// 완료
			saveFile();
			saveChangeInventoryFile();
			new JCafeSpinner();
		} else if (arg0.getSource() == btnReset) {// 초기화
			for(int i=0;i<table.getRowCount();i++){
				table.setValueAt("", i, 1);
				table.setValueAt("0", i, 5);
			}
		}
	}

	public static void main(String[] args) {
		new JCafeDeadLineList();
	}
	
	//발주 등록할때 사용하기 위해서 파일로 저장
	void saveFile() {
		// 재료명/실제 인벤/전일재고량/표준사용량/표준 재고량/overloss/비고
		// 저장 파일명 20201119_jcafe_deadlinelist.txt
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);
		
		
		
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			File dir = new File("./jcafe_"+dt+"/");
			if(!dir.isDirectory()){
			dir.mkdirs();
			}
			fw = new FileWriter("./jcafe_"+dt+"/deadlinelist.txt");
			pw = new PrintWriter(fw);
			for(int i=0;i<table.getRowCount();i++){
				content[i][1] = (String)table.getValueAt(i, 1);
				content[i][5] = (String)table.getValueAt(i, 5);
				String saveD = content[i][0]+"/"+ (content[i][1].equals("")?gst.inventoryArray[1][i]:content[i][1])+"/"+ content[i][3]+"/"+ gst.useTotal[i]+"/"+ content[i][4]+"/"+ content[i][5]+"/"+ content[i][6];
				pw.println(saveD);				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	void saveChangeInventoryFile(){

		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			File dir = new File("./files/");
			if(!dir.isDirectory()){
			dir.mkdirs();
			}
			fw = new FileWriter("./files/inventory.txt");
			pw = new PrintWriter(fw);
			for(int i=0;i<table.getRowCount();i++){
				String saveD = gst.inventoryArray[0][i]+"/"+(content[i][1].equals("")?gst.inventoryArray[1][i]:content[i][1])+"/"+gst.inventoryArray[2][i];
				pw.println(saveD);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	
	//실 재고량에 값 입력 시에 over/loss 칸에 계산 후 자동입력 되게 하는 이벤트메서드
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (firstChk != 0&&table.getSelectedRow()!=-1) {
			String currentInventory = (String) (table.getValueAt(table.getSelectedRow(), 1));
			int intCurrentInventory = 0;
			int standardInventory = 0;
			if (!(currentInventory.equals(""))) {
				intCurrentInventory = Integer.parseInt(currentInventory);
				standardInventory = Integer.parseInt((String) (table.getValueAt(table.getSelectedRow(), 4)));
				// 실재고량 - 표준재고량 = over/loss
				table.setValueAt((intCurrentInventory - standardInventory)+"", table.getSelectedRow(), 5);
			}
		}
		firstChk = 1;
	}
}
