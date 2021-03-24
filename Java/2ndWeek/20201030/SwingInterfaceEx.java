import javax.swing.*;
import java.awt.event.*;
public class SwingInterfaceEx implements ActionListener{
	JButton btn;
	
	public SwingInterfaceEx(){
		JFrame f = new JFrame();
		btn = new JButton("클릭");
		btn.addActionListener(this);
		f.add(btn);
		f.setSize(300,200);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		//클릭 이벤트가 발생하면 작동한다.
		System.out.println("눌러졌다.");
	}
	public static void main(String args[]){
		new SwingInterfaceEx();
	}
}