import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
class EnemyThread1_4 extends Thread{
	JButton btn;
	Thread1_4 main;
	int x = 0;
	int y;
	boolean left = false;
	boolean live = true;
	public EnemyThread1_4(Thread1_4 main,int y) {
		btn = new JButton();
		this.main =main;
		this.y = y;
		btn.setBackground(Color.green);
		btn.setBounds(x,y,50,50);
		main.pnl.add(btn);
	}
	@Override
	public void run() {
		while (live) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!left){
				x+=10;
				if(x>340){
					left = true;
				}
			}else if(left){
				x-=10;
				if(x<0){
					left = false;
				}
			}
			btn.setLocation(x, y);
			
		}
		
	}
}
class MissileThread extends Thread{
	JButton btn;
	Thread1_4 main;
	int x;
	int y;
	public MissileThread(Thread1_4 main,int x, int y) {
		this.main = main;
		btn = new JButton();
		this.x = x+15;
		this.y = y+5;
		btn.setBounds(x,y,5,5);
		main.pnl.add(btn);
	}
	
	@Override
	public void run() {
		while (y>-30) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			y-=10;
			if(x+5>main.en1.x&&x<main.en1.x+50&&y<main.en1.y+30&&y>main.en1.y&&main.en1.live){
				main.en1.live = false;
				main.pnl.remove(main.en1.btn);
				main.pnl.remove(btn);
				main.repaint();
				break;
			}else{
				btn.setLocation(x,y);
			}
		}
		
	}
}

public class Thread1_4 extends JFrame implements KeyListener{
	JButton player;
	JPanel pnl;
	int playerX = 200;
	int playerY = 320;
	EnemyThread1_4 en1;
	public Thread1_4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		
		pnl = new JPanel();
		pnl.setLayout(null);
		player = new JButton();
		player.setBounds(playerX,playerY,30,30);
		player.setBackground(Color.BLACK);
		pnl.add(player);
		pnl.addKeyListener(this);
		
		add(pnl);
		en1 = new EnemyThread1_4(this,10);
		en1.start();
		setVisible(true); 
		pnl.setFocusable(true);
		pnl.requestFocus();
	} 
	public static void main(String[] args) {
		new Thread1_4();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			playerY += 10;
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			playerY -= 10;
		}else if(e.getKeyCode()== KeyEvent.VK_RIGHT){
			playerX += 10;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			playerX -= 10;
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			new MissileThread(this,playerX,playerY).start();
		}
		player.setLocation(playerX, playerY);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
