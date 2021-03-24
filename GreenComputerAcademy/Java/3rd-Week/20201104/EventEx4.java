import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEx4 extends JFrame implements ActionListener{
	JButton btn1,btn2,btn3;
	JButton btnV;
	public EventEx4(){
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelN = new JPanel();
		JPanel panelC = new JPanel();
		btn1 = new JButton();
		btn2 = new JButton();
		btn3 = new JButton();
		btnV = new JButton();
		btn1.setBackground(Color.RED);
		btn2.setBackground(Color.BLUE);
		btn3.setBackground(Color.GREEN);
		btn1.setPreferredSize(new Dimension(50,30));
		btn2.setPreferredSize(new Dimension(50,30));
		btn3.setPreferredSize(new Dimension(50,30));
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		panelN.add(btn1);
		panelN.add(btn2);
		panelN.add(btn3);
		panelC.add(btnV);
		panelC.setLayout(null);
		panelC.setBackground(Color.white);
		btnV.setBounds(210,180,60,60);
		
		
		add(panelC);
		add(panelN,"North");
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btn1 == e.getSource()){
			btnV.setBackground(Color.RED);
		}else if(btn2 == e.getSource()){
			btnV.setBackground(Color.blue);
		}else if(btn3 == e.getSource()){
			btnV.setBackground(Color.green);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventEx4();
	}

}
