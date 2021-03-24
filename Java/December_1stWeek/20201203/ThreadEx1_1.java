
public class ThreadEx1_1 {
	public static void main(String[] args) {
		String msg[] = {"aaa","bbb","ccc","ddd","eee"};
		for(int i=0; i<msg.length;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("인터럽트");
				e.printStackTrace();
			}
			System.out.println(msg[i]);
		}
	}
}
