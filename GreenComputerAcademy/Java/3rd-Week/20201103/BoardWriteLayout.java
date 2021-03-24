import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardWriteLayout extends JFrame{
	public BoardWriteLayout(){
		setTitle("게시판 글작성하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		//setLayout(new FlowLayout());
		JPanel panelNorth,panel1a,panel1b,panel2a,panel2b,panel3,panelCenter,panelSouth;
		

		panel1a = new JPanel();
		panel1b = new JPanel();
		JLabel la1a = new JLabel("이름");
		JTextField tf1a = new JTextField(10);
		JLabel la1b = new JLabel("비밀번호");
		JTextField tf1b = new JTextField(10);
		panel1a.add(la1a);
		panel1a.add(tf1a);
		panel1b.add(la1b);
		panel1b.add(tf1b);
		
		panel2a = new JPanel();
		JLabel la2 = new JLabel("E-Mail");
		JTextField tf2 = new JTextField(10);
		panel2a.add(la2);
		panel2a.add(tf2);
		panel2a.add(new JLabel(" "));
		panel2b = new JPanel();	//빈 패널 붙여서 균형이 맞게 만들기
		
		
		panel3 = new JPanel();
		JLabel la3 = new JLabel("제목");
		JTextField tf3 = new JTextField(10);
		panel3.add(la3);
		panel3.add(tf3);
		
		panelNorth = new JPanel(new GridLayout(0,2));	//패널을 다 끊어서 작성한 다음에 하나의 패널에 넣고 그리드레이아웃으로 정리
		panelNorth.add(panel1a);
		panelNorth.add(panel1b);
		panelNorth.add(panel2a);
		panelNorth.add(panel2b);
		panelNorth.add(panel3);
		
		
		panelCenter = new JPanel();		//내용 적는 칸은 중앙에 배치
		JLabel la4 = new JLabel("내용");
		JTextArea tArea = new JTextArea(13,28);
		panelCenter.add(la4);
		panelCenter.add(tArea);
		
		
		
		panelSouth = new JPanel();	//확인 버튼 만들기
		JButton btn = new JButton("확인");
		panelSouth.add(btn);
		
		
		
		add(panelNorth,"North");
		add(panelCenter);
		add(panelSouth,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardWriteLayout();
	}

}
