import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Rectangle{
	int x,y,w,h;
}
class RectangleGamePanel extends JPanel{
	Rectangle[] array = new Rectangle[100];
	int index = 0;
	public RectangleGamePanel(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				index++;
				if(index>=100){
					return;
				}else{
					array[index] = new Rectangle();
					array[index].x = e.getX();
					array[index].y = e.getY();
					array[index].w = 20;
					array[index].h = 20;
					repaint();
				}
				
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(Rectangle r : array){
			if(r!=null){
				g.drawRect(r.x, r.y, r.w, r.h);
			}
		}
	}
}

public class RectangleGame extends JFrame{
	public RectangleGame(){
		setTitle("Rectangle Game");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new RectangleGamePanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RectangleGame();
	}

}
