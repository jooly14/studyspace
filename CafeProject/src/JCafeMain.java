import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JCafeMain extends JFrame implements ActionListener{
	JButton[] btnMenu;
	JPanel pnlMenu;
	String[] strMenu={"아메리카노","아이스 아메리카노","카페 라떼","아이스 카페라떼","바닐라 라떼","아이스 바닐라 라떼","토피넛 라떼","아이스 토피넛 라떼"};
	JPanel pnlMain;
	JButton btnManager,btnCancel,btnPayment,btnNull;
	JTable tableOrderList;
	String[][]strOrderList;
	String[]strOrderListHead={"이름","수량","금액"};
	DefaultTableModel model;
	JScrollPane spOrderList;
	boolean loginChk;
	void init(){
		setTitle("JCafe Management System");
		setSize(600,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnMenu=new JButton[25];
		
		btnManager=new JButton("관리자");
		btnCancel=new JButton("취소");		
		btnPayment=new JButton("결제");
		
		btnNull=new JButton();
		pnlMenu=new JPanel();
		
		model=new DefaultTableModel(strOrderList, strOrderListHead);
		
		
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
		
		JPanel pnlNorth=new JPanel();
		JPanel pnlMenu=new JPanel(new GridLayout(0,5,2,2));
		JPanel pnlSouth=new JPanel(new GridLayout(0,2));
		
		btnManager.addActionListener(this);
		btnCancel.addActionListener(this);
		btnPayment.addActionListener(this);
		
		JPanel pnlSouthRight=new JPanel(new GridLayout(2,2,5,5));
		pnlSouthRight.add(btnManager);
		pnlSouthRight.add(btnNull);
		pnlSouthRight.add(btnPayment);
		pnlSouthRight.add(btnCancel);
		JPanel pnlTable=new JPanel(new BorderLayout());
		pnlTable.add(spOrderList);
		pnlSouth.add(pnlTable);
		pnlSouth.add(pnlSouthRight);
		
		for(int i=0;i<25;i++)
			pnlMenu.add(btnMenu[i]);
		JLabel lblMain=new JLabel(new ImageIcon("JCafe logo.png"));
		pnlNorth.add(lblMain);
		//600 x 800사이즈
		this.setLayout(null);
		pnlNorth.setBounds(10,10,560,100);
		this.add(pnlNorth);
		
		pnlMenu.setBounds(10,120,560,400);
		this.add(pnlMenu);
		pnlSouth.setBounds(10,530,560,220);
		this.add(pnlSouth);
		JPanel pnl=new JPanel();
		pnl.setBounds(150, 150, 300, 500);
		this.add(pnl);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JCafeMain();
		}
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPayment){
			JCafePayment cp=new JCafePayment(this);
			cp.setBounds(150,150,300,500);
			String[] ex1 = {"아이스 아메리카노","2","4100"};
			String[] ex2 = {"고구마 라떼","5","4100"};
			
			model.addRow(ex1);
			model.addRow(ex2);
			
			SaveSalesData.saveSalesData(model);	//결제 이후 결제내역이 판매내역에 추가(어떤 메뉴가 얼마나 팔렸는지 집계)
			repaint();
			revalidate();
		}else if(e.getSource()==btnManager){
			if(loginChk==false){
				new JCafeManagerLoginDialog(this);
			}else{
				new JCafeManagerMenu(this);
			}
		}else if(e.getSource()== btnCancel){
			int row = model.getRowCount();
			for(int i=0;i<row;i++){
				model.removeRow(0);
			}
		}
	}
	
	//JCafeManagerLoginDialog에서 사용
	void logIn(){
		loginChk = true;
	}
	void logOut(){
		loginChk = false;
	}
}
