import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextConversionTest extends JFrame implements ActionListener{
	String str = "";
	JTextArea textArea1;
	JTextArea textArea2;
	JButton btnCon;
	JButton btnCancel;
	public TextConversionTest(){
		textArea1 = new JTextArea(10,20);
		textArea2 = new JTextArea(10,20);
		btnCon = new JButton("변환");
		btnCancel = new JButton("취소");
		btnCon.addActionListener(this);
		btnCancel.addActionListener(this);
		textArea2.setEditable(false);
		
		JPanel pnlC = new JPanel();
		JPanel pnlS = new JPanel();
		pnlC.add(textArea1);
		pnlC.add(textArea2);
		pnlS.add(btnCon);
		pnlS.add(btnCancel);
		
		
		setTitle("텍스트 변환");
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(pnlC);
		add(pnlS,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextConversionTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCon){
			str =textArea1.getText();
			str = str.replaceAll("텍스트", "Text");
			str = str.replaceAll("영어", "English");
			textArea2.setText(str);
		}else if(e.getSource()==btnCancel){
			textArea1.setText("");
			textArea2.setText("");
		}
		
	}

}
