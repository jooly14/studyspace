import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerEx5 extends JFrame{
	JButton plane;
	JButton missile;
	JButton star;
	int p_x;
	int p_y;
	int m_x;
	int m_y;
	int s_x;
	int s_y;
	Timer timerM;
	Timer timerS;
	Random ran = new Random();
	int point;
	JLabel pointLbl;
	public TimerEx5(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		
		ImageIcon icon = new ImageIcon("puppy1.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		icon = new ImageIcon(img);
		star = new JButton(icon);
		icon = new ImageIcon("missile.png");
		img = icon.getImage();
		img = img.getScaledInstance(100, 70, Image.SCALE_DEFAULT);
		icon = new ImageIcon(img);
		missile = new JButton(icon);
		icon = new ImageIcon("car1.png");
		img = icon.getImage();
		img = img.getScaledInstance(170, 100, Image.SCALE_DEFAULT);
		icon = new ImageIcon(img);
		plane = new JButton(icon);
		star.setBackground(Color.WHITE);
		star.setBorder(null);
		missile.setBackground(Color.WHITE);
		missile.setBorder(null);
		plane.setBackground(Color.WHITE);
		plane.setBorder(null);
		plane.setBounds(p_x,p_y,140,50);
		s_x = ran.nextInt(80)+320;
		s_y = ran.nextInt(380);
		star.setBounds(s_x,s_y,50,50);
		pnl.add(star);
		pnl.setBackground(Color.white);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					p_y += 3;
					if(p_y>400){
						p_y=400;
					}
				}else if(e.getKeyCode()==KeyEvent.VK_UP){
					p_y -= 3;
					if(p_y<0){
						p_y=0;
					}
				}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
					p_x -= 3;
					if(p_x<0){
						p_x=0;
					}
				}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					p_x += 3;
					if(p_x>100){
						p_x=100;
					}
				}else if(e.getKeyCode()==KeyEvent.VK_SPACE){
					if(pnl.getComponentCount()==3){
						m_x = p_x+100;
						m_y = p_y+10;
						missile.setBounds(m_x,m_y,80,30);
						pnl.add(missile);
						timerM.start();
					}
				}
				plane.setLocation(p_x,p_y);
				pnl.repaint();
			}
		});
		
		timerS = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s_x = ran.nextInt(150)+280;
				s_y = ran.nextInt(380);
				star.setLocation(s_x,s_y);
				pnl.repaint();
			}
		});
		timerM = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m_x += 3;
				missile.setLocation(m_x,m_y);
				if(m_x>400){
					pnl.remove(missile);
				}
				if((m_x > s_x-79)&&(m_x < s_x+49)&&(m_y > s_y-29)&&(m_y < s_y+49)){
					point += 10;
					pointLbl.setText(point+"");
					pnl.remove(missile);
					s_x = ran.nextInt(80)+320;
					s_y = ran.nextInt(380);
					star.setBounds(s_x,s_y,50,50);
					timerS.restart();
					repaint();
					timerM.stop();
				}
				repaint();
			}
		});
		
		timerS.start();
		pointLbl = new JLabel(point+"");
		pointLbl.setFont(new Font("Serif",Font.BOLD,20));
		pointLbl.setBounds(450,0,50,50);
		pnl.add(pointLbl);
		pnl.add(plane);
		add(pnl);
		
		setVisible(true);
		this.setFocusable(true);
		this.requestFocus();
	}
	public static void main(String[] args) {
		new TimerEx5();
	}
	
}