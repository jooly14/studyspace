import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PizzaFrame1 extends JFrame {
	public PizzaFrame1() {
		setTitle("MyFrame");
		setSize(600,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1 = new JPanel();	//한번에 바꾸기 알트 쉬프트 알
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p2.add(new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오."));
		p3.add(new JButton("콤보 피자"));
		p3.add(new JButton("포테이토 피자"));
		p3.add(new JButton("불고기 피자"));
		p1.add(p2);
		p1.add(p3);
		add(p1);
		p1.setBackground(Color.RED);
		p2.setBackground(Color.BLUE);
		p3.setBackground(Color.YELLOW);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PizzaFrame1();
	}

}
