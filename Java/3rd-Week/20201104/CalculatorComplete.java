import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorComplete extends JFrame implements ActionListener{
	String[] str = {"7","8","9","/","4","5","6","*","1","2","3","-","0","+/-","=","+"};
	JTextField tf;
	int fNum;	//숫자를 처음 입력받고 그 뒤에는 fnum+snum한 값을 저장한다.
	int sNum;
	boolean fNumCheck;	//fnum에 숫자가 들어가있는지 확인한다. 들어있는 경우 snum에 숫자 저장
	String oper1="";	//연산자를 미리 받아서 저장해둠
	String accumulate = "";	//숫자만 입력될 경우 누적시킨 뒤에 나중에 int형으로 변환
	public CalculatorComplete(){
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(300,450);	//pack을 사용
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
		tf = new  JTextField(20);
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(tf);
		
	/*	JButton btnC = new JButton("C");
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnC.setPreferredSize(new Dimension(50,50));
		panel2.add(btnC);
	*/	
		
		JPanel panel3 = new JPanel();
		JButton btnC = new JButton("C");
		btnC.addActionListener(this);
		btnC.setPreferredSize(new Dimension(50,50));
		panel3.add(btnC);
		JLabel la1 = new JLabel("");
		JLabel la2 = new JLabel("");
		JLabel la3 = new JLabel("");
		panel3.add(la1);
		panel3.add(la2);
		panel3.add(la3);
		makeButton(panel3);
		panel3.setLayout(new GridLayout(0, 4, 5, 5));
		
		
		panel.add(panel1);
		//panel.add(panel2);
		panel.add(panel3);
		add(panel);
		pack();
		setVisible(true);
	}
	public void makeButton(JPanel panel){
		for(int i = 0; i<str.length;i++){
			JButton btn = new JButton(str[i]);
			btn.setPreferredSize(new Dimension(40,50));
			btn.addActionListener(this);
			panel.add(btn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculatorComplete();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnString = e.getActionCommand();	//버튼을 만들자마자 붙여넣었기 때문에 getsource를 사용할수 없었다.
		
		//숫자를 변수에 저장하는 if문
		//+-*/=연산자를 넣었을 경우 누적되었던 숫자를 fnum, snum에 넣는다. fnumcheck을 만든 이유는 fnum이 없는 값일때 0을 주면 숫자에 0이 들어가는 있는 경우 작동하지 않는다. 그래서 fnum이 있는 값인지 여부를 확인하기 위해서 fnumcheck변수를 넣었다.
		if(btnString.equals("+")||btnString.equals("-")||btnString.equals("*")||btnString.equals("/")||btnString.equals("=")){
			if(!accumulate.equals("")){
				if(fNumCheck){
					sNum = Integer.parseInt(accumulate); 
					accumulate = "";
				}else{
					fNum = Integer.parseInt(accumulate);
					fNumCheck = true;
					accumulate = "";
				}
				
			}
		}else if(btnString.equals("C")){
			fNum = 0;
			sNum = 0;
			fNumCheck = false;
			accumulate = "";
			
		}else{
			accumulate = accumulate +btnString;
			tf.setText(accumulate);	//연산자가 아닌 숫자만 찍힐 때 텍스트필드에 숫자 출력. 이경우를 제외하고는 다음 if문에서 텍스트 출력 담당
		}
		
		//연산자를 입력받았을 때 연산자 처리를 위한 if문
		//textfield에 출력하는 기능을 넣었다.
		if(btnString.equals("+")||btnString.equals("-")||btnString.equals("*")||btnString.equals("/")){
			if(oper1.equals("")){
			}else{
				if(oper1=="+"){
					fNum = fNum+sNum ;
				}else if(oper1=="-"){
					fNum = fNum-sNum;
				}else if(oper1=="*"){
					fNum = fNum*sNum;
				}else if(oper1=="/"){
					fNum = fNum/sNum;
				}
			}
			tf.setText(fNum+"");
			oper1 = btnString;
		}else if(btnString.equals("=")){
			if(oper1.equals("")){
			}else{
				if(oper1=="+"){
					fNum = fNum+sNum ;
				}else if(oper1=="-"){
					fNum = fNum-sNum;
				}else if(oper1=="*"){
					fNum = fNum*sNum;
				}else if(oper1=="/"){
					fNum = fNum/sNum;
				}
			}
			
			tf.setText(fNum+"");
			
		}else if(btnString.equals("C")){
			oper1 = "";
			tf.setText(accumulate);
		}
			
			
		
	}

}
