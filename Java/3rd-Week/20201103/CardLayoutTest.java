import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutTest extends JFrame implements ActionListener{
	JPanel panel;
	Cards cards;
	public CardLayoutTest(){
		setTitle("CardLayout Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		panel = new JPanel(new GridLayout(0, 5, 10, 0));
		addButton("<<", panel);
		addButton("<", panel);
		addButton(">", panel);
		addButton(">>", panel);
		addButton("종료", panel);
		add(panel,"North");
		cards = new Cards();	//cards는 패널이다. 버튼을 담았다.
		add(cards,"Center");	
		
		setVisible(true);
	}
	public void addButton(String str, Container target){
		JButton btn = new JButton(str);
		btn.addActionListener(this);
		target.add(btn);
		
	}
	private class Cards extends JPanel{
		CardLayout layout;
		
		public Cards(){
			layout = new CardLayout();
			setLayout(layout);
			for(int i = 0;i<=10;i++){
				add(new JButton("현재 카드의 번호는 "+ i+"입니다."),"Center");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("종료")){
			System.exit(0);
		}else if(e.getActionCommand().equals("<<")){
			cards.layout.first(cards);
		}else if(e.getActionCommand().equals("<")){
			cards.layout.previous(cards);
		}else if(e.getActionCommand().equals(">")){
			cards.layout.next(cards);
		}else if(e.getActionCommand().equals(">>")){
			cards.layout.last(cards);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CardLayoutTest();
	}

}
