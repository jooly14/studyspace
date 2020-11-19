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
	String[][] content; // �𵨿� add��ų �迭 //�ʿ��� ��� �����͸� ������ ���� ����
	JCafeGetStockData gst = new JCafeGetStockData();
	
	public JCafeDeadLineList() {

		table = new JTable();
		// ������ ���� ����
		table.setModel(new DefaultTableModel(new Object[][] {

		},

				new String[] { "����", "�� ���", "����", "�������", "ǥ�����", "loss/over", "���" })

		{
			boolean[] columnEditables = new boolean[] { false, true, false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		// ���� ������ ���� �ʰ� ����Ŭ������ ���� ���̺��� ���� ���� �޾ƿ�
		model = (DefaultTableModel) table.getModel();

		// ��� ����� ���� �����͸� �������� Ŭ������ ����
		
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
		//btnApply = new JButton("����");
		btnSet = new JButton("�Ϸ�");
		btnReset = new JButton("�ʱ�ȭ");

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
		if (arg0.getSource() == btnSet) {// �Ϸ�
			saveFile();
			saveChangeInventoryFile();
			new JCafeSpinner();
		} else if (arg0.getSource() == btnReset) {// �ʱ�ȭ
			for(int i=0;i<table.getRowCount();i++){
				table.setValueAt("", i, 1);
				table.setValueAt("0", i, 5);
			}
		}
	}

	public static void main(String[] args) {
		new JCafeDeadLineList();
	}
	
	//���� ����Ҷ� ����ϱ� ���ؼ� ���Ϸ� ����
	void saveFile() {
		// ����/���� �κ�/�������/ǥ�ػ�뷮/ǥ�� ���/overloss/���
		// ���� ���ϸ� 20201119_jcafe_deadlinelist.txt
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
	
	
	
	//�� ����� �� �Է� �ÿ� over/loss ĭ�� ��� �� �ڵ��Է� �ǰ� �ϴ� �̺�Ʈ�޼���
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (firstChk != 0&&table.getSelectedRow()!=-1) {
			String currentInventory = (String) (table.getValueAt(table.getSelectedRow(), 1));
			int intCurrentInventory = 0;
			int standardInventory = 0;
			if (!(currentInventory.equals(""))) {
				intCurrentInventory = Integer.parseInt(currentInventory);
				standardInventory = Integer.parseInt((String) (table.getValueAt(table.getSelectedRow(), 4)));
				// ����� - ǥ����� = over/loss
				table.setValueAt((intCurrentInventory - standardInventory)+"", table.getSelectedRow(), 5);
			}
		}
		firstChk = 1;
	}
}
