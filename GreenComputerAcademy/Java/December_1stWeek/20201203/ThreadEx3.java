
public class ThreadEx3 implements Runnable{
	String name;
	public ThreadEx3(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.print(name+i+" ");
		}
	}
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx3("A"));	//runnable�� ���� ���� ������ �Ѵ�. thread�� �ڵ��� ������ �Ѵ�.
		Thread t2 = new Thread(new ThreadEx3("B"));
		t.start();									//thread�� �Ű������� runnable�� ������ Ŭ������ �ִ´�.
		t2.start();									//thread�� ������� ������� �ʴ´�. cpu�� �����ٷ� ��Ŀ� ���� ����ǹǷ� ���� ������ �����尡 �ʰ� �������� �ִ�.
	}
}
