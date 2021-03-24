
public class ThreadEx2 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx2());	//runnable은 엔진 같은 역할을 한다. thread가 자동차 역할을 한다.
		t.start();								//thread의 매개변수로 runnable을 구현한 클래스를 넣는다.
	}
}
