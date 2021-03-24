import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.management.modelmbean.ModelMBean;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.UtilDateModel;

//���� ��� ��ư�� ������ ������ �� ȭ��
public class JCafeSpinner extends JDialog implements ActionListener {
	public static void main(String[] args) {
		new JCafeSpinner();
	}
	
	JLabel laY, laM, laD;
	JButton btnOrder;
	JButton btnInsert;
	JButton btnDelete;
	JTable table;
	String str[] = { "����", "�� ���", "ǥ�ػ�뷮", "ǥ�ع���", "��������", "����", "Over/Loss" };
	// deadlinelist.txt�� ����� ���� : // ����/���� �κ�/����/�������/ǥ�ػ�뷮/ǥ�� ���/overloss/���
	// ǥ�� ��뷮�� ������ ������ ����ߴ� ��ᷮ�� ǥ��
	// ǥ�� ����= �� ��� - ǥ�ػ�뷮
	// ���� ���ִ� ���� ���� �� �ְ� ����
	String strTable[][] = {};
	DefaultTableModel tmodel;
	
	String[][] useData = new String[6][];

	Calendar cal;
	String dt;
	int[] usageSum;// ǥ�ػ�뷮
	int[] overlossSum;// ǥ�ؿ����ν�

	// readUsage()���� ����ϴ� ����
	String overlossStr = "";
	String usageStr = "";


	JTextField tfName; // �߰��� ����
	JTextField tfQuantity; // �߰��� ����� ���ַ�
	JTextField tfUnit; // �߰��� ����� ����

	public JCafeSpinner() {
		this.setSize(580, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		//������ �� ������ �� �о������ ��¥�� ������
		cal = Calendar.getInstance();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		dt = transFormat.format(cal.getTime());

		table = new JTable();
		table.setModel(new DefaultTableModel(strTable, str){
			boolean[] columnEditables = new boolean[] { false, false, false, false, true, true, false };
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		//���� ���� �� ���� �޾ƿ���
		tmodel = (DefaultTableModel) table.getModel();
		
		//���̺� ���� �ֱ�
		readFile();
		getUsageSum();
		setTableData();
		
		//���̺� ������ ��� ����
				DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
				celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
				for(int i=0;i<str.length;i++){
					table.getColumn(str[i]).setCellRenderer(celAlignCenter);
				}
				
				//���̺��� ������ �߸��� �κ��� ����
				table.getColumn(str[0]).setPreferredWidth(230);
			/*	table.getColumn(str[1]).setPreferredWidth(100);
				table.getColumn(str[3]).setPreferredWidth(100);
				table.getColumn(str[4]).setPreferredWidth(100);
				table.getColumn(str[5]).setPreferredWidth(100);*/

		JScrollPane sp = new JScrollPane(table);
		

		JPanel btnPnl = new JPanel();
		btnOrder = new JButton("���� ���");
		btnOrder.addActionListener(this);
		btnInsert = new JButton("��� �߰�");
		btnInsert.addActionListener(this);
		btnDelete = new JButton("��� ����");
		btnDelete.addActionListener(this);
		btnPnl.add(btnInsert);
		btnPnl.add(btnDelete);
		btnPnl.add(new JLabel("              "));
		btnPnl.add(btnOrder);
		

		JPanel inPnl1 = new JPanel();
		JPanel inPnl2 = new JPanel();
		JPanel inPnl3 = new JPanel();
		tfName = new JTextField(15);
		tfQuantity = new JTextField(10);
		tfUnit = new JTextField(10);
		inPnl1.add(new JLabel("���� : "));
		inPnl1.add(tfName);
		inPnl2.add(new JLabel("���ּ��� :       "));
		inPnl2.add(tfQuantity);
		inPnl3.add(new JLabel("���� :                       "));
		inPnl3.add(tfUnit);
		
		//�ʿ��� ��� �߰��ϴ� ��ư
		JPanel insertPnl = new JPanel(new GridLayout(0, 2));
		insertPnl.add(inPnl1);
		insertPnl.add(inPnl2);
		insertPnl.add(inPnl3);

		//������ DeadLineRegistration�� �ٽ� �������� ����
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				new DeadLineRegistration();
			}
		});
		
		sp.setBounds(10, 10, 600, 450);
		insertPnl.setBounds(0, 450, 600, 70);
		btnPnl.setBounds(0, 520, 600, 50);

		
		this.add(sp);
		this.add(insertPnl);
		this.add(btnPnl);
		this.setVisible(true);
	}

