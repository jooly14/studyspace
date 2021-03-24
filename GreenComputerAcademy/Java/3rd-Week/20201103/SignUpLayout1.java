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

//이건 하다가 포기!!
public class SignUpLayout1 extends JFrame{
	public SignUpLayout1(){
		setTitle("회원가입 폼!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLayout(new GridLayout(0,1));	//패널을 한줄 단위로 끊어서 만든 뒤에 그리드로 정렬하기		//생각보다 단순하게 디자인
		JPanel panel1,panel2,panel3, panel4,panel5,panel6;
		
		
		JLabel[] labels = new JLabel[10];
		for(int i=0;i<labels.length;i++){
			labels[i] = new JLabel("            ");
		}
		
		
		
		panel1 = new JPanel();
		JLabel la1a = new JLabel("아이디");
		JTextField tf1 = new JTextField(10);
		JLabel la1b = new JLabel("*8자이내");
		panel1.add(la1a);
		panel1.add(tf1);
		panel1.add(labels[0]);	//공백으로 위치 맞추기
		panel1.add(labels[1]);
		panel1.add(labels[2]);
		panel1.add(la1b);
		
		panel2 = new JPanel();
		JLabel la2a = new JLabel("비밀번호");
		JTextField tf2a = new JTextField(10);
		JLabel la2b = new JLabel("성명");
		JTextField tf2b = new JTextField(10);
		panel2.add(la2a);
		panel2.add(tf2a);
		panel2.add(labels[3]);
		panel2.add(la2b);
		panel2.add(tf2b);
		
		
		
		panel3 = new JPanel();
		JLabel la3a = new JLabel("성별");
		JRadioButton radiobtn3a = new JRadioButton("남자");
		JRadioButton radiobtn3b = new JRadioButton("여자");
		ButtonGroup g = new ButtonGroup();
		g.add(radiobtn3a);
		g.add(radiobtn3b);
		JLabel label3b = new JLabel("취미");
		JCheckBox chkbox3a = new JCheckBox("여행");
		JCheckBox chkbox3b = new JCheckBox("잠자기");
		panel3.add(la3a);
		panel3.add(radiobtn3a);
		panel3.add(radiobtn3b);
		panel3.add(labels[4]);
		panel3.add(label3b);
		panel3.add(chkbox3a);
		panel3.add(chkbox3b);
		
		panel4 = new JPanel();
		JLabel la4a = new JLabel("H.P");
		String[] str = {"010","011","019","014"};
		JComboBox cbox = new JComboBox(str);
		JLabel la4b = new JLabel("-");
		JTextField tf4b = new JTextField(4);
		JLabel la4c = new JLabel("-");
		JTextField tf4c = new JTextField(4);
		JLabel la4d = new JLabel("*필수입력");
		panel4.add(la4a);
		panel4.add(cbox);
		panel4.add(la4b);
		panel4.add(tf4b);
		panel4.add(la4c);
		panel4.add(tf4c);
		panel4.add(labels[5]);
		panel4.add(labels[6]);
		panel4.add(la4d);
		
		
		
		
		panel5 = new JPanel();
		JLabel la5a = new JLabel("자기소개");
		JTextField tf5 = new JTextField(25);
		panel5.add(la5a);
		panel5.add(tf5);
		
		panel6 = new JPanel();
		JButton btn1 = new JButton("전송");
		JButton btn2 = new JButton("취소");
		panel6.add(btn1);
		panel6.add(btn2);
		
		
		add(panel1);	//한 줄씩 패널에 넣은 다음에 붙이기
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUpLayout1();
	}

}
