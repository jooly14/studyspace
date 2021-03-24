import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;

public class SwingComponentsTest1 extends JFrame implements ActionListener{
	private JTextField id;
	private JPasswordField pw;
	private JFormattedTextField date;
	private JTextArea textArea;
	
	public SwingComponentsTest1() throws ParseException{
		setTitle("My Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		
		id = new JTextField(30);
		pw = new JPasswordField();
		MaskFormatter mf = new MaskFormatter("####.##.##");
		mf.setPlaceholder("_");
		date = new JFormattedTextField(mf);
		
		id.addActionListener(this);
		pw.addActionListener(this);
		date.addActionListener(this);
		
		textArea = new JTextArea(10,30);
		textArea.setEditable(false);
		
		panel.add(new JLabel("ID :"));
		panel.add(id);
		panel.add(new JLabel("PASSWORD :"));
		panel.add(pw);
		panel.add(new JLabel("DATE :"));
		panel.add(date);
		
		add(panel,"North");
		add(textArea);
		setVisible(true);
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		new SwingComponentsTest1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==id||e.getSource()==pw||e.getSource()==date){
			String text = "id: "+id.getText()+"password: "+pw.getText()+"date: "+date.getText();
			textArea.append(text+"\n");
			id.selectAll();
			id.requestFocus();
			pw.selectAll();
			date.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
	}

}
