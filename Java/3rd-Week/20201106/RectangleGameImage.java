import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ImageLbl extends JLabel{
	public ImageLbl() {
		// TODO Auto-generated constructor stub
		ImageIcon icon = new ImageIcon("car.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		setIcon(icon);
	}
}



public class RectangleGameImage extends JFrame{
	JPanel pnl;
	public RectangleGameImage(){
		setTitle("Rectangle Game");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnl = new JPanel();
		pnl.setLayout(null);
		pnl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JLabel lbl = new ImageLbl();
				lbl.setBounds(e.getX()-40, e.getY()-40, 100, 100);
				pnl.add(lbl);
				revalidate();
				repaint();
			}
		});
		
		add(pnl);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RectangleGameImage();
	}

}
