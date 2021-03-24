import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame{
	private JLabel label;
	
	class MyThread2 extends Thread{
		public void run(){
			for(int i=10;i>=0;i--){
				try {
					Thread.sleep(1000);	//1초 쉬었다가 반복문이 실행되도록 하기 위해서 사용
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				label.setText(i+"");
			}
			label.setText("END");
		}
	}
	public CountDownTest(){
		setTitle("카운트다운");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("Start");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		add(label);
		new MyThread2().start();	//jframe 안에 thread를 상속받은 내부클래스를 생성해서 사용
		setVisible(true);
	}
	public static void main(String[] args) {
		new CountDownTest();
	}
}
