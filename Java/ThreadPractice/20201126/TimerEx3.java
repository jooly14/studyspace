import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerEx3 extends JFrame{
	JButton btn;
	int x = 235;
	int y = 60;
	Timer timer;
	JLabel lbl;
	boolean left = true;
	public TimerEx3(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		JButton blue = new JButton();
		blue.setBackground(Color.blue);
		blue.setBounds(235,180,10,100);
		JButton red = new JButton();
		red.setBackground(Color.red);
		red.setBounds(x,y,10,100);
		pnl.add(blue);
		pnl.add(red);
		add(pnl);
		
		timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(left){
				x -= 6;
				if(x<0){
					left = false;
				}
			}else{
				x += 6;
				if(x>470){
					left = true;
				}
			}
			red.setLocation(x,y);	
			}
		});
		timer.start();
		
		btn = new JButton("¸ØÃã");
		btn.setPreferredSize(new Dimension(100,45));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((JButton)e.getSource()).getText().equals("ÀçµµÀü")){
					x = 235;
					red.setLocation(x,y);
					btn.setText("¸ØÃã");
					pnl.remove(lbl);
					pnl.repaint();
					timer.start();
				}else{
					timer.stop();
					if(x<250&&x>220){
						lbl = new JLabel("¼º°ø");
						lbl.setFont(new Font("Serif",Font.BOLD,30));
						lbl.setBounds(210,0,100,50);
						pnl.add(lbl);
						pnl.repaint();
					}else{
						lbl = new JLabel("½ÇÆÐ");
						lbl.setFont(new Font("Serif",Font.BOLD,30));
						lbl.setBounds(210,0,100,50);
						pnl.add(lbl);
						pnl.repaint();
					}
					btn.setText("ÀçµµÀü");	
				}
			}
		});
		add(btn,"South");

		
		setVisible(true);
	}
	public static void main(String[] args) {
		new TimerEx3();
	}
}
