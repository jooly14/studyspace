import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomMakeRectangle extends JFrame implements ActionListener{
	Color[] colors = new Color[13];
	JPanel pnl;
	JButton makeBtn;
			
	public RandomMakeRectangle(){
		init();
	}
	void init(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeBtn = new JButton("생성");
		makeBtn.setBackground(Color.LIGHT_GRAY);
		makeBtn.addActionListener(this);
		
		colors[0] = Color.BLACK;
		colors[1] = Color.BLUE;
		colors[2] = Color.CYAN;
		colors[3] = Color.DARK_GRAY;
		colors[4] = Color.GRAY;
		colors[5] = Color.GREEN;
		colors[6] = Color.lightGray;
		colors[7] = Color.MAGENTA;
		colors[8] = Color.ORANGE;
		colors[9] = Color.PINK;
		colors[10] = Color.RED;
		colors[11] = Color.white;
		colors[12] = Color.yellow;
		
		pnl = new JPanel();
		pnl.setLayout(null);
		
		add(pnl);
		add(makeBtn,"North");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RandomMakeRectangle();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==makeBtn){
			JButton btn = new JButton();
			int colorIndex =(int)(Math.random()*13);
			int x =(int)(Math.random()*460);
			int y =(int)(Math.random()*400);
			int w =(int)(Math.random()*100)+1;
			int h =(int)(Math.random()*100)+1;
			btn.setBounds(x,y,w,h);
			btn.setBackground(colors[colorIndex]);
			btn.addActionListener(this);
			pnl.add(btn);
			repaint();
			
		}else{
			pnl.remove((JButton)(e.getSource()));
			repaint();
		}
	}

}
