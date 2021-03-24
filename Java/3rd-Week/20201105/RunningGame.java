import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//버튼이 달리는 게임을 구현
//엔터를 누르면 랜덤하게 3개의 버튼 중 하나가 앞으로 나아간다.
//이동하는 거리도 랜덤으로 설정
//빨간 선에 먼저 닿는 버튼이 승리
public class RunningGame extends JFrame implements KeyListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JLabel lbl;
	public RunningGame(){
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		pnl.requestFocus();
		pnl.setFocusable(true);
		pnl.addKeyListener(this);
		pnl.setLayout(null);
		btn1 = new JButton();
		btn2 = new JButton();
		btn3 = new JButton();
		btn1.setBackground(Color.RED);
		btn2.setBackground(Color.blue);
		btn3.setBackground(Color.green);
		btn1.setBounds(10,50,50,50);
		btn2.setBounds(10,150,50,50);
		btn3.setBounds(10,250,50,50);
		lbl = new JLabel();
		lbl.setBounds(180, 250,100,200);

		pnl.add(lbl);
		pnl.add(btn1);
		pnl.add(btn2);
		pnl.add(btn3);
		
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("달리기 게임");
		
		add(pnl);
		setVisible(true);
	}
	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		arg0.setColor(Color.red);
		arg0.drawLine(400, 40, 400, 380);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RunningGame();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		Point p1 = null;
		Point p2 = null;
		Point p3 = null;
		if(keyCode==KeyEvent.VK_ENTER){
			p1 = btn1.getLocation();
			p2 = btn2.getLocation();
			p3 = btn3.getLocation();
			int num = (int)(Math.random()*3);
			int distance = (int)(Math.random()*41);
			if(p1.x>=350||p2.x>=350||p3.x>=350){
				
			}else{
				if(num==0){
					p1.x = p1.x+distance;
					btn1.setLocation(p1.x, p1.y);
				}else if(num==1){
					p2.x = p2.x+distance;
					btn2.setLocation(p2.x, p2.y);
				}else if(num==2){
					p3.x = p3.x+distance;
					btn3.setLocation(p3.x, p3.y);
				}
				
				if(p1.x>=350){
					lbl.setText("레드팀 승리!!");
					repaint();
				}else if(p2.x>=350){
					lbl.setText("블루팀 승리!!");
					repaint();
				}else if(p3.x>=350){
					lbl.setText("그린팀 승리!!");
					repaint();
				}
			}
			
		}
		
		
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
