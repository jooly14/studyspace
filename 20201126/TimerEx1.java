import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//스윙에 스레드랑 비슷한..
//Timer
public class TimerEx1 extends JFrame implements ActionListener{
	JButton btn;
	JLabel lbl;
	SimpleDateFormat sdf;
	public TimerEx1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		btn = new JButton("갱신");
		btn.addActionListener(this);
		
		JPanel pnl = new JPanel();
		sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss",new Locale("en", "US"));
		String str = sdf.format(new Date());
		str = "<html><br>"+str.substring(0,13)+"<br>"+str.substring(14)+"</html>";
		lbl = new JLabel(str);
		lbl.setFont(new Font("Serif",Font.BOLD,20));
		pnl.add(lbl);
		add(pnl);
		add(btn,"South");
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		lbl.setText(sdf.format(new Date()));
	}
	public static void main(String[] args) {
		new TimerEx1();
	}
}
