//������� ���� ���μ��� �̴�.
//Thread ���� ��� 2����
//1.  Thread Ŭ���� ��ӹ޾Ƽ� ����
//2.  Runnable �������̽� �����ؼ� �ۼ�
// Runnable�� ����ϴ� ��찡 �� ����
class MyThread extends Thread{
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.print(i+" ");
		}
	}
}
public class ThreadTest1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new MyThread();
		Thread t2 = new MyThread();
		t.start();
		t2.start();
	}
}
