import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiceTest extends JFrame implements ActionListener{
	int dice1;
	int dice2;
	public DiceTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,300);
		add(new DicePnl());
		JButton btn = new JButton("랜덤 주사위");
		add(btn,"South");
		btn.addActionListener(this);
		setVisible(true);
	}
	class DicePnl extends JPanel{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(2));
			g2.drawRoundRect(30, 50, 100, 100, 20, 20);
			g2.drawRoundRect(180, 50, 100, 100, 20, 20);
			if(dice1==0){
				
			}else{
				drawDice(g);
			}
		}
		void drawDice(Graphics g){
			if(dice1==1){
				g.fillOval(75, 95, 10, 10);
			}else if(dice1==2){
				g.fillOval(50, 95, 10, 10);
				g.fillOval(100, 95, 10, 10);
			}else if(dice1==3){
				g.fillOval(75, 70, 10, 10);
				g.fillOval(50, 120, 10, 10);
				g.fillOval(100, 120, 10, 10);
			}else if(dice1==4){
				g.fillOval(50, 70, 10, 10);
				g.fillOval(100, 70, 10, 10);
				g.fillOval(50, 120, 10, 10);
				g.fillOval(100, 120, 10, 10);
			}else if(dice1==5){
				g.fillOval(75, 95, 10, 10);
				g.fillOval(50, 70, 10, 10);
				g.fillOval(100, 70, 10, 10);
				g.fillOval(50, 120, 10, 10);
				g.fillOval(100, 120, 10, 10);
			}else if(dice1==6){
				g.fillOval(50, 95, 10, 10);
				g.fillOval(100, 95, 10, 10);
				g.fillOval(50, 70, 10, 10);
				g.fillOval(100, 70, 10, 10);
				g.fillOval(50, 120, 10, 10);
				g.fillOval(100, 120, 10, 10);
			}
			int n = 150;
			if(dice2==1){
				g.fillOval(75+n, 95, 10, 10);
			}else if(dice2==2){
				g.fillOval(50+n, 95, 10, 10);
				g.fillOval(100+n, 95, 10, 10);
			}else if(dice2==3){
				g.fillOval(75+n, 70, 10, 10);
				g.fillOval(50+n, 120, 10, 10);
				g.fillOval(100+n, 120, 10, 10);
			}else if(dice2==4){
				g.fillOval(50+n, 70, 10, 10);
				g.fillOval(100+n, 70, 10, 10);
				g.fillOval(50+n, 120, 10, 10);
				g.fillOval(100+n, 120, 10, 10);
			}else if(dice2==5){
				g.fillOval(75+n, 95, 10, 10);
				g.fillOval(50+n, 70, 10, 10);
				g.fillOval(100+n, 70, 10, 10);
				g.fillOval(50+n, 120, 10, 10);
				g.fillOval(100+n, 120, 10, 10);
			}else if(dice2==6){
				g.fillOval(50+n, 95, 10, 10);
				g.fillOval(100+n, 95, 10, 10);
				g.fillOval(50+n, 70, 10, 10);
				g.fillOval(100+n, 70, 10, 10);
				g.fillOval(50+n, 120, 10, 10);
				g.fillOval(100+n, 120, 10, 10);
			}
		}
	}
	public static void main(String[] args) {
		new DiceTest();
	}
	void randomDice(){
		dice1 =(int)(Math.random()*6)+1;
		dice2 =(int)(Math.random()*6)+1;
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		randomDice();
	}
}
