import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AbsoluteLayoutTest1_2 extends JFrame{
	JPanel panel;
	public AbsoluteLayoutTest1_2(){
		
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.yellow);
		
		add(panel);
		
		JButton btn = new JButton("랜덤생성");
		add(btn,"South");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				makeNum();
			}
		});
		
		setVisible(true);
	}
	
	void makeNum(){
		panel.removeAll();
		for(int i = 0;i<30;i++){
			int x = (int)(Math.random()*480);
			int y = (int)(Math.random()*450);
			JLabel lbl = new JLabel((i+1)+"");
			lbl.setSize(20,20);
			lbl.setLocation(x, y);
			lbl.setForeground(Color.MAGENTA);
			panel.add(lbl);
		}
		panel.repaint();	//화면갱신
		panel.revalidate();	//화면갱신
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AbsoluteLayoutTest1_2();
	}

}
