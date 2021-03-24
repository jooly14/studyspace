import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class EMailContactsLayout extends JFrame{
	public EMailContactsLayout(){
		setSize(700,420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Border border1 = BorderFactory.createTitledBorder("Name");
		Border border2 = BorderFactory.createTitledBorder("E-Mail");
		JPanel panelNorth, panelCenter,panelSouth;
		panelSouth = new JPanel(new FlowLayout(FlowLayout.TRAILING));	//밑에 붙여진 버튼을 오른쪽으로 붙이기위해서 레이아웃 설정
		
		panelNorth = new JPanel();		//타이틀드볼더를 테두리값으로 넣어줌
		panelCenter = new JPanel(new BorderLayout());
		panelNorth.setBorder(border1);
		panelCenter.setBorder(border2);
		
		//여기서부터 panelNorth작업
		JPanel panel1a = new JPanel();
		JPanel panel1b = new JPanel();	//균형을 위한 빈패널
		JPanel panel1c = new JPanel();
		JPanel panel1d = new JPanel();
		JLabel la1a = new JLabel("이름");
		JTextField tf1a = new JTextField(15);
		panel1a.add(la1a);
		panel1a.add(tf1a);
		JLabel la1b = new JLabel("직책");
		JTextField tf1b = new JTextField(15);
		panel1c.add(la1b);
		panel1c.add(tf1b);
		JLabel la1c = new JLabel("아이디");
		JTextField tf1c = new JTextField(15);
		panel1d.add(la1c);
		panel1d.add(tf1c);
		
		panelNorth.setLayout(new GridLayout(0, 2));
		panelNorth.add(panel1a);
		panelNorth.add(panel1b);	//균형을 위한 빈패널
		panelNorth.add(panel1c);
		panelNorth.add(panel1d);
		panelNorth.add(new JLabel(""));	//간격을 맞추기 위한 빈라벨
		panelNorth.add(new JLabel(""));
		panelNorth.add(new JLabel(""));
		//여기까지 panelNorth작업
		
		//여기서부터 panelCenter작업
		JPanel panel2a = new JPanel();
		panel2a.add(new JLabel("이메일 주소"));
		panel2a.add(new JTextField(43));
		
		
		JPanel panel2b = new JPanel();
		JTextArea tArea = new JTextArea(5,50);
		panel2b.add(tArea);
		
		JPanel panel2c = new JPanel(new FlowLayout(FlowLayout.LEADING));
		panel2c.add(new JLabel("Mail Format:"));
		
		JPanel panel2d = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JRadioButton r1 = new JRadioButton("HTML");
		JRadioButton r2 = new JRadioButton("Plain Text");
		JRadioButton r3 = new JRadioButton("Custom");
		ButtonGroup g =new ButtonGroup();
		g.add(r1);
		g.add(r2);
		g.add(r3);
		panel2d.add(r1);
		panel2d.add(r2);
		panel2d.add(r3);
		
		JPanel panel2East = new JPanel();
		JButton btn2a = new JButton("Add");
		JButton btn2b = new JButton("Edit");
		JButton btn2c = new JButton("Remove");
		JButton btn2d = new JButton("Default");
		panel2East.add(btn2a);
		panel2East.add(btn2b);
		panel2East.add(btn2c);
		panel2East.add(btn2d);
		panel2East.setLayout(new GridLayout(0,1,0,5));
		
		JPanel panel2Center = new JPanel();
		JPanel panel2South = new JPanel(new BorderLayout());
		panel2Center.add(panel2a);
		panel2Center.add(panel2b);
		panel2South.add(panel2c,"North");
		panel2South.add(panel2d);
		
		panelCenter.add(panel2Center);
		panelCenter.add(panel2South,"South");
		panelCenter.add(panel2East,"East");
		//여기까지 panelCenter작업	
		
		JButton btn3a = new JButton("OK");
		JButton btn3b = new JButton("Cancel");
		panelSouth.add(btn3a);
		panelSouth.add(btn3b);
		
		
		add(panelNorth,"North");	//총 세부분으로 나누어 붙이기
		add(panelCenter);
		add(panelSouth,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EMailContactsLayout();
	}

}
