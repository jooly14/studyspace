import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonTest1 extends JFrame implements ActionListener {
	private JLabel text;
	private JPanel topPnl, sizePnl, resultPnl;
	private JRadioButton small,medium,large;
	public RadioButtonTest1(){
		setTitle("라디오 버튼 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,150);
		
		JLabel lbl = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		
		small = new JRadioButton("Small Size");
		medium = new JRadioButton("Medium Size");
		large = new JRadioButton("Large Size");
		
		ButtonGroup size = new ButtonGroup();
		size.add(small);
		size.add(medium);
		size.add(large);
		
		small.addActionListener(this);
		medium.addActionListener(this);
		large.addActionListener(this);
		
		text = new JLabel("크기가 선택되지 않았습니다.");
		text.setForeground(Color.red);
		
		
		topPnl = new JPanel();
		sizePnl = new JPanel();
		sizePnl.setBorder(BorderFactory.createTitledBorder("크기"));
		resultPnl = new JPanel();

		topPnl.add(lbl);
		sizePnl.add(small);
		sizePnl.add(medium);
		sizePnl.add(large);
		resultPnl.add(text);
		
		
		add(topPnl,"North");
		add(sizePnl);
		add(resultPnl,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RadioButtonTest1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==small){
			text.setText("Small 크기가 선택되었습니다.");
		}else if(e.getSource()==medium){
			text.setText("Medium 크기가 선택되었습니다.");
			
		}else if(e.getSource()==large){
			text.setText("Large 크기가 선택되었습니다.");
			
		}
	}

}
