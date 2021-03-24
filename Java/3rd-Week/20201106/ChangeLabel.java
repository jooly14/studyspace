import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChangeLabel extends JFrame{
	String strEn = "Don't cry before you are hurt.";
	String strKr = "다치기도 전에 울지말라";
	JLabel lbl;
	public ChangeLabel(){
		init();
	}
	void init(){
		setLayout(new FlowLayout());
		setTitle("My Frame");
		setSize(700,120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl = new JLabel(strEn);
		lbl.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 50));
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lbl.setText(strEn);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lbl.setText(strKr);	
			}
		});
		add(lbl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangeLabel();
	}

}
