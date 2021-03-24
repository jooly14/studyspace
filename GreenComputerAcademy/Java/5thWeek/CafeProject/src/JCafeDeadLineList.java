import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JCafeDeadLineList extends JFrame implements ActionListener, PropertyChangeListener {
	//�׽�Ʈ�� �ڵ�
	/*public static void main(String[] args) {
		new JCafeDeadLineList();
	}*/
	
	JTable table;
	DefaultTableModel model;
	JPanel pnlBtn;
	JButton  btnSet, btnReset;
	String[] header = { "����", "�� ���", "����", "�������", "ǥ�����", "loss/over", "���" };

	int firstChk;	//propertychangelistner�̺�Ʈ���� ����Ϸ��� ����
	String[][] content; // �𵨿� add��ų �迭 //�ʿ��� ��� �����͸� ������ ���� ����
	JCafeGetStockData gst = new JCafeGetStockData();	//���̺� �߰��� ������ �������� ���ؼ� Ŭ���� ����
	
	public JCafeDeadLineList() {
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		table = new JTable();
		// ������ ���� �����ϰ� �������
		table.setModel(new DefaultTableModel(new Object[][] {},header){	
			boolean[] columnEditables = new boolean[] { false, true, false, false, false, false, true };
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		// ���� ������ ���� �ʰ� ����Ŭ������ ���� ���̺��� ���� ���� �޾ƿ�
		model = (DefaultTableModel) table.getModel();

		
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
		//�� ��� �Է� �Ҷ����� �����ν��� �����ǰԲ� �̺�Ʈ�� �޾Ҵ�.
		table.addPropertyChangeListener(this);
		
		//���̺� ������ ��� ����
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0;i<header.length;i++){
			table.getColumn(header[i]).setCellRenderer(celAlignCenter);
		}
		
		//���̺��� ������ �߸��� �κ��� ����
		table.getColumn(header[0]).setPreferredWidth(230);
		table.getColumn(header[1]).setPreferredWidth(130);
		table.getColumn(header[3]).setPreferredWidth(130);
		table.getColumn(header[4]).setPreferredWidth(130);
		table.getColumn(header[5]).setPreferredWidth(100);


		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10,10,570,500);

		btnSet = new JButton("�Ϸ�");
		btnReset = new JButton("�ʱ�ȭ");
		btnSet.addActionListener(this);
		btnReset.addActionListener(this);

		pnlBtn = new JPanel();
		pnlBtn.add(btnSet);
		pnlBtn.add(btnReset);
		pnlBtn.setBounds(10,520,570,300);

		
		//ȭ�� ������ �ٽ� DeadLineRegistration�� ���� ���ؼ� 
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				new DeadLineRegistration();
			}
		});
		
		
		
		this.setLayout(null);
		this.add(sp);
		this.add(pnlBtn);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSet) {// �Ϸ�
			saveFile();
			saveChangeInventoryFile();
			new DeadLineRegistration();
			dispose();
		} else if (arg0.getSource() == btnReset) {// �ۼ��� �� ����� �ʱ�ȭ��Ŵ
			for(int i=0;i<table.getRowCount();i++){
				table.setValueAt("", i, 1);
				table.setValueAt("0", i, 5);
			}
		}
	}

	
	//���� ����Ҷ� ����ϱ� ���ؼ� ���Ϸ� ����
	void saveFile() {
		// ����/���� �κ�/����/�������/ǥ�ػ�뷮/ǥ�� ���/overloss/���
		// ���� ���ϸ� 20201119_jcafe_deadlinelist.txt
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);
		
		FileWriter fw = null;
		PrintWriter pw = null;
		//�ش� ������ ������ ������ ����
		File dir = new File("./jcafe_"+dt+"/");
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		try {
			fw = new FileWriter("./jcafe_"+dt+"/deadlinelist.txt");
			pw = new PrintWriter(fw);
			for(int i=0;i<table.getRowCount();i++){
				content[i][1] = (String)table.getValueAt(i, 1);
				content[i][5] = (String)table.getValueAt(i, 5);
				String saveD = content[i][0]+"/"+ 
				(content[i][1].equals("")?content[i][4]:content[i][1])+"/"+
				gst.inventoryArray[2][i]+"/"+ content[i][3]+"/"+
				gst.useTotal[i]+"/"+ content[i][4]+"/"+ content[i][5]+"/"+ content[i][6];
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
	
	//�κ��丮�� ���� ����� �ݿ���Ų��.
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
				String saveD = gst.inventoryArray[0][i]+"/"+(content[i][1].equals("")?content[i][4]:content[i][1])+"/"+gst.inventoryArray[2][i];
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
