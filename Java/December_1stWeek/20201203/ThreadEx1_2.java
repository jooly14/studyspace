
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
					print("아직 끝나지 않았어요!");
					
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		int tries =0;
		
		print("추가적인 스레드를 시작합니다.");
		Thread t = new Thread(new MessageLoop());
		t.start();

		print("추가적인 스레드가 끝나기를 기다립니다.");
		while (t.isAlive()) {
			print("아직 기다립니다.");
			t.join(2000);
			tries++;
			if(tries>2){
				print("참을 수 없네요.");
				t.interrupt();
				t.join();
			}
		}
		print("메인 스레드 종료");
	}
}

