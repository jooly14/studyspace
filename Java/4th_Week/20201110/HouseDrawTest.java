import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
class HouseDrawPnl extends JPanel{
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.gray);
		g2.setStroke(new BasicStroke(5));
		g2.drawLine(70, 110, 140, 60);
		g2.drawLine(70, 100, 140, 50);
		g2.drawLine(140, 60, 210, 110);
		g2.drawLine(140, 50, 210, 100);
		g2.drawLine(80, 105, 80, 190);
		g2.drawLine(80, 190, 195, 190);
		g2.drawLine(198, 105, 198, 190);
		g2.drawRect(150, 155, 20,35);
		g2.drawRect(110, 115, 20,20);
	}
}
public class HouseDrawTest extends JFrame{
	public HouseDrawTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		add(new HouseDrawPnl());
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HouseDrawTest();
	}

}
