import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AbsoluteLayoutTest extends JFrame{
	public AbsoluteLayoutTest(){
		setSize(500,500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for(int i = 0;i<30;i++){
			int x = (int)(Math.random()*(500-15));
			int y = (int)(Math.random()*(500-15));
			JLabel la = new JLabel((i+1)+"");
			la.setForeground(Color.MAGENTA);	//글씨 색 바꾸기
			la.setLocation(x, y);
			la.setSize(15,15);
			add(la);
		}
		//jframe의 숨겨진 panel이 있다. =>contentPane
		this.getContentPane().setBackground(Color.yellow);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AbsoluteLayoutTest();
	}

}
