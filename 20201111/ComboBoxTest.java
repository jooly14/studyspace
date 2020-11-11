import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxTest extends JFrame implements ActionListener{
	String[] str = {"빨","주","노","초","파","남","보"};
	JLabel lbl;
	JComboBox combobox;
	public ComboBoxTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,400);
		setTitle("콤보박스 테스트");
		
		combobox = new JComboBox(str);
		lbl = new JLabel("선택하세요");
		
		add(lbl);
		add(combobox,"North");
		
		combobox.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComboBoxTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s =combobox.getSelectedItem().toString();
		System.out.println(s+" "+combobox.getSelectedIndex());
		lbl.setText(combobox.getSelectedIndex()+":"+s);
			
	}

}
