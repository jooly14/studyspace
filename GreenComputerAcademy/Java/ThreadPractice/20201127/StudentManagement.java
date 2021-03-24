import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
class Std{
	String name;
	String major;
	String phone;
	String addr;
	public Std(String name, String major, String phone, String addr) {
		super();
		this.name = name;
		this.major = major;
		this.phone = phone;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
public class StudentManagement extends JFrame implements ActionListener{
	JButton btnInsert, btnSearch, btnDelete, btnExit, btnInsert2, btnDelete2, btnSearch2;
	JPanel pnlInsert, pnlSearch, pnlDelete, pnlLbl, pnlTF;
	JTextField tfID, tfName, tfMajor, tfPhone, tfAddr, tfIDDel, tfSearch;
	JComboBox combo;
	Vector<String> com;
	JTable table;
	DefaultTableModel model;


	Map<String, Std> stdlist = new HashMap<>();
	public StudentManagement(){
		//���Ͽ��� ���� ������ �о����
		openData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setLayout(null);
		
		//���鿡 ���� ��ư��
		btnInsert = new JButton("�߰�");
		btnSearch = new JButton("�˻�");
		btnDelete = new JButton("����");
		btnExit = new JButton("����");
		btnInsert.addActionListener(this);
		btnSearch.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		
		JPanel pnl = new JPanel(new GridLayout(0,1,0,10));
		pnl.add(btnInsert);
		pnl.add(btnSearch);
		pnl.add(btnDelete);
		pnl.add(btnExit);
		pnl.setBounds(10,50,80,400);
		
		pnlInsert = new JPanel();
		pnlInsert.setBounds(120,50,450,400);
		pnlInsert.setLayout(null);
		pnlInsert.setBorder(BorderFactory.createLineBorder(Color.black));
		
		pnlSearch = new JPanel();
		pnlSearch.setBounds(120,50,450,400);
		
		pnlLbl = new JPanel();
		pnlLbl.setLayout(new GridLayout(0,1,0,40));
		pnlLbl.add(new JLabel(""));
		pnlLbl.add(new JLabel("           ��        ��"));
		pnlLbl.add(new JLabel("           ��        ��"));
		pnlLbl.add(new JLabel("           ��        ��"));
		pnlLbl.add(new JLabel("           ��ȭ��ȣ"));
		pnlLbl.add(new JLabel("           ��        ��"));
		pnlLbl.add(new JLabel(""));
		
		pnlTF = new JPanel(new GridLayout(0,1,0,30));
		tfID = new JTextField();
		tfMajor = new JTextField();
		tfName = new JTextField();
		tfPhone = new JTextField();
		tfAddr = new JTextField();
		pnlTF.add(new JLabel(""));
		pnlTF.add(tfID);
		pnlTF.add(tfName);
		pnlTF.add(tfMajor);
		pnlTF.add(tfPhone);
		pnlTF.add(tfAddr);
		pnlTF.add(new JLabel(""));
		btnInsert2 = new JButton("�߰�");
		btnInsert2.addActionListener(this);
		pnlLbl.setBounds(60,5,100,350);
		pnlTF.setBounds(180,5,200,350);
		btnInsert2.setBounds(100,330,280,40);
		pnlInsert.add(btnInsert2,"South");
		pnlInsert.add(pnlLbl,"West");
		pnlInsert.add(pnlTF);
		
		pnlDelete = new JPanel();
		pnlDelete.setBounds(120,50,450,400);
		JLabel lblD = new JLabel("�й�");
		pnlDelete.add(lblD);
		tfIDDel = new JTextField(10);
		btnDelete2 = new JButton("����");
		btnDelete2.addActionListener(this);
		pnlDelete.add(tfIDDel);
		pnlDelete.add(btnDelete2,"North");
		btnDelete2.setBounds(300,150,100,40);
		tfIDDel.setBounds(135,150,150,40);
		lblD.setBounds(80,150,100,40);
		pnlDelete.setLayout(null);
		pnlDelete.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel title = new JLabel("�л� ���� ���α׷�");
		title.setFont(new Font("Serif",Font.BOLD,30));
		title.setBounds(160,0,450,50);
		
		
		pnlSearch.setLayout(null);
		pnlSearch.setBorder(BorderFactory.createLineBorder(Color.black));
		com = new Vector<>();
		com.add("�й�");
		com.add("�̸�");
		com.add("����");
		com.add("��ȭ��ȣ");
		com.add("�ּ�");
		combo = new JComboBox(com);
		combo.setBounds(30,30,120,40);
		tfSearch = new JTextField();
		tfSearch.setBounds(160,30,190,41);
		btnSearch2 = new JButton("�˻�");
		btnSearch2.setBounds(350,30,80,40);
		btnSearch2.addActionListener(this);
		pnlSearch.add(combo);
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch2);
		Vector contents = new Vector();
		model = new DefaultTableModel(contents, com);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(30,80,400,300);
		pnlSearch.add(sp);
		
		
		add(title);
		add(pnl);
		add(pnlInsert);
		setVisible(true);
	}
	//�˻� ȭ�鿡 ��� �����͸� �����ش�.
	void showAllData(){
		model.setRowCount(0);
		if(stdlist.size()>0){
			Vector<String> row;
			for(Map.Entry<String, Std> e : stdlist.entrySet()){
				row = new Vector<String>();
				row.add(e.getKey());
				row.add(e.getValue().getName());
				row.add(e.getValue().getMajor());
				row.add(e.getValue().getPhone());
				row.add(e.getValue().getAddr());
				model.addRow(row);
			}
		}
	}
	//���Ͽ��� �����͸� �ҷ��´�.
	void openData(){
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("Student.txt");
			br = new BufferedReader(fr);
			String data = null;
			String[] split = null;
			Std std2 = null;
			while((data = br.readLine())!=null){
				split = data.split("/");
				std2 = new Std(split[1], split[2], split[3], split[4]);
				stdlist.put(split[0], std2);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br!=null){
						br.close();
				}
				if(fr!= null){
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//�����Ϳ� ������ ���� �ÿ� �����Ѵ�.
	void saveData(){
		FileWriter fw=null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("Student.txt");
			pw = new PrintWriter(fw);
			for(Map.Entry<String, Std> e:stdlist.entrySet()){
				Std st = e.getValue();
				pw.println(e.getKey()+"/"+st.getName()+"/"+st.getMajor()+"/"+st.getPhone()+"/"+st.getAddr());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pw!=null){
					pw.close();
				}
				if(fw!=null){
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		remove(pnlInsert);
		remove(pnlSearch);
		remove(pnlDelete);
		if(e.getSource()==btnInsert){
			add(pnlInsert);
		}else if(e.getSource()==btnSearch){
			showAllData();
			tfSearch.setText("");
			add(pnlSearch);
		}else if(e.getSource()==btnDelete){
			add(pnlDelete);
		}else if(e.getSource()==btnExit){
			int chk = JOptionPane.showConfirmDialog(this, "���� �Ͻðڽ��ϱ�?", "", JOptionPane.OK_CANCEL_OPTION);
			if(chk==JOptionPane.OK_OPTION){
				System.exit(0);
			}
		}else if(e.getSource()==btnInsert2){
			if(tfID.getText().equals("")||tfName.getText().equals("")
					||tfMajor.getText().equals("")||tfPhone.getText().equals("")||tfAddr.getText().equals("")){
				JOptionPane.showMessageDialog(this, "�ʼ������� ��� �Է��ϼ���");
			}else{
				if(stdlist.containsKey(tfID.getText())){
					JOptionPane.showMessageDialog(this, "�ش� ID�� �̹� ������Դϴ�.");
					tfID.setText("");
					tfName.setText("");
					tfMajor.setText("");
					tfPhone.setText("");
					tfAddr.setText("");
				}else{
					stdlist.put(tfID.getText(), 
							new Std(tfName.getText(), tfMajor.getText(), tfPhone.getText(), tfAddr.getText()));
					tfID.setText("");
					tfName.setText("");
					tfMajor.setText("");
					tfPhone.setText("");
					tfAddr.setText("");
					JOptionPane.showMessageDialog(this, "�߰��Ǿ����ϴ�.");
					saveData();
				}
			}
			add(pnlInsert);
			tfID.selectAll();
			tfName.selectAll();
			tfMajor.selectAll();
			tfPhone.selectAll();
			tfAddr.selectAll();
			tfID.requestFocus();
		}else if(e.getSource()==btnDelete2){
			if(tfIDDel.getText()==""){
				JOptionPane.showMessageDialog(this, "�й��� �Է��ϼ���");
			}else{
				if(stdlist.remove(tfIDDel.getText())==null){
					JOptionPane.showMessageDialog(this, "�ش��ϴ� �й��� �����ϴ�.");
				}else{
					JOptionPane.showMessageDialog(this, tfIDDel.getText()+"�� �л����� ������ �Ϸ�Ǿ����ϴ�.");
					tfIDDel.setText("");
					saveData();
				}
			}
			
			add(pnlDelete);
			tfIDDel.selectAll();
			tfIDDel.requestFocus();
		}else if(e.getSource()==btnSearch2){
			showAllData();
			if(!tfSearch.getText().equals("")){
				if(combo.getSelectedIndex()==0){
					for(Map.Entry<String, Std> e2:stdlist.entrySet()){
						if(e2.getKey().equals(tfSearch.getText())){
							setSearchedData(e2);
						}
					}
				}else if(combo.getSelectedIndex()==1){
					for(Map.Entry<String, Std> e2:stdlist.entrySet()){
						if(e2.getValue().getName().equals(tfSearch.getText())){
							setSearchedData(e2);
						}
					}
				}else if(combo.getSelectedIndex()==2){
					for(Map.Entry<String, Std> e2:stdlist.entrySet()){
						if(e2.getValue().getMajor().equals(tfSearch.getText())){
							setSearchedData(e2);
						}
					}
					
				}else if(combo.getSelectedIndex()==3){
					for(Map.Entry<String, Std> e2:stdlist.entrySet()){
						if(e2.getValue().getPhone().equals(tfSearch.getText())){
							setSearchedData(e2);
						}
					}
					
				}else if(combo.getSelectedIndex()==4){
					for(Map.Entry<String, Std> e2:stdlist.entrySet()){
						if(e2.getValue().getAddr().equals(tfSearch.getText())){
							setSearchedData(e2);
						}
					}
				}
				if(model.getRowCount()==stdlist.size()){
					JOptionPane.showMessageDialog(this, "�˻��� �����Ͱ� �����ϴ�.");
				}
			}
				
			add(pnlSearch);
			tfSearch.selectAll();
			tfSearch.requestFocus();
		}
		repaint();
		revalidate();
		
	}
	//�˻��� ����� �� ��� �����͸� �����ش�.
	void setSearchedData(Map.Entry<String, Std> e2){
		String[] str = new String[5];
		model.setRowCount(0);
		str[0] = e2.getKey();
		str[1] = e2.getValue().getName();
		str[2] = e2.getValue().getMajor();
		str[3] = e2.getValue().getPhone();
		str[4] = e2.getValue().getAddr();
		model.addRow(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentManagement();
	}
}
