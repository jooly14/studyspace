//쓰레드는 작은 프로세스 이다.
//Thread 구현 방법 2가지
//1.  Thread 클래스 상속받아서 구현
//2.  Runnable 인터페이스 구현해서 작성
// Runnable을 사용하는 경우가 더 많음
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
