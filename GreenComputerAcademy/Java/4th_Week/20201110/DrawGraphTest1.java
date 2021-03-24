import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawGraphTest1 extends JFrame{
	public DrawGraphTest1(){
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new DrawGraphPnl());
		setVisible(true);
	}
	class DrawGraphPnl extends JPanel{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.drawLine(10, 10, 10, 250);
			g2.drawLine(10, 250, 270, 250);
			
			g2.drawLine(10, 10, 20, 10);
			g2.drawLine(10, 40, 20, 40);
			g2.drawLine(10, 70, 20, 70);	//6
			g2.drawLine(10, 100, 20, 100);
			g2.drawLine(10, 130, 20, 130);
			g2.drawLine(10, 160, 20, 160); //3
			g2.drawLine(10, 190, 20, 190);
			g2.drawLine(10, 220, 20, 220);
			
			g2.drawLine(270, 250, 270, 240);
			g2.drawLine(180, 250, 180, 240);
			g2.drawLine(90, 250, 90, 240);
			
			g2.drawString("8", 2, 15);
			g2.drawString("7", 2, 45);
			g2.drawString("6", 2, 75);
			g2.drawString("5", 2, 105);
			g2.drawString("4", 2, 135);
			g2.drawString("3", 2, 165);
			g2.drawString("2", 2, 195);
			g2.drawString("1", 2, 225);
			g2.drawString("0", 2, 255);
			
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(10, 160, 135, 160);
			g2.drawLine(135, 160, 270, 40);
			g2.setColor(Color.red);
			g2.drawLine(10, 130, 135, 100);
			g2.drawLine(135, 100, 270, 190);
			g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{8}, 0));
			g2.drawLine(10, 70, 135, 100);
			g2.drawLine(135, 100, 270, 130);
			g2.setColor(Color.BLACK);
			g2.drawLine(10, 160, 135, 130);
			g2.drawLine(135, 130, 270, 160);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawGraphTest1();
	}

}
