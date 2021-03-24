import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEx3 extends JFrame implements ActionListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JPanel panel1;
	JPanel panel2;
	public EventEx3(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new JPanel();
		btn1 = new JButton();
		panel1.setLayout(null);
		btn1.setBounds(230,215,30,30);
		btn1.setBackground(Color.green);
		panel1.setBackground(Color.yellow);
		panel1.add(btn1);
		
		panel2 = new JPanel();
		btn2 = new JButton("크게");
		btn3 = new JButton("작게");
		btn4 = new JButton("왼쪽");
		btn5 = new JButton("오른쪽");
		btn6 = new JButton("아래로");
		btn7 = new JButton("위로");
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		panel2.add(btn2);
		panel2.add(btn3);
		panel2.add(btn4);
		panel2.add(btn5);
		panel2.add(btn6);
		panel2.add(btn7);
		
		add(panel1);
		add(panel2,"South");
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Dimension di = btn1.getSize();
		int w = di.width;
		int h = di.height;
		Point p = btn1.getLocation();
		int x = p.x;
		int y = p.y;
		
		if(e.getSource()==btn2){
			w = w+10;
			h = h+10;
			x = x-5;
			y = y-5;
		}else if(e.getSource()==btn3){
			w = w-10;
			h = h-10;
			x = x+5;
			y = y+5;
		}else if(e.getSource()==btn4){
			x = x-10;
		}else if(e.getSource()==btn5){
			x = x+10;
		}else if(e.getSource()==btn6){
			y = y+10;
		}else if(e.getSource()==btn7){
			y = y-10;
		}
		btn1.setSize(w,h);		//공통된 작업의 경우 if문 밖으로 뺄수 있다.
		btn1.setLocation(x, y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventEx3();
	}

}
