
public class ThreadEx2 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx2());	//runnable�� ���� ���� ������ �Ѵ�. thread�� �ڵ��� ������ �Ѵ�.
		t.start();								//thread�� �Ű������� runnable�� ������ Ŭ������ �ִ´�.
	}
}
