import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarGameUseMouse extends JFrame implements MouseListener{
	JLabel lbl;
	public CarGameUseMouse(){
		init();
	}
	void init(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Car Game");
		
		JPanel pnl = new JPanel();
		pnl.addMouseListener(this);
		pnl.setLayout(null);
		
		ImageIcon icon = new ImageIcon("car.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		lbl = new JLabel(icon);
		lbl.setBounds(0,0,160,80);
		pnl.add(lbl);
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CarGameUseMouse();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Point point = e.getPoint();
		lbl.setLocation(point.x-80,point.y-40);
	}

}
