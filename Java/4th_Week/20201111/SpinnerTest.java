import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class SpinnerTest extends JFrame implements ActionListener{
	JButton btn;
	String[] str = {"빨","주","노","초","파","남","보"};
	JSpinner spinner1;
	public SpinnerTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("스피너 테스트");
		setSize(300,300);
		setLayout(new FlowLayout());
		SpinnerModel sm = new SpinnerListModel(str);
		spinner1 = new JSpinner(sm);
		JSpinner spinner2 = new JSpinner(new SpinnerNumberModel(1,1,100,2));
		spinner2.setValue(1);
		Calendar cal = Calendar.getInstance();
		Date current = cal.getTime();
		cal.add(Calendar.YEAR, -50);
		Date start = cal.getTime();
		cal.add(Calendar.YEAR, 100);;
		Date end = cal.getTime();
		SpinnerDateModel sm2 = new SpinnerDateModel(current,start,end,Calendar.YEAR){
            @Override 
            public Object getNextValue() {
            	 Date date = this.getDate();
                 long millis = date.getTime();
                 return new Date(millis+1000*60*60*24);
            }

            @Override 
            public Object getPreviousValue() {
                Date date = this.getDate();
                long millis = date.getTime();
                return new Date(millis-1000*60*60*24);
            }
        };
		JSpinner spinner3 = new JSpinner(sm2);
		spinner3.setEditor(new JSpinner.DateEditor(spinner3,"yyyy/MM/dd"));
		
		btn = new JButton("확인");
		btn.addActionListener(this);
		add(spinner1);
		add(spinner2);
		add(spinner3);
		add(btn);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SpinnerTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(spinner1.getValue());
	}

}
