import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Rambda3 extends JFrame{
	JButton btn;
	public Rambda3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		btn = new JButton("Å¬¸¯");
		
		btn.addActionListener((e)->{JOptionPane.showMessageDialog(this, "µÎµÕ");});
		
		add(btn);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Rambda3();
	}
}
