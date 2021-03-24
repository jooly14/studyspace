import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingTextfieldEx extends JFrame implements ActionListener{
	JTextField tf;
	JButton btnSet;
	JButton btnGet;
	JLabel lbl;
	public SwingTextfieldEx(){
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tf = new JTextField(10);
		btnSet = new JButton("적용");
		btnGet = new JButton("가져오기");
		btnSet.addActionListener(this);
		btnGet.addActionListener(this);
		lbl = new JLabel();
		
		JPanel panelSouth = new JPanel();
		JPanel panelCenter = new JPanel();
		
		panelCenter.add(lbl);
		panelSouth.add(tf);
		panelSouth.add(btnSet);
		panelSouth.add(btnGet);
		
		add(panelSouth,"South");
		add(panelCenter);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnSet){
			lbl.setText(tf.getText());
		}else if(e.getSource()==btnGet){
			tf.setText(lbl.getText());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingTextfieldEx();
	}
}
