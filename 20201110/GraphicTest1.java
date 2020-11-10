import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GraphicPanel1 extends JPanel{
	int pX=10;
	String str = "안녕하세요? 자바 프로그래머 여러분";
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getX() {
		return pX;
	}
	public void setX(int x) {
		this.pX = x;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawString(str, 10, 10);
		g.drawLine(10, 20, 110, 20);
		g.drawRect(pX, 30, 100, 100);
		
	}
}
public class GraphicTest1 extends JFrame implements ActionListener{
	JButton leftBtn;
	JButton rightBtn;
	JButton applyBtn;
	JTextField tf;
	GraphicPanel1 gPnl;
	public GraphicTest1(){
		JPanel panel = new JPanel();
		leftBtn = new JButton("왼쪽");
		rightBtn = new JButton("오른쪽");
		applyBtn = new JButton("적용");
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		applyBtn.addActionListener(this);
		tf = new JTextField(10);
		
		panel.add(tf);
		panel.add(applyBtn);
		panel.add(leftBtn);
		panel.add(rightBtn);
		
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gPnl = new GraphicPanel1();
		add(panel,"South");
		add(gPnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicTest1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==leftBtn){
			gPnl.setX(gPnl.getX()-20);
		}else if(e.getSource()==rightBtn){
			gPnl.setX(gPnl.getX()+20);
		}else if(e.getSource()==applyBtn){
			gPnl.setStr(tf.getText());
			tf.selectAll();
			tf.requestFocus();
		}
		gPnl.repaint();
	}

}
