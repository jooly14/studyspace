import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BtnColor_Location extends JFrame implements ActionListener{
	JButton btnC1;
	JButton btnC2;
	JButton btnC3;
	JButton btnC4;
	JButton movingBtn;
	JButton btnPlus;
	JButton btnMinus;
	JButton btnUp;
	JButton btnDown;
	JButton btnLeft;
	JButton btnRight;
	JButton applyBtn;
	int width = 50;
	int height = 50;
	int x = 0;
	int y = 0;
	Color color = Color.lightGray;
	JLabel infoLbl;
	String c = "lightgray";
	
	public BtnColor_Location(){
		setSize(400,400);	//프레임 사이즈 설정
		//setResizable(false); 	//사이즈 크기 변경 불가하게 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//종료설정
		btnC1 = new JButton();	//색깔 버튼 네가지 생성
		btnC2 = new JButton();
		btnC3 = new JButton();
		btnC4 = new JButton();
		btnC1.setBackground(Color.RED);	//버튼의 색깔 설정
		btnC2.setBackground(Color.BLUE);
		btnC3.setBackground(Color.YELLOW);
		btnC4.setBackground(Color.GREEN);
		btnC1.setPreferredSize(new Dimension(50,50));	//버튼의 사이즈 설정
		btnC2.setPreferredSize(new Dimension(50,50));
		btnC3.setPreferredSize(new Dimension(50,50));
		btnC4.setPreferredSize(new Dimension(50,50));
		btnC1.addActionListener(this);
		btnC2.addActionListener(this);
		btnC3.addActionListener(this);
		btnC4.addActionListener(this);
		
		JPanel northPanel = new JPanel();	//북쪽에 붙을 패널 생성
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		northPanel.setBorder(BorderFactory.createLineBorder(Color.black));	//패널의 경계 그리기
		northPanel.add(btnC1);	//패널에 버튼 붙이기
		northPanel.add(btnC2);
		northPanel.add(btnC3);
		northPanel.add(btnC4);
		/*MyButton btnC5 = new MyButton("5",Color.DARK_GRAY );
		MyButton btnC6 = new MyButton("6");
		northPanel.add(btnC5);	//여러개의 버튼을 생성해야 하는 경우 클래스를 따로 만들어 생성자를 설정해두면 편리하다.
		northPanel.add(btnC6);*/
		
		JPanel westPanel = new JPanel();	//서쪽에 붙을 패널 생성
		westPanel.setBorder(BorderFactory.createLineBorder(Color.black));	//패널의 경계 그리기
		westPanel.setPreferredSize(new Dimension(50,200));	//서쪽 패널의 사이즈 설정
		btnUp = new JButton("↑");	//버튼 두개 생성
		btnDown = new JButton("↓");
		btnLeft = new JButton("←");
		btnRight = new JButton("→");
		btnUp.addActionListener(this);
		btnDown.addActionListener(this);
		btnLeft.addActionListener(this);
		btnRight.addActionListener(this);
		btnUp.setPreferredSize(new Dimension(50,30));	//버튼 사이즈 설정
		btnDown.setPreferredSize(new Dimension(50,30));
		btnLeft.setPreferredSize(new Dimension(50,30));
		btnRight.setPreferredSize(new Dimension(50,30));
		JLabel la1 = new JLabel("좌표");		//버튼에 맞는 라벨 생성
		JLabel la2 = new JLabel("X");
		westPanel.add(la1);		//라벨과 버튼을 패널에 붙이기
		westPanel.add(btnUp);
		westPanel.add(btnDown);
		westPanel.add(la2);
		westPanel.add(btnLeft);
		westPanel.add(btnRight);
		
		JPanel centerPanel = new JPanel();	//센터에 붙을 패널 생성
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));		//센터 패널의 테두리 그리기
		movingBtn = new JButton();	//센터 패널 안에서 움직일 버튼 생성
		movingBtn.setBounds(x,y,width,height);
		movingBtn.setBackground(Color.LIGHT_GRAY);	//버튼의 색상 설정
		centerPanel.add(movingBtn);	//센터 패널에 버튼 붙이기
		
		JPanel eastPanel = new JPanel();	//동쪽에 붙을 패널 생성
		eastPanel.setBorder(BorderFactory.createLineBorder(Color.black));		//패널의 테두리 그리기
		eastPanel.setPreferredSize(new Dimension(50,200));	//패널 사이즈 설정
		JLabel sizeLabel = new JLabel("크기");	//라벨과 버튼 생성
		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		btnPlus.addActionListener(this);
		btnMinus.addActionListener(this);
		btnPlus.setPreferredSize(new Dimension(42,30));		//버튼의 크기 설정
		btnMinus.setPreferredSize(new Dimension(42,30));
		eastPanel.add(sizeLabel);	//동쪽 패널에 라벨과 버튼 붙이기
		eastPanel.add(btnPlus);
		eastPanel.add(btnMinus);
		
		JPanel southPanel = new JPanel();	//남쪽 패널 생성
		southPanel.setBorder(BorderFactory.createLineBorder(Color.black));	//테두리 그리기
		infoLbl = new JLabel();
		infoLbl.setText("크기("+width+","+height+")   좌표("+x+","+y+")   컬러("+c+")");
		applyBtn = new JButton("적용");	//버튼 생성
		applyBtn.addActionListener(this);
		//southPanel.setLayout(new BorderLayout());	//레이아웃설정_전체를 꽉 채울수 있게
		southPanel.add(infoLbl);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Dimension d = movingBtn.getSize();
		
		if(btnC1==e.getSource()){
			color = Color.red;
			c = "red";
		}else if(btnC2 ==e.getSource()){
			color = Color.blue;
			c = "blue";
		}else if(btnC3 ==e.getSource()){
			color = Color.yellow;
			c = "yellow";
		}else if(btnC4 ==e.getSource()){
			color = Color.green;
			c = "green";
		}else if(btnPlus ==e.getSource()){
			width = width+10;
			height = height +10;
		}else if(btnMinus ==e.getSource()){
			width = width-10;
			height = height-10;
		}else if(btnUp ==e.getSource()){
			y = y-10;
		}else if(btnDown ==e.getSource()){
			y = y+10;
		}else if(btnRight ==e.getSource()){
			x = x+10;
		}else if(btnLeft ==e.getSource()){
			x = x-10;
		}else if(applyBtn ==e.getSource()){
			movingBtn.setBounds(x,y,width,height);
			movingBtn.setBackground(color);
		}
		infoLbl.setText("크기("+width+","+height+")   좌표("+x+","+y+")   컬러("+c+")");
	
	}

}
