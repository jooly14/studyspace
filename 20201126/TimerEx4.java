import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerEx4 extends JFrame{
	int r;
	int g;
	int b;
	int width;
	int height;
	int x;
	int y;
	JButton btn;
	Color color = new Color(r,g,b);
	JPanel pnl;
	Timer timer;
	JButton colorBtn;
	Random ran = new Random();
	public TimerEx4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		pnl = new JPanel();
		pnl.setLayout(null);
		
		timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorBtn = new JButton();
				r = ran.nextInt(256);
				g = ran.nextInt(256);
				b = ran.nextInt(256);
				width = ran.nextInt(150);
				height = ran.nextInt(150);
				x = ran.nextInt(450);
				y = ran.nextInt(430);
				colorBtn.setBackground(new Color(r,g,b));
				colorBtn.setBounds(x, y, width, height);
				pnl.add(colorBtn);
				pnl.repaint();
			}
		});
		btn = new JButton("Ω√¿€");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timer.start();
			}
		});
		add(pnl);
		add(btn,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		new TimerEx4();
	}
}