	// ������ deadlinelist.txt ������ �о�´�.
	void readFile() {

		FileReader fr = null;
		BufferedReader br = null;
		String data[] = { "", "", "", "", "", "" };
		try {
			fr = new FileReader("jcafe_" + dt + "/deadlinelist.txt");
			br = new BufferedReader(fr);
			String readData = "";
			while ((readData = br.readLine()) != null) {
				String[] deadlinelistData = readData.split("" + "/");
				for (int i = 0; i < data.length; i++) {
					data[i] = data[i] + deadlinelistData[i] + "/";
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < data.length; i++) {
			useData[i] = data[i].split("/");
		}

		// Ȯ�ο� �ڵ�
		/*
		 * for(int i=0;i<useData.length;i++){ for(int
		 * j=0;j<useData[i].length;j++){ System.out.print(useData[i][j]); }
		 * System.out.println(); }
		 */

	}

	// ǥ�� ��뷮�̶� ǥ�� �����ν� ���ϴ� �޼���
	void getUsageSum() {
		String[][] dayUsage = new String[7][];
		String[][] dayOverloss = new String[7][];
		for (int i = 0; i < 7; i++) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			String dt2 = transFormat.format(cal.getTime());
			readUsage(dt2);
			dayUsage[i] = usageStr.split("/");
			dayOverloss[i] = overlossStr.split("/");

		}

		int[][] usageIntArray = new int[dayUsage[0].length][dayUsage.length];
		int[][] overlossIntArray = new int[dayOverloss[0].length][dayOverloss.length];
		for (int i = 0; i < dayUsage[0].length; i++) {
			for (int j = 0; j < dayUsage.length; j++) {
				usageIntArray[i][j] = Integer.parseInt(dayUsage[j][i]);
				overlossIntArray[i][j] = Integer.parseInt(dayOverloss[j][i]);

			}
		}
		usageSum = new int[usageIntArray.length];
		overlossSum = new int[overlossIntArray.length];
		int sumU = 0;
		int sumOv = 0;
		for (int j = 0; j < usageIntArray.length; j++) {
			for (int i = 0; i < usageIntArray[0].length; i++) {
				sumU = sumU + usageIntArray[j][i];
				sumOv = sumOv + overlossIntArray[j][i];
			}
			usageSum[j] = sumU;
			overlossSum[j] = sumOv;
			sumU = 0;
			sumOv = 0;

		}

	}

	// ������ ��뷮�̶� �����ν��� ���Ͽ��� �ҷ����� �޼���
	void readUsage(String dt) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader("jcafe_" + dt + "/deadlinelist.txt");
			br = new BufferedReader(fr);
			String readData = "";
			while ((readData = br.readLine()) != null) {
				String[] deadlinelistData = readData.split("" + "/");
				usageStr = usageStr + deadlinelistData[4] + "/";
				overlossStr = overlossStr + deadlinelistData[5] + "/";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	//���̺� ������ ��� �޼�
	void setTableData() {
		/*
		 * for (int i = 0; i < useData.length; i++) { for (int j = 0; j <
		 * useData[i].length; j++) { System.out.print(i + "/" + j);
		 * System.out.println("/" + useData[i][j] + "/"); }
		 * System.out.println(); }
		 */
		String[] content = new String[7];
		for (int j = 0; j < useData[0].length; j++) {
			// System.out.println("/" + useData[i][j] + "/");
			content[0] = useData[0][j]; // ����
			content[1] = useData[1][j] + "   " + useData[2][j];
			content[2] = usageSum[j] + "   " + useData[2][j];
			if ((usageSum[j] - Integer.parseInt(useData[1][j])) < 0) {
				if (useData[2][j].equals("ml")) {
					content[3] = "0   L";
				} else if (useData[2][j].equals("g")) {
					content[3] = "0   Kg";
				} else if (useData[2][j].equals("ea")) {
					content[3] = "0   Box";
				} else {
					content[3] = "0";
				}
			} else {
				int content3 = (usageSum[j] - Integer.parseInt(useData[1][j]));
				if (useData[2][j].equals("ml")) {
					content[3] = content3 / 1000 + "   L";
				} else if (useData[2][j].equals("g")) {
					content[3] = content3 / 1000 + "   Kg";
				} else if (useData[2][j].equals("ea")) {
					content[3] = content3 / 24 + "   Box";
				} else {
					content[3] = content3 + "";
				}
			}
			content[4] = "";
			if (useData[2][j].equals("ml")) {
				content[5] = "L";
			} else if (useData[2][j].equals("g")) {
				content[5] = "Kg";
			} else if (useData[2][j].equals("ea")) {
				content[5] = "Box";
			} else {
				content[5] = "";
			}
			content[6] = overlossSum[j] + "   " + useData[2][j];
			tmodel.addRow(content);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOrder) {
			int jopChk = JOptionPane.showConfirmDialog(this, "���� ����Ͻðڽ��ϱ�?", "", JOptionPane.OK_CANCEL_OPTION);
			if (jopChk == JOptionPane.OK_OPTION) {
				saveOrder();
				removeInventoryMaterial();
				new DeadLineRegistration();
				dispose();
			}
		} else if (e.getSource() == btnInsert) {
			String[] modelData = new String[7];
			modelData[0] = tfName.getText();
			modelData[1] = "";
			modelData[2] = "";
			modelData[3] = "";
			modelData[4] = tfQuantity.getText();
			modelData[5] = tfUnit.getText();
			modelData[6] = "";

			tmodel.addRow(modelData);
		} else {
			int selRow = table.getSelectedRow();
			tmodel.removeRow(selRow);
		}
	}

	// ���� ����ϴٰ� ��Ḧ ���������� �κ��丮���� �ش� ����� �����Ѵ�.
	void removeInventoryMaterial() {
		String[] tableMaterialName = new String[table.getRowCount()];
		for (int i = 0; i < tableMaterialName.length; i++) {
			tableMaterialName[i] = (String) table.getValueAt(i, 0);
		}
		int idx = 0;
		String removeRowStr = "";
		for (int i = 0; i < useData[0].length; i++) {
			boolean chk = false;
			for (int j = 0; j < tableMaterialName.length; j++) {
				if (useData[0][i].equals(tableMaterialName[j])) {
					chk = true;
					break;
				}
			}
			if (!chk) {
				removeRowStr = removeRowStr + idx+ "/";
			}
			idx++;
		}
		String[] idxArray = removeRowStr.split("/");
		
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("files/inventory.txt");
			pw = new PrintWriter(fw);
			for(int i=0;i<useData[0].length;i++){
				for(int j=0;j<idxArray.length;j++){
					if(!(idxArray[0].equals(""))){
						if(i==Integer.parseInt(idxArray[j])){
							//System.out.println(idxArray[j]);
							//System.out.println(useData[0][j]);
							break;
						}else{
							pw.println(useData[0][i]+"/"+useData[1][i]+"/"+useData[2][i]);
						}
						
					}else{
						pw.println(useData[0][i]+"/"+useData[1][i]+"/"+useData[2][i]);
					}
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

	// ������ �԰� �ݿ���Ű�� ���ؼ� ���ָ���� �����Ų��.
	void saveOrder() {
		// Order registration
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);

		File dir = new File("./jcafe_order_registration/");
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("./jcafe_order_registration/" + dt + "_orderlist.txt");
			pw = new PrintWriter(fw);
			int rowCnt = tmodel.getRowCount();
			String saveData = "";
			// { "����", "�� ���", "ǥ�ػ�뷮", "ǥ�ع���", "��������","����", "Over/Loss" };
			// ������ �����ʹ� ����, ��������, ����
			for (int i = 0; i < rowCnt; i++) {
				saveData = table.getValueAt(i, 0) + "/"
						+ (table.getValueAt(i, 4).equals("") ? "0" : table.getValueAt(i, 4)) + "/"
						+ table.getValueAt(i, 5);
				pw.println(saveData);
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

	

}
