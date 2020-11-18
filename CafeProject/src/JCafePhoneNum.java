import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JCafePhoneNum extends JDialog implements ActionListener{
	JButton[] pN_btn = new JButton[15];
	String[] pN_buttons = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "", "0", "정정", "적립", "초기화", "취소"};
	JLabel[] pN_lb = new JLabel[13];
	String[] pN_dash = {"_","_","_","-","_","_","_","_","-","_","_","_","_"};
	JPanel pN_pnl, pN_pnlN;
	JLabel[] pN_numbers;
	int pN_cnt;
	void init(){
		this.setSize(250,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pN_pnl = new JPanel(new GridLayout(0, 3, 1, 1));
		for(int i = 0; i < pN_buttons.length; i++){
		pN_btn[i] = new JButton(pN_buttons[i]);
		pN_btn[i].addActionListener(this);
		pN_pnl.add(pN_btn[i]);
		}
		
		pN_pnlN = new JPanel();
		for(int i = 0; i < pN_dash.length; i++){
		pN_lb[i] = new JLabel(pN_dash[i]);
		pN_pnlN.add(pN_lb[i]);
		}
		
		
		this.add(pN_pnl);
		this.add(pN_pnlN, "North");
		
		this.setVisible(true);
	}
	JCafePhoneNum(JCafeStempTable jcst){
		super(jcst,true);
		init();
	}
/*	JCafePhoneNum(JCafeStempTable jcst){
		super(jcst,true);
		init();
	}*/
	
	String getPhoneNum(){
		String phoneNumber="";
		for(int i=0;i<pN_numbers.length;i++)
			phoneNumber=phoneNumber+pN_numbers[i].getText();
		return phoneNumber;
	}
	void getNum(){					//'-'가 들어간 배열을 '-'를 뺴고 배열에 담음
		pN_numbers = new JLabel[11];
		int j=0;
		for(int i=0;i<pN_numbers.length;i++,j++){
			if(i==3||i==8)j++;
			pN_numbers[i] = pN_lb[j];
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pN_cbtn = (JButton)e.getSource();	
		
		getNum();
		
		if(pN_cbtn == pN_btn[11]){			//'정정'
			pN_cnt--;
			pN_numbers[pN_cnt].setText("_");
		}else if(pN_cbtn == pN_btn[12]){		//'적립'
			int pN_stamp = 1;
			
			int pN_dashCount = 0;
			
			for(int i = 0; i < 11; i++){
				String a = pN_numbers[i].getText();
				if(a == "_"){
					pN_dashCount++;
				}
			}
			if(pN_dashCount > 1){
				JOptionPane.showMessageDialog(this, "번호를 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
			}else if(pN_dashCount == 0){
//				[ 10,000 단위로 스템프 1개  (예)-> 20,000~29,000원사이는 스템프2개 ]
//				int x = 0;
//				x = x + 10000;
//				if(moneyTotal >= (x)){
//					stamp++;
//				}
				JOptionPane.showMessageDialog(null, "적립되었습니다. \n 스탬프 : "+ pN_stamp);
				dispose();
			}
			
			
		}else if(pN_cbtn == pN_btn[13]){		//'초기화'
			for(int i = 0; i < pN_numbers.length; i++){
				pN_numbers[i].setText("_");
				pN_cnt = 0;
			}
		}else if(pN_cbtn == pN_btn[14]){		//'취소'
			dispose();
		}else if(pN_cbtn == pN_btn[9]){		//빈칸(아무기능없음)
			pN_numbers[pN_cnt].setText("_");
		}else if(pN_cbtn == pN_btn[10]){		//숫자 '0'
			pN_numbers[pN_cnt].setText(pN_cbtn.getActionCommand());
			pN_cnt++;
		}else{									//숫자'1~9' == btn[0]~btn[8]
			pN_numbers[pN_cnt].setText(pN_cbtn.getActionCommand());
			pN_cnt++;
		}
	}
}
