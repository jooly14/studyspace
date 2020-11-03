import java.awt.ComponentOrientation;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutTest extends JFrame{
	public BoxLayoutTest(){
		setTitle("BoxLayout Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		makeButton(panel, "Button1");
		makeButton(panel, "Button2");
		makeButton(panel, "Button3");
		makeButton(panel, "B4");
		makeButton(panel, "Long Button5");
		add(panel);
		
		pack();
		setVisible(true);
	}
	
	public void makeButton(JPanel panel, String text){
		JButton btn = new JButton(text);
		btn.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		panel.add(btn);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoxLayoutTest();
	}

}
