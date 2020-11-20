import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JCafeMain extends JFrame implements ActionListener{
	JButton[] btnMenu;
	JPanel pnlMenu;
	String[][] strMenu2 = JCafeGetMenuToMakeButton.getInfo("coffe");
	String[] strMenu = new String[strMenu2.length];
	String[] strCnt = new String[strMenu2.length];
	String[] strPrice = new String[strMenu2.length];
	JPanel pnlMain;
	JButton btnManager,btnCancel,btnPayment,btnStemp;
	JTable tableOrderList;
	String[][]strOrderList;
	String[]strOrderListHead={"�̸�","����","�ݾ�"};
	DefaultTableModel model;
	JScrollPane spOrderList;
	boolean loginChk;
	JButton[] categoryBtns = new JButton[5];
	String[] categoryTitle = {"coffe","latte","tea","",""};	
	JPanel pnlCategory;
	JPanel totalPnl;
	JTextField totalTf, cntTf, priceTf;
	
	void init(){
		setSize(600,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnMenu=new JButton[25];
		JCafeGetMenuToMakeButton.setData(strMenu2,strMenu,strCnt,strPrice);
		btnManager=new JButton("������");
		btnCancel=new JButton("���");		
		btnPayment=new JButton("����");
		btnStemp=new JButton("������");
		
		pnlMenu=new JPanel();
		
		model=new DefaultTableModel(strOrderList, strOrderListHead)
		{
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};//���̺� �����ȵǰ� �ϴ°�
		for(int i=0;i<categoryTitle.length;i++){
			categoryBtns[i] = new JButton(categoryTitle[i]);
			categoryBtns[i].addActionListener(this);
		}
		
		tableOrderList=new JTable(model);
		spOrderList=new JScrollPane(tableOrderList);
		for(int i=0;i<25;i++){
			if(strMenu.length>i){
				btnMenu[i]=new JButton(strMenu[i]);
				btnMenu[i].addActionListener(this);
			}
			 else
				btnMenu[i]=new JButton();
		}
	}
	public JCafeMain() {
		init();
		
		totalPricePnl();
		JPanel pnlNorth=new JPanel();
		pnlMenu=new JPanel(new GridLayout(0,5,2,2));
		JPanel pnlSouth=new JPanel(new GridLayout(0,2));
		
		btnStemp.addActionListener(this);
		btnManager.addActionListener(this);
		btnCancel.addActionListener(this);
		btnPayment.addActionListener(this);
		
		JPanel pnlSouthRight=new JPanel(new GridLayout(2,2,5,5));
		pnlSouthRight.add(btnManager);
		pnlSouthRight.add(btnStemp);
		pnlSouthRight.add(btnPayment);
		pnlSouthRight.add(btnCancel);
		JPanel pnlTable=new JPanel(new BorderLayout());
		pnlTable.add(spOrderList);
		pnlTable.add(totalPnl, "South");
		pnlSouth.add(pnlTable);
		pnlSouth.add(pnlSouthRight);
		
		for(int i=0;i<25;i++)
			pnlMenu.add(btnMenu[i]);
		JLabel lblMain=new JLabel(new ImageIcon("JCafe logo.png"));
		pnlNorth.add(lblMain);
		//600 x 800������
		this.setLayout(null);
		pnlNorth.setBounds(10,10,560,100);
		this.add(pnlNorth);
		
		pnlMenu.setBounds(10, 170, 560, 350);		
		this.add(pnlMenu);
		pnlSouth.setBounds(10,530,560,220);
		this.add(pnlSouth);
		
		pnlCategory = new JPanel(new GridLayout(1,0));
		for(int i=0;i<categoryBtns.length;i++){
			if(!(categoryBtns[i].getText().equals(""))){
				pnlCategory.add(categoryBtns[i]);
			}
		}
		pnlCategory.setBounds(10,120,560,40);
		this.add(pnlCategory);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	void logIn(){loginChk = true;}
	void logOut(){loginChk = false;}
	
	void clickMenu(ActionEvent e) {
		int currentRow = -1;
		int intCnt = 1;
		for (int j = 0; j < strMenu.length; j++) {
			if (e.getSource() == btnMenu[j]) {
				cntTf.setText((intCnt+(Integer.parseInt(cntTf.getText())))+"");		//��ư�� ������ ���� total ������ ������
				priceTf.setText(((Integer.parseInt(strPrice[j]))+(Integer.parseInt(priceTf.getText())))+"");	//��ư�� ������ ���� total ������ ������
				for (int i = 0; i < tableOrderList.getRowCount(); i++) {
					if (tableOrderList.getValueAt(i, 0).equals(strMenu[j])) {
						currentRow = i;
						break;
					}
				} // �̹� �ִ��� Ȯ��! ������ �ִ� ���� ��ġ�� currentRow�� ����

				if (currentRow != -1) { // �����̶� �ִٸ�
					String cnt = (Integer.parseInt((String) tableOrderList.getValueAt(currentRow, 1)) + 1) + ""; // ����
					String price = (Integer.parseInt((String) tableOrderList.getValueAt(currentRow, 2))
							+ (Integer.parseInt((String) strPrice[j]))) + ""; // ����
					tableOrderList.setValueAt(cnt, currentRow, 1);
					tableOrderList.setValueAt(price, currentRow, 2);
				} else {
					String[] menu = { strMenu[j], strCnt[j], strPrice[j] };
					model.addRow(menu);
				}
			}
		}
	}
	void selRowDelete(){		//���õ� Row ����
		boolean isSelect = false;
		for(int i = 0; i < tableOrderList.getRowCount(); i++){
			isSelect = tableOrderList.isRowSelected(i);
			if(isSelect == true){	//���õ� Row�� ������ error �ȳ���
				int selRow = tableOrderList.getSelectedRow();
				model.removeRow(selRow);
			}else{
				model.setNumRows(0);
			}
		}
	}
	void clickManager(){//������ Ŭ�� �̺�Ʈ
		if(loginChk==false){
			new JCafeManagerLoginDialog(this);
		}else{
			new JCafeManagerMenu(this);
		}
	}
	void totalPricePnl(){ //�հ�ݾ� ǥ��
		totalPnl = new JPanel(new GridLayout(0,3));
		totalTf = new JTextField("�հ�");
		cntTf  = new JTextField("0");
		priceTf = new JTextField("0");
		totalTf.setEditable(false);
		cntTf.setEditable(false);
		priceTf.setEditable(false);
		totalPnl.add(totalTf);
		totalPnl.add(cntTf);
		totalPnl.add(priceTf);
	}
	void clickPayment(){ //���� Ŭ�� �̺�Ʈ
		JCafePayment jcp=new JCafePayment(this);
		if(jcp.payment){
			model.setNumRows(0);
		}
	}
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPayment) clickPayment();//����
		else if(e.getSource()==btnManager) clickManager();//������
		else if(e.getSource()==btnStemp) new JCafeStempTable(this); // ������
		else if(e.getSource() == btnCancel)selRowDelete(); // ���
		else if(((JButton)(e.getSource())).getParent().equals(pnlCategory)){//�޴��� 
			strMenu2 = JCafeGetMenuToMakeButton.getInfo(((JButton)e.getSource()).getText());
			strMenu = new String[strMenu2.length];
			strCnt = new String[strMenu2.length];
			strPrice = new String[strMenu2.length];
			JCafeGetMenuToMakeButton.setData(strMenu2, strMenu, strCnt, strPrice);
			pnlMenu.removeAll();
			for (int i = 0; i < 25; i++) {
				if (strMenu.length > i) {
					btnMenu[i] = new JButton(strMenu[i]);
					btnMenu[i].addActionListener(this);
					pnlMenu.add(btnMenu[i]);
				} else
					btnMenu[i] = new JButton();
			}
			pnlMenu.setLayout(new GridLayout(0, 5, 2, 2));
			pnlMenu.setBounds(10, 170, 560, 350);
		}else clickMenu(e);// �޴�Ŭ��
		repaint();
		revalidate();
	}
	
	public static void main(String[] args) {
		new JCafeMain();
		}
}