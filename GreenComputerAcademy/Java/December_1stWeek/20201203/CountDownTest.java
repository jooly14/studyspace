import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame{
	private JLabel label;
	
	class MyThread2 extends Thread{
		public void run(){
			for(int i=10;i>=0;i--){
				try {
					Thread.sleep(1000);	//1�� �����ٰ� �ݺ����� ����ǵ��� �ϱ� ���ؼ� ���
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
		setTitle("ī��Ʈ�ٿ�");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("Start");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		add(label);
		new MyThread2().start();	//jframe �ȿ� thread�� ��ӹ��� ����Ŭ������ �����ؼ� ���
		setVisible(true);
	}
	public static void main(String[] args) {
		new CountDownTest();
	}
}
