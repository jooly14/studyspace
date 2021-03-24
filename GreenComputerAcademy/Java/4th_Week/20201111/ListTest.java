import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame implements ListSelectionListener{
	String[] str = {"서울","쿠웨이트","바그다드","쿠알라룸푸르","도하","베이징","마닐라","하노이","자카르타","예루살렘","다마스쿠스","타슈켄트","도쿄","방콕","싱가포르","뉴델리","테헤란","카트만두","타이베이","카이로","아크라"};
	JTextField tf;
	JList list;
	public ListTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,250);
		setLayout(new FlowLayout());
		
		list = new JList(str);
		list.addListSelectionListener(this);
		list.setPreferredSize(new Dimension(200,200));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	//리스트에서 하나만 선택될 수 있게 만든다.
		
		tf = new JTextField(10);
		tf.setEditable(false);
		
		add(new JScrollPane(list));
		add(new JLabel("선택된 항목:"));
		add(tf);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListTest();
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		tf.setText(list.getSelectedValue().toString());
	}
	
}
