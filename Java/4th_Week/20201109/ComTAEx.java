import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComTAEx extends JFrame{
	
	public ComTAEx(){
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField tf = new JTextField();
		JTextArea ta = new JTextArea();
		
		JScrollPane sp = new JScrollPane(ta);
		
		add(tf,"North");
		add(sp);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComTAEx();
	}

}
