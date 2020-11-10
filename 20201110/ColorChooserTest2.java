import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorChooserTest2 extends JFrame implements MouseListener,ActionListener{
	Color selectedColor;
	JButton btn;
	Point p1 = new Point();
	Point p2 = new Point();
	int check =0;
	MyPnl3 pnlC;
	public ColorChooserTest2(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pnlN = new JPanel();
		pnlC = new MyPnl3();
		pnlC.setLayout(null);
		
		JLabel lbl = new JLabel("현재색상    ");
		btn = new JButton();
		btn.setPreferredSize(new Dimension(30,26));
		JButton colorChooserBtn = new JButton("색상선택");
		colorChooserBtn.addActionListener(this);
		
		pnlN.add(lbl);
		pnlN.add(btn);
		pnlN.add(colorChooserBtn);
		pnlC.addMouseListener(this);
		add(pnlN,"North");
		add(pnlC);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ColorChooserTest2();
	}
	class MyPnl3 extends JPanel{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(selectedColor);
			g2.setStroke(new BasicStroke(3));
			g2.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(check==0){
			p1.x = e.getX();
			p1.y = e.getY();
			check++;
		}else if(check==1){
			p2.x = e.getX(); 
			p2.y = e.getY(); 
			repaint();
			check=0;
		}
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
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		selectedColor = JColorChooser.showDialog(this, "색상 선택", Color.white);
		btn.setBackground(selectedColor);
	}

}
