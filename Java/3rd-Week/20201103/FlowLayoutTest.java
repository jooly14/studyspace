import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutTest extends JFrame{
	public FlowLayoutTest(){
		setTitle("FlowLayout Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.RIGHT, 50, 20);
		panel.setLayout(fl);
		
		panel.add(new JButton("Button1"));
		panel.add(new JButton("Button2"));
		panel.add(new JButton("Button3"));
		panel.add(new JButton("B4"));
		JButton btn5 = new JButton("Long Button5");
		panel.add(btn5);
		panel.setPreferredSize(new Dimension(300,300));
		btn5.setPreferredSize(new Dimension(200,200));
		//panel.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);	//왜 안되지??
		add(panel);
		
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlowLayoutTest();
	}

}
