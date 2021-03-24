import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CallbackTest{
	public static void main(String args[]){
		ActionListener listener = new Counter();
		Timer t = new Timer(1000,new ActionListener(){
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
		});
		t.start();
		
		JOptionPane.showMessageDialog(null,"비프 소리를 들으면 종료하세요!");
		//확인을 눌릴때까지 그 다음 문장이 실행되지 않음
		//확인을 눌러도 joptionpane 객체가 반환되지 않는지... 바로 타이머의 메서드가 종료되지 않았다.
		System.exit(0);	//그래서 따로 jvm을 강제종료해주는 메서드를 호출해주었다.
						//System.exit(0)메서드를 사용해도 갑자기 강제종료되는 것은 아니라고 한다.
						//필요한 처리를 끝마친 후에 안전하게 실행되는 종료라고....
	}
}
