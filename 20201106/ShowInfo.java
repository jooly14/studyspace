import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowInfo extends JFrame implements ActionListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	
	JPanel pnl1;
	JPanel pnl2;
	JPanel pnl3;
	

	public ShowInfo(){
		init();
	}
	void init(){
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pnlN = new JPanel();
		pnlN.setLayout(new GridLayout(0,3));
		pnl1 = new JPanel(new GridLayout(0,1));
		pnl1.setBackground(Color.PINK);
		pnl1.setPreferredSize(new Dimension(150,200));
		pnl2 = new JPanel(new GridLayout(0,1));
		pnl2.setBackground(Color.pink);
		pnl2.setPreferredSize(new Dimension(150,200));
		pnl3 = new JPanel(new GridLayout(0,1));
		pnl3.setBackground(Color.pink);
		pnl3.setPreferredSize(new Dimension(150,200));
		
		
		
		JLabel id = new JLabel("아이디 : abcd");
		JLabel pw = new JLabel("비밀번호 : 1234");
		JLabel name = new JLabel("이   름 : 최홍석");
		JLabel address = new JLabel("주   소 : 부산");
		JLabel asset = new JLabel("자   산 : 10,000,000,000");
		JLabel loan = new JLabel("대   출: 9,900,000,000");
		JLabel vip = new JLabel("VIP 거래");
		JLabel normal = new JLabel("일반 거래");
		
		pnl1.add(id);
		pnl1.add(pw);
		pnl1.add(name);
		pnl1.add(address);
		pnl2.add(asset);
		pnl2.add(loan);
		pnl3.add(vip);
		pnl3.add(normal);
		
		
		btn1 = new JButton("회원정보");
		btn2 = new JButton("자산정보");
		btn3 = new JButton("고객센터");
		btn1.setBackground(Color.GREEN);
		btn2.setBackground(Color.YELLOW);
		btn3.setBackground(Color.YELLOW);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		
		pnlN.add(btn1);
		pnlN.add(btn2);
		pnlN.add(btn3);
		
		
		add(pnlN,"North");
		add(pnl1);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ShowInfo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		remove(pnl1);
		remove(pnl2);
		remove(pnl3);
		String select = e.getActionCommand();
		if(select.equals(btn1.getText())){
			btn1.setBackground(Color.green);
			btn2.setBackground(Color.yellow);
			btn3.setBackground(Color.yellow);
			add(pnl1);
			repaint();
			revalidate();
		}else if(select.equals(btn2.getText())){
			btn1.setBackground(Color.yellow);
			btn2.setBackground(Color.green);
			btn3.setBackground(Color.yellow);
			add(pnl2);
			repaint();
			revalidate();
			
		}else if(select.equals(btn3.getText())){
			btn1.setBackground(Color.yellow);
			btn2.setBackground(Color.yellow);
			btn3.setBackground(Color.green);
			add(pnl3);
			repaint();
			revalidate();
		}
		
	}

}
