import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

public class ThreadEx6 extends JFrame implements KeyListener{
	JPanel pnl;
	JButton btnG;
	int g_x;
	public ThreadEx6(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,600);
		pnl = new JPanel();
		pnl.setLayout(null);
		pnl.addKeyListener(this);
		pnl.setFocusable(true);
		pnl.requestFocus();
		add(pnl);
		btnG = new JButton();
		btnG.setBounds(g_x,500,50,50);
		btnG.setBackground(Color.green);
	
		new EnemyThread(this,Color.cyan,0,100).start();
		new EnemyThread(this,Color.red,100,200).start();
		pnl.add(btnG);
		
		
	
		setVisible(true);
	}
	public static void main(String[] args) {
		new ThreadEx6();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			new MyThread6(this).start();
			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			g_x -=10;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			g_x +=10;
		}
		if(g_x<0){
			g_x = 0;
		}else if(g_x>230){
			g_x = 230;
		}
		btnG.setLocation(g_x,500);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	void addToPnl(JButton btn){
		pnl.add(btn);
	}
	public int getG_x() {
		return g_x;
	}
	public void setG_x(int g_x) {
		this.g_x = g_x;
	}
}

class EnemyThread extends Thread{
	ThreadEx6 main;
	boolean left;
	int y;
	int x;
	int sleepSec;
	Color color;
	JButton btn;
	public EnemyThread(ThreadEx6 main,Color color,int y,int sleepSec){
		this.main = main;
		this.color = color;
		this.y = y;
		this.sleepSec =sleepSec;
		btn = new JButton();
		btn.setSize(50,20);
		btn.setBackground(color);
		main.pnl.add(btn);
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(sleepSec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(left){
				x -= 10;
				if(x<0){
					left = false;
				}
			}else{
				x += 10;
				if(x>230){
					left = true;
				}
			}
			btn.setLocation(x, y);
			
		}
	}
}

class MyThread6 extends Thread{
	ThreadEx6 m;
	int y = 500;
	JButton btn;
	int x;
	public MyThread6(ThreadEx6 main) {
		m = main;
		x = m.getG_x()+20;
		btn = new JButton();
		btn.setBounds(x,y,10,10);
		btn.setBackground(Color.red);
		m.addToPnl(btn);
	}
	@Override
	public void run() {
		while(y>-50){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			y-=10;
			btn.setLocation(x,y);
			
		}
		
	}
	
}