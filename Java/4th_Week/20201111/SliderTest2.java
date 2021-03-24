import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest2 extends JFrame implements ChangeListener{
	JSlider slid;
	SliderPnl pnl;
	int transparency = 255;
	public SliderTest2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		slid = new JSlider(0,255);
		slid.setPaintTicks(true);
		slid.setPaintLabels(true);
		slid.setMajorTickSpacing(255);
		slid.setMinorTickSpacing(20);
		slid.addChangeListener(this);
		slid.setValue(255);
		add(slid,"North");
		pnl = new SliderPnl();
		add(pnl);
		setVisible(true);
	}
	class SliderPnl extends JPanel{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Color color = new Color(255, 0, 0, transparency);
			g.setColor(color);
			g.fillRect(0, 0, 400, 400);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SliderTest2();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		transparency = slid.getValue();
		repaint();
	}

}
