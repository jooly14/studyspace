import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//������ ������� �����..
//Timer
//������� �����۾��� �����ϰ�
//�����۾��� ���ϴ� �ð����� ����
//Swing Timer�� Ư�� �ð����� actionPerformed�� �����Ų��.
public class TimerEx2 extends JFrame {
	JButton btn;
	JLabel lbl;
	SimpleDateFormat sdf;
	String str;
	boolean color;
	Timer timer;
	boolean start;
	public TimerEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		btn = new JButton("����");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timer.stop();
				if(start){
					timer.start();
					start = false;
					btn.setText("����");
				}else{
					timer.stop();
					start = true;
					btn.setText("����");
				}
			}
		});
		
		JPanel pnl = new JPanel();
		sdf = new SimpleDateFormat("yyyy�� MM�� dd�� a hh:mm:ss",new Locale("en", "US"));
		lbl = new JLabel();
		str = sdf.format(new Date());
		str = "<html><br>"+str.substring(0,13)+"<br>"+str.substring(14)+"</html>";
		lbl.setText(str);
		lbl.setFont(new Font("Serif",Font.BOLD,20));
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(color){
					lbl.setForeground(Color.black);
					color = false;
				}else{
					lbl.setForeground(Color.blue);
					color = true;
				}
				// TODO Auto-generated method stub
				str = sdf.format(new Date());
				str = "<html><br>"+str.substring(0,13)+"<br>"+str.substring(14)+"</html>";
				lbl.setText(str);
			}
			});
		timer.start();			
		
		pnl.add(lbl);
		add(pnl);
		add(btn,"South");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TimerEx2();
	}
}
