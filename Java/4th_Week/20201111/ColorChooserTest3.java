import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;

class ColorDialog extends JDialog{
	public ColorDialog(ColorChooserTest3 frame){
		super(frame, true);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JColorChooser jColorCh = new JColorChooser();
		add(jColorCh);
		setVisible(true);
	}
}
public class ColorChooserTest3 extends JFrame implements ActionListener{
	JButton btn;
	public ColorChooserTest3(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		btn = new JButton("색상 선택기");
		btn.addActionListener(this);
		add(btn);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ColorChooserTest3();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new ColorDialog(this);
		//JColorChooser.showDialog(this, "", Color.black);
	}

}
