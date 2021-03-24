import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowManPanel extends JPanel{
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.yellow);
		g.fillOval(20, 30, 200, 200);
		g.setColor(Color.black);
		g.drawArc(50, 80, 50, 50, 180, -180);
		g.drawArc(140, 80, 50, 50, 180, -180);
		g.drawArc(70, 130, 100, 70, 180, 180);
	}
}
public class SnowManFace extends JFrame{
	public SnowManFace(){
		setSize(280,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new SnowManPanel());
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SnowManFace();
	}

}
