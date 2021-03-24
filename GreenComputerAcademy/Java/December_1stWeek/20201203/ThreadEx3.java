
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
		Thread t = new Thread(new ThreadEx3("A"));	//runnable은 엔진 같은 역할을 한다. thread가 자동차 역할을 한다.
		Thread t2 = new Thread(new ThreadEx3("B"));
		t.start();									//thread의 매개변수로 runnable을 구현한 클래스를 넣는다.
		t2.start();									//thread는 순서대로 실행되지 않는다. cpu의 스케줄러 방식에 따라 실행되므로 먼저 시작한 스레드가 늦게 끝날수도 있다.
	}
}
