import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JCafeUseStamp extends JDialog implements ActionListener{
	JCafeMain jc;
	JCafePayment jp;
	boolean save;
	JPanel pnl;
	JTable table;
	int changeLine;
	int stampNum=33;
	int useStamp; // 스탬프 몇개 사용했는지 담음
	JLabel lblStamp; // 스템프 몇개 남았는지 표현
	String[][]strPrice; //메뉴 테이블에서 하나의 가격을 담음
	String[][]strTable;		//메뉴 테이블을 String배열로 담은것 > 스템프 사용 후의 테이블값을 담을 것
	String[] tableHeader={"메뉴","수량","가격"};	//헤더
	DefaultTableModel model;
	String userNumber=null;
	String userStampCnt=null;
	
	JButton btnEnter,btnGoBack;
	JButton btnUse,btnComplete,btnCancel;
	JTextField tfPhoneNum;
	
	void init(){
		table=new JTable(model);
		btnCancel=new JButton("취소");
		btnEnter=new JButton("확인");
		btnUse=new JButton("사용");
		btnComplete=new JButton("완료");
		btnGoBack=new JButton("취소");
		
		btnCancel.addActionListener(this);
		btnEnter.addActionListener(this);
		btnUse.addActionListener(this);
		btnComplete.addActionListener(this);
		btnGoBack.addActionListener(this);
		
		strPrice=new String[3][table.getRowCount()];
		strTable=new String[3][table.getRowCount()];
		
		for(int i=0;i<table.getRowCount();i++){
			int n=Integer.parseInt((String) table.getValueAt(i,1));//n은 커피 수량
			for(int j=0;j<3;j++){
				strTable[j][i]=(String)table.getValueAt(i,j);
				if(j==2){
					int a=Integer.parseInt(strTable[j][i])/Integer.parseInt(strTable[1][i]);
					strPrice[j][i]=""+a;
				}
			}
		}
		tfPhoneNum=new JTextField(10);
	}
	public JCafeUseStamp(JCafePayment jcp) {
		super(jcp,true);
		model=jcp.jc.model;
		init();
		
		pnl=new JPanel();
		JLabel lbl=new JLabel("전화번호");
		pnl.add(lbl);
		pnl.add(tfPhoneNum);
		pnl.add(btnEnter);
		pnl.add(btnCancel);
		
		this.add(pnl);
		this.pack();
		this.setLocale(null);
		setVisible(true);
	}
	void stempEnter(){
		this.remove(pnl);
		setSize(500,550);
		JScrollPane sp=new JScrollPane(table);
		pnl=new JPanel(null);
		lblStamp=new JLabel(tfPhoneNum.getText()+"님 가능한 스템프 : " + stampNum +" 개");
		
		sp.setBounds(10, 10, 460, 450);
		btnUse.setBounds(100,465,80,30);
		btnComplete.setBounds(190,465,80,30);
		btnCancel.setBounds(280,465,80,30);
		
		pnl.add(sp);
		pnl.add(btnUse);
		pnl.add(btnComplete);
		pnl.add(btnCancel);
		
		this.add(pnl);
		this.add(lblStamp,"South");
	}
	// 번호입력후 확인누르면 나오는 화면
	void stempFindUserNumber(){
		String[]stempCnt=null;
		String[]phoneNum=null;
		String strStemp="";
		String strNum="";
		try {
			FileReader fr = new FileReader(new File("JCafeStempData\\JCafeStempData.txt"));
			BufferedReader br=new BufferedReader(fr);
			
			String l=null;
			while((l=br.readLine())!=null){
				String[] read=l.split("/"); //  br읽은거 한줄씩 /로 끊어서 read배열에 담는다.
				strStemp=strStemp+read[1]+"/"; // read[1]이 무조건 스템프 갯수이므로 (스템프갯수/)를 문자열에 추가
				strNum=strNum+read[0]+"/"; // read[0]이 무조건 번호이므로 (번호/)를 문자열에 추가
			}
			phoneNum=strNum.split("/");//phoneNum배열에 번호들을 하나씩 저장한다.
			stempCnt=strStemp.split("/");//stempCnt배열에 스템프갯수를 하나씩 저장한다.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0;i<phoneNum.length;i++){
			if(phoneNum[i].equals(tfPhoneNum.getText())){
				userNumber=phoneNum[i]; // userNumber에 사용자 번호를 담는다.
				userStampCnt=stempCnt[i];//userStempCnt에 스템프 갯수를 담는다.
			}
		}
	}
	// userNumber   전역	전화번호
	// stempNum 	전역	스탬프갯수
	void clickBtnUse(){
			if(stampNum>=5){
				if((Integer.parseInt(strTable[2][table.getSelectedRow()])>0)){
					useStamp++;
					stampNum-=5;//스템프 깎기
					lblStamp.setText(tfPhoneNum.getText()+"님 가능한 스템프 : " + stampNum +" 개"+"               사용 한 스템프 : "+(useStamp*5)+" 개");
					
					int a=Integer.parseInt(strTable[2][table.getSelectedRow()]);//테이블의 금액
					int b=Integer.parseInt(strPrice[2][table.getSelectedRow()]);//선택된거 한개 금액
					a=a-b; //테이블금액에서 한개금액 뺀거
					
					strTable[2][table.getSelectedRow()]=a+""; // 배열에서 금액 뺀걸로 저장
					table.setValueAt(a, table.getSelectedRow(), 2);// 테이블 보이는거 바꿔주기
					repaint();
					revalidate();
				} else JOptionPane.showMessageDialog(this, "사용할 수 있는 제품이 아닙니다.");
			}else JOptionPane.showMessageDialog(this, "스템프가 부족합니다.");
//		else JOptionPane.showMessageDialog(this, "사용가능한 제품이 아닙니다.");
	}
	// 테이블 선택후 사용버튼 누르면 실행될 이벤트
	void clickBtnComplete(){
		model=new DefaultTableModel(strTable,tableHeader);
		save=true;
		dispose();
	}
	void clickBtnCancel(){
		save=false;
		dispose();
	}
	// 완료 누르면 실행될 이벤트
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEnter){// 번호입력하고 확인누르면
			//회원정보 확인하는 메소드
			stempEnter();
		}else if(e.getSource()==btnGoBack){
			dispose();
		}else if(e.getSource()==btnUse){
			clickBtnUse();
		}else if(e.getSource()==btnComplete){
			clickBtnComplete();
			//
		}else if(e.getSource()==btnCancel){
			clickBtnCancel();
		}
	}
}