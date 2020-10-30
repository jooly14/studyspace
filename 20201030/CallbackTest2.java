import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
public class CallbackTest2{
	public static void main(String args[]){
		ActionListener listener = new Counter();
		Timer t = new Timer(1000, listener);
		t.start();
		try{  Thread.sleep(11000); } catch(InterruptedException e){ }
			//timer클래스는 메인스레드가 반환되면서 자동으로 종료된다.
			//그래서 일부러 스레드 반환을 지연시키고 있다.
			//어쩐지 이 문장이 없었을때는 actionlistener가 하나도 작동하지 않고 프로그램이 종료되었다.
	}	
}
class Counter implements ActionListener{
	int counter = 10;
	public void actionPerformed(ActionEvent event){
		counter--;
		if(counter<=0){
			counter =0;
			System.out.println("카운터가 종료되었습니다.");
			Toolkit.getDefaultToolkit().beep();
			
		}else{
			System.out.println("현재 카운터값은 "+counter+"입니다.");
		}
	}
}
