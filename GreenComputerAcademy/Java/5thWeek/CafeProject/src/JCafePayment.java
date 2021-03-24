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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

class JCafePayment extends JDialog implements ActionListener{
	JButton btnCard1,btnCard2,btnCash1,btnCash2,btnPayment,btnGoBack,btnStemp1,btnStemp2;
	JTextField tfInstallment,tfCardNumber;
	JButton btnReceipts,btnProofOfExpenditure,btnNull;
	JPanel pnlCash,pnlCard;
	DefaultTableModel model;
	int useStempCnt,userStemp,coffeeCnt;
	String userPhoneNum;
	boolean payment;
	JCafeMain jc;
	
	void init(){// 컴포넌트 추가& 이벤트 추가
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
	public JCafePayment(JCafeMain jc) {//모델 넘겨받고 UI 설정, 전역변수처리
		super(jc,true);
		this.jc = jc;
		model=jc.model;
		for(int i=0;i<jc.tableOrderList.getRowCount();i++)// 주문되는 음료 수량 저장
			coffeeCnt+=Integer.parseInt((String) jc.tableOrderList.getValueAt(i,1));
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
	
	void clickCash(){// 현금버튼 클릭 이벤트
		btnCard1.setBackground(Color.white);
		btnCash1.setBackground(Color.pink);
		this.remove(pnlCard);
		this.add(pnlCash);
		repaint();
		revalidate();
	}
	void clickCard(){// 카드버튼 클릭 이벤트
		btnCard2.setBackground(Color.pink);
		btnCash2.setBackground(Color.white);
		this.remove(pnlCash);
		this.add(pnlCard);
		repaint();
		revalidate();
	}
	void clickReceipts(){// 현금영수증 개인버튼 클릭 이벤트
		btnProofOfExpenditure.setBackground(Color.WHITE);
		btnReceipts.setBackground(Color.pink);
		repaint();
		revalidate();
	}
	void clickProofOfExpenditure(){// 현금영수증 사업자버튼 클릭 이벤트
		btnProofOfExpenditure.setBackground(Color.pink);
		btnReceipts.setBackground(Color.WHITE);
		repaint();
		revalidate();
	}
	void clickStemp(){//스템프버튼 클릭 이벤트
		JCafeUseStamp jus=new JCafeUseStamp(this);
		if(jus.save){//스템프사용 완료되면 실행될 조건문
			model=jus.model;
			useStempCnt=jus.useStemp*5;	//사용한 스템프 갯수
			userStemp=jus.stempNum;		//남은 스템프 갯수
			userPhoneNum=jus.userNumber;//사용자 전화번호
			coffeeCnt=jus.coffeeCnt;	//커피 수
		}
	}
	void clickPayment(){// 결제버튼 클릭 이벤트
		JCafeSaveSalesData.saveSalesData(model);
		new JCafeDaySaleData(jc, this, model);// JCafeDaySaleData폴더에 파일명(당일날짜)로 데이터 저장하는 클래스
		payment=true; // 결제 했는지 안했는지 저장
		if(userPhoneNum==null){ //번호입력 후 전역변수로 빼주는 조건문
			JCafePhoneNum jcpn=new JCafePhoneNum(this);
			userPhoneNum=jcpn.getPhoneNum();
		}
		new JCafeUseStempToSave(userPhoneNum,userStemp);//스탬프 갯수 데이터화(파일에 저장)
		new JCafeStempAdd(userPhoneNum, (coffeeCnt - (useStempCnt/5) ) ); // 스템프 추가 (스탬프로 결제한 커피 수 만큼 스탬프 쌓이지않음)
	}
	void clickGoBack(){// 이전화면버튼 클릭 이벤트
		dispose();
		payment=false;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnStemp1||e.getSource()==btnStemp2) clickStemp();	//스템프 버튼
		if(e.getSource()==btnCash1||e.getSource()==btnCash2) clickCash();	// 현금버튼
		if(e.getSource()==btnCard1||e.getSource()==btnCard2) clickCard();	// 카드버튼
		if(e.getSource()==btnPayment)clickPayment();// 결제버튼
		if(e.getSource()==btnGoBack) clickGoBack(); // 이전화면 버튼
		if(e.getSource()==btnProofOfExpenditure) clickProofOfExpenditure(); // 사업자 지출증빙 버튼
		if(e.getSource()==btnReceipts) clickReceipts(); // 개인 현금영수증 버튼
	}
}