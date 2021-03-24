import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DateFormatter;
import javax.swing.text.NumberFormatter;

public class FormattedTextTest1 extends JFrame implements PropertyChangeListener{
	private double amount = 10000;
	private Date date;
	
	private JFormattedTextField amountField;
	private JFormattedTextField dateField;
	public FormattedTextTest1(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,150);
		
		amountField = new JFormattedTextField(new NumberFormatter());
		amountField.setValue(new Integer(100));	//초기값 설정
		amountField.addPropertyChangeListener("value",this);	//value는 원래 가지고 있던 값. setvalue할때 쓰던 value를 의미. value값이 바뀌면 작동하게 됨.
		amountField.setColumns(10);
		
		dateField = new JFormattedTextField(new DateFormatter());
		dateField.setValue(new Date());
		dateField.addPropertyChangeListener("value",this);
		dateField.setColumns(10);
		
		
		JPanel pnl = new JPanel();
		pnl.add(new JLabel("금액: "));
		pnl.add(amountField);
		pnl.add(new JLabel("날짜: "));
		pnl.add(dateField);
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FormattedTextTest1();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==amountField){
			amount = ((Number)(amountField.getValue())).doubleValue();
			System.out.println(amount);
		}else if(arg0.getSource()==dateField){
			date = (Date)(dateField.getValue());
			System.out.println(date);
		}
	}

}
