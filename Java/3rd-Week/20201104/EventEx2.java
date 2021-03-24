import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventEx2 extends JFrame implements ActionListener{
	JButton btn;
	public EventEx2(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setTitle("이벤트 예제");
		setLayout(new FlowLayout());
		btn = new JButton("버튼을 누르시오");
		btn.addActionListener(this);
		
		add(btn);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = "마침내 버튼이 눌러졌습니다.";
		/*JButton btn2 = (JButton)e.getSource();
		btn2.setText(str);
		*/
		if(e.getActionCommand().equals(str)){
			btn.setText("버튼을 누르시오");
		}else{
			btn.setText(str);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EventEx2();
	}
}
