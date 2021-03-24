import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrameTest8 extends JFrame{
	public MyFrameTest8(){
		setSize(500,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테스트 프레임");
		setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JLabel l1 = new JLabel("자바 호텔에 오신 것을 환영합니다. 숙박일수를 입력하세요.");
		JButton btn1 = new JButton("1명");
		JButton btn2 = new JButton("2명");
		JButton btn3 = new JButton("3명");
		JButton btn4 = new JButton("4명");
		JButton btn5 = new JButton("5명");
		p1.add(l1);
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(btn4);
		p2.add(btn5);
		add(p1);
		add(p2);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrameTest8();
	}	

}
