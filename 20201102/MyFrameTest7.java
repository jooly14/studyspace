import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrameTest7 extends JFrame{
	public MyFrameTest7(){
		setSize(500,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테스트 프레임");
		setLayout(new FlowLayout());
		JLabel l1 = new JLabel("인간에게 주어진 최상의 선물은 마음껏 웃을 수 있다는 것이다.");
		JLabel l2 = new JLabel("가능한 목표라고 하더라도 그것을 꿈꾸고 상상하는 순간 이미 거기에 다가가 있는 것이다.");
		JLabel l3 = new JLabel("상상력은 생존의 힘이다.");
		add(l1);
		add(l2);
		add(l3);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrameTest7();
	}

}
