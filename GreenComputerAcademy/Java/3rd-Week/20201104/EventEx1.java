import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class EventEx1 extends JFrame implements ActionListener{
	JButton btn;
	JButton btn2;
	public EventEx1(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn = new JButton("클릭");
		btn.addActionListener(this);
		btn2 = new JButton("남쪽버튼");
		btn2.addActionListener(this);
		
		add(btn);
		add(btn2,"South");
		setSize(300,200);
		setVisible(true);
	}
	void btnClick(){
		System.out.println("반갑");
		
	}
	void btnClick2(){
		System.out.println("어서오고");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//클릭이벤트가 발생했을 때 작동하는 이벤트
		if(e.getSource()==btn){
			btnClick();
			
		}else if(e.getSource()==btn2){
			btnClick2();
			
		}
		
	}
	
	public static void main(String[] args) {
		new EventEx1();
	}
}
