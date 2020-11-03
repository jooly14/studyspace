import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TitleBorderEx extends JFrame{
	public TitleBorderEx(){
		Border border = BorderFactory.createTitledBorder("버튼틀");
		JPanel panel  = new JPanel();
		panel.setBorder(border);
		JButton btn = new JButton("버튼");
		panel.add(btn);
		this.add(panel);
		
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TitleBorderEx();
	}

}
