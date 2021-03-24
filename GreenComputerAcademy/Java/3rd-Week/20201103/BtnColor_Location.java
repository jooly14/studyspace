import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BtnColor_Location extends JFrame {
	public BtnColor_Location(){
		setSize(400,300);	//프레임 사이즈 설정
		setResizable(false); 	//사이즈 크기 변경 불가하게 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//종료설정
		JButton btnC1 = new JButton();	//색깔 버튼 네가지 생성
		JButton btnC2 = new JButton();
		JButton btnC3 = new JButton();
		JButton btnC4 = new JButton();
		btnC1.setBackground(Color.RED);	//버튼의 색깔 설정
		btnC2.setBackground(Color.BLUE);
		btnC3.setBackground(Color.YELLOW);
		btnC4.setBackground(Color.GREEN);
		btnC1.setPreferredSize(new Dimension(50,50));	//버튼의 사이즈 설정
		btnC2.setPreferredSize(new Dimension(50,50));
		btnC3.setPreferredSize(new Dimension(50,50));
		btnC4.setPreferredSize(new Dimension(50,50));
		
		JPanel northPanel = new JPanel();	//북쪽에 붙을 패널 생성
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		northPanel.setBorder(BorderFactory.createLineBorder(Color.black));	//패널의 경계 그리기
		northPanel.add(btnC1);	//패널에 버튼 붙이기
		northPanel.add(btnC2);
		northPanel.add(btnC3);
		northPanel.add(btnC4);
		MyButton btnC5 = new MyButton("5",Color.DARK_GRAY );
		MyButton btnC6 = new MyButton("6");
		northPanel.add(btnC5);	//여러개의 버튼을 생성해야 하는 경우 클래스를 따로 만들어 생성자를 설정해두면 편리하다.
		northPanel.add(btnC6);
		
		JPanel westPanel = new JPanel();	//서쪽에 붙을 패널 생성
		westPanel.setBorder(BorderFactory.createLineBorder(Color.black));	//패널의 경계 그리기
		westPanel.setPreferredSize(new Dimension(50,200));	//서쪽 패널의 사이즈 설정
		JButton btn1 = new JButton();	//버튼 두개 생성
		JButton btn2 = new JButton();
		btn1.setPreferredSize(new Dimension(40,20));	//버튼 사이즈 설정
		btn2.setPreferredSize(new Dimension(40,20));
		JLabel la1 = new JLabel("좌표");		//버튼에 맞는 라벨 생성
		JLabel la2 = new JLabel("X");
		westPanel.add(la1);		//라벨과 버튼을 패널에 붙이기
		westPanel.add(btn1);
		westPanel.add(la2);
		westPanel.add(btn2);
		
		JPanel centerPanel = new JPanel();	//센터에 붙을 패널 생성
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));		//센터 패널의 테두리 그리기
		JButton movingBtn = new JButton();	//센터 패널 안에서 움직일 버튼 생성
		movingBtn.setPreferredSize(new Dimension(50,50));	//버튼의 사이즈 설정
		movingBtn.setBackground(Color.LIGHT_GRAY);	//버튼의 색상 설정
		centerPanel.add(movingBtn);	//센터 패널에 버튼 붙이기
		
		JPanel eastPanel = new JPanel();	//동쪽에 붙을 패널 생성
		eastPanel.setBorder(BorderFactory.createLineBorder(Color.black));		//패널의 테두리 그리기
		eastPanel.setPreferredSize(new Dimension(50,200));	//패널 사이즈 설정
		JLabel sizeLabel = new JLabel("크기");	//라벨과 버튼 생성
		JButton btnPlus = new JButton("+");
		JButton btnMinus = new JButton("-");
		btnPlus.setPreferredSize(new Dimension(42,30));		//버튼의 크기 설정
		btnMinus.setPreferredSize(new Dimension(42,30));
		eastPanel.add(sizeLabel);	//동쪽 패널에 라벨과 버튼 붙이기
		eastPanel.add(btnPlus);
		eastPanel.add(btnMinus);
		
		JPanel southPanel = new JPanel();	//남쪽 패널 생성
		southPanel.setBorder(BorderFactory.createLineBorder(Color.black));	//테두리 그리기
		JButton applyBtn = new JButton("적용");	//버튼 생성
		southPanel.setLayout(new BorderLayout());	//레이아웃설정_전체를 꽉 채울수 있게
		southPanel.add(applyBtn);	//패널에 버튼 붙이기
		
		add(northPanel,"North");	//프레임에 패널 붙이기
		add(westPanel,"West");
		add(centerPanel,"Center");
		add(eastPanel,"East");
		add(southPanel,"South");
		setVisible(true);	//패널 보이게 하기
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BtnColor_Location();
	}

}
