import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
class GraphicPnl2 extends JPanel{
	int num=0;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.red);
		if(num==0){
			g.drawOval(110, 30, 50, 50);
		}else if(num==1){
			g.drawRect(110, 30, 50, 50);
			
		}else if(num==2){
			g.fillOval(110, 30, 50, 50);
			
		}
	}
}
public class GraphicTest2 extends JFrame implements ActionListener{
	GraphicPnl2 pnlC;
	JButton btnOval;
	JButton btnRect;
	JButton btnFillOval;
	 
	public GraphicTest2(){
		JPanel pnlN = new JPanel();
		btnOval = new JButton("Oval");
		btnRect = new JButton("Rectangle");
		btnFillOval = new JButton("FillOval");
		btnOval.addActionListener(this);
		btnRect.addActionListener(this);
		btnFillOval.addActionListener(this);
		pnlN.add(btnOval);
		pnlN.add(btnRect);
		pnlN.add(btnFillOval);
		
		
		pnlC = new GraphicPnl2();
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(pnlC);
		add(pnlN,"North");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicTest2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOval){
			pnlC.setNum(0);
		}else if(e.getSource()==btnRect){
			pnlC.setNum(1);
		}else if(e.getSource()==btnFillOval){
			pnlC.setNum(2);
		}
		pnlC.repaint();
	}

}
