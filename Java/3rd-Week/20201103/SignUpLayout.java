import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpLayout extends JFrame{
	public SignUpLayout(){
		setTitle("회원가입 폼!!");
		setSize(500,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelWest = new JPanel();
		panelWest.setLayout(new GridLayout(0,1));
		panelWest.add(new JLabel("아이디"));
		panelWest.add(new JLabel("비밀번호"));
		panelWest.add(new JLabel("성별"));
		panelWest.add(new JLabel("HP"));
		panelWest.add(new JLabel("자기소개"));
		
		JPanel panelSouth = new JPanel();
		JButton btn1 = new JButton("전송");
		JButton btn2 = new JButton("취소");
		panelSouth.add(btn1);
		panelSouth.add(btn2);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(0, 1));
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER,30,22));
		panel1.add(new JTextField(15));
		panel1.add(new JLabel("                                        "));
		panel1.add(new JLabel("*8자이내"));
		
		JPanel panel2  = new JPanel(new FlowLayout(FlowLayout.CENTER,30,22));
		panel2.add(new JTextField(15));
		panel2.add(new JLabel(""));
		panel2.add(new JLabel("성명"));
		panel2.add(new JTextField(10));
		
		JPanel panel3  = new JPanel(new FlowLayout(FlowLayout.CENTER,10,22));
		JRadioButton r1 = new JRadioButton("남자");
		JRadioButton r2 = new JRadioButton("여자");
		ButtonGroup g =new ButtonGroup();
		g.add(r1);
		g.add(r2);
		panel3.add(r1);
		panel3.add(r2);
		panel3.add(new JLabel("                                       "));
		panel3.add(new JLabel("취미"));
		panel3.add(new JCheckBox("여행"));
		panel3.add(new JCheckBox("잠자기"));
		
		JPanel panel4  = new JPanel(new FlowLayout(FlowLayout.CENTER,10,22));
		String[] str = {"010","011","019","014"};
		panel4.add(new JComboBox(str));
		panel4.add(new JLabel("-"));
		panel4.add(new JTextField(5));
		panel4.add(new JLabel("-"));
		panel4.add(new JTextField(5));
		panel4.add(new JLabel("                                      "));
		panel4.add(new JLabel("*필수입력"));
		
		JPanel panel5  = new JPanel(new FlowLayout(FlowLayout.CENTER,0,22));
		panel5.add(new JTextField(37));
		
		panelCenter.add(panel1);
		panelCenter.add(panel2);
		panelCenter.add(panel3);
		panelCenter.add(panel4);
		panelCenter.add(panel5);
		
		add(panelCenter);
		add(panelWest,"West");
		add(panelSouth,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUpLayout();
	}

}
