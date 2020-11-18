import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

class JCafePayment extends JDialog implements ActionListener{
	JButton btnCard1,btnCard2,btnCash1,btnCash2,btnPayment,btnGoBack,btnStemp1,btnStemp2;
	JTextField tfInstallment,tfCardNumber;
	JButton btnReceipts,btnProofOfExpenditure,btnNull;
	JPanel pnlCash,pnlCard;
	boolean Receipts;
	
	JCafeMain jc;
	
	void init(){
		pnlCard=new JPanel(null);
		pnlCash=new JPanel(null);
		tfInstallment=new JTextField(3);
		tfCardNumber=new JTextField(10);
		btnCard1=new JButton("카드");
		btnCash1=new JButton("현금");
		btnCard2=new JButton("카드");
		btnCash2=new JButton("현금");
		btnStemp1=new JButton("스템프");
		btnStemp2=new JButton("스템프");
		
		btnReceipts=new JButton("개인");
		btnProofOfExpenditure=new JButton("사업자");
		btnPayment=new JButton("결제");
		btnGoBack=new JButton("이전화면");
		
		btnCard1.addActionListener(this);
		btnCash1.addActionListener(this);
		btnStemp1.addActionListener(this);
		btnCard2.addActionListener(this);
		btnCash2.addActionListener(this);
		btnStemp2.addActionListener(this);

		btnProofOfExpenditure.addActionListener(this);
		btnReceipts.addActionListener(this);
		btnPayment.addActionListener(this);
		btnGoBack.addActionListener(this);
	}
	public JCafePayment(JCafeMain jc) {
		super(jc,true);
		this.jc = jc;
		init();
		setSize(300,330);
		
		
		
		JPanel pnlSouth=new JPanel();
		
		tfInstallment.setText("1");//처음 카드결제 할부 1개월
		btnPayment.setEnabled(true);
		btnCash1.setBounds(15,25,80,50);
		btnCard1.setBounds(105,25,80,50);
		btnStemp1.setBounds(195,25,80,50);
		btnReceipts.setBounds(30,105,100,50);
		btnProofOfExpenditure.setBounds(170,105,100,50);
		//현금결재 화면 좌표
		pnlCash.add(btnCash1);
		pnlCash.add(btnCard1);
		pnlCash.add(btnStemp1);
		pnlCash.add(btnReceipts);
		pnlCash.add(btnProofOfExpenditure);
		//현금결재 화면 추가
		JLabel lblInstallment=new JLabel("개월"); 
		JLabel lblCardNumber=new JLabel("카드번호");

		JTextField tf=new JTextField(10);
		JLabel lbl=new JLabel("원");
		btnCash2.setBounds(15,25,80,50);
		btnCard2.setBounds(105,25,80,50);
		btnStemp2.setBounds(195,25,80,50);
		tfInstallment.setBounds(10, 105, 20, 30);
		tfCardNumber.setBounds(10, 185, 250, 30);
		lblInstallment.setBounds(40,105,60,30);
		lblCardNumber.setBounds(10,155,60,30);
		//카드결재 화면 좌표
		pnlCard.add(lblCardNumber);
		pnlCard.add(lblInstallment);
		pnlCard.add(btnCash2);
		pnlCard.add(btnCard2);
		pnlCard.add(btnStemp2);
		pnlCard.add(tfInstallment);
		pnlCard.add(tfCardNumber);
		//카드결재 화면 추가
		pnlSouth.add(btnPayment);
		pnlSouth.add(btnGoBack);
		btnCard1.setBackground(Color.white);
		btnCash1.setBackground(Color.white);
		btnStemp1.setBackground(Color.white);
		btnStemp2.setBackground(Color.WHITE);
		btnProofOfExpenditure.setBackground(Color.WHITE);
		btnReceipts.setBackground(Color.WHITE);
		
		this.add(pnlCash);
		this.add(pnlSouth,"South");
		
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	void clickCash(){
		btnCard1.setBackground(Color.white);
		btnCash1.setBackground(Color.pink);
		this.remove(pnlCard);
		this.add(pnlCash);
		repaint();
		revalidate();
	}
	void clickCard(){
		btnCard2.setBackground(Color.pink);
		btnCash2.setBackground(Color.white);
		this.remove(pnlCash);
		this.add(pnlCard);
		repaint();
		revalidate();
	}
	void clickReceipts(){
		Receipts=true;
		btnProofOfExpenditure.setBackground(Color.WHITE);
		btnReceipts.setBackground(Color.pink);
		repaint();
		revalidate();
	}
	void clickProofOfExpenditure(){
		Receipts=false;
		btnReceipts.setBackground(Color.WHITE);
		btnProofOfExpenditure.setBackground(Color.pink);
		repaint();
		revalidate();
	}
	
	
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnStemp1||e.getSource()==btnStemp2)
			new UseStemp(this);
		if(e.getSource()==btnCash1||e.getSource()==btnCash2)
			clickCash();
		if(e.getSource()==btnCard1||e.getSource()==btnCard2)
			clickCard();
		if(e.getSource()==btnPayment) 
			new JCafeDaySaleData(jc, this); // 결제완료시 데이터 저장 (파일이름:당일날짜, 저장유형 : 시:분:초/메뉴명/수량/가격)
		if(e.getSource()==btnGoBack)
			dispose();
		if(e.getSource()==btnProofOfExpenditure)
			clickProofOfExpenditure();
		if(e.getSource()==btnReceipts)
			clickReceipts();
	}
}