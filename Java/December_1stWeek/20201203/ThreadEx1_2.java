
public class ThreadEx1_2 {
	static void print(String message){
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s\n",threadName,message);
	}
	private static class MessageLoop implements Runnable{
		@Override
		public void run() {
			String messages[] = {"Pride will","Power is","Office changes","Empty vessels make"};
			for(int i=0;i<messages.length;i++){
				print(messages[i]);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					print("���� ������ �ʾҾ��!");
					
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		int tries =0;
		
		print("�߰����� �����带 �����մϴ�.");
		Thread t = new Thread(new MessageLoop());
		t.start();

		print("�߰����� �����尡 �����⸦ ��ٸ��ϴ�.");
		while (t.isAlive()) {
			print("���� ��ٸ��ϴ�.");
			t.join(2000);
			tries++;
			if(tries>2){
				print("���� �� ���׿�.");
				t.interrupt();
				t.join();
			}
		}
		print("���� ������ ����");
	}
}

