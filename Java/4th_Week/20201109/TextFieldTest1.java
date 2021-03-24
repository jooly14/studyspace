import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldTest1 extends JFrame implements ActionListener{
	private JButton btn;
	private JTextField text, result;
	
	public TextFieldTest1(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("제곱 계산하기");
		setSize(300,130);
		
		
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("숫자 입력 : "));
		text = new JTextField(15);
		text.addActionListener(this);
		panel.add(text);
		
		panel.add(new JLabel("제곱한 값 : "));
		result = new JTextField(15);
		result.addActionListener(this);
		result.setEditable(false);
		panel.add(result);
		
		btn = new JButton("OK");
		btn.addActionListener(this);
		panel.add(btn);
		
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextFieldTest2();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn|| e.getSource()==text){
			String name = text.getText();
			int value = Integer.parseInt(name);
			result.setText(value*value+"");
			text.requestFocus();
			text.selectAll();
		}
	}

}
