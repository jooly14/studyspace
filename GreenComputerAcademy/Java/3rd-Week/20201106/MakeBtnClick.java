import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MakeBtnClick extends JFrame implements ActionListener{
	Color btnColor = Color.red;
	Point p1;
	Point p2;
	JButton btnRed;
	JButton btnBlue;
	JButton btnGreen;
	
	public MakeBtnClick(){
		init();
		
	}
	void init(){
		JPanel pnl = new JPanel();
		JPanel pnlS = new JPanel();
		btnRed = new JButton();
		btnRed.setPreferredSize(new Dimension(30,30));
		btnRed.setBackground(Color.red);
		btnBlue = new JButton();
		btnBlue.setPreferredSize(new Dimension(30,30));
		btnBlue.setBackground(Color.blue);
		btnGreen = new JButton();
		btnGreen.setPreferredSize(new Dimension(30,30));
		btnGreen.setBackground(Color.green);
		btnRed.addActionListener(this);
		btnBlue.addActionListener(this);
		btnGreen.addActionListener(this);
		pnlS.add(btnRed);
		pnlS.add(btnBlue);
		pnlS.add(btnGreen);
		
		pnl.setLayout(null);
		pnl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(p1==null){
					p1 = e.getPoint();
				}else{
					p2 = e.getPoint();
					JButton btn = new JButton();
					btn.setBounds(p1.x,p1.y,p2.x-p1.x,p2.y-p1.y);
					btn.setBackground(btnColor);
					pnl.add(btn);
					repaint();
					p1= null;
				}
				
			}
		});
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(pnl);
		add(pnlS,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MakeBtnClick();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnRed){
			btnColor = Color.red;
		}else if(e.getSource()==btnBlue){
			btnColor = Color.blue;
		}else if(e.getSource()==btnGreen){
			btnColor = Color.green;
		}
	}

}
