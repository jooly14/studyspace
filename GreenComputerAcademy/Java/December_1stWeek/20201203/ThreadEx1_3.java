//Synchronization 동기화
//스레드 여러개가 동시에 공유된 자원에 접근하는 경우 문제가 생길 수 있다.
//동기화 작업을 하면 공유된 자원에 한번에 하나의 스레드만 접근할 수 있다.
//synchronized메서드가 포함된 객체 자체가 lock된다고 함.
class Counter{
	private int value = 0;
	public synchronized void increment(String name, int i){
		value++;
		System.out.println(name+" I"+i+" "+value);}
	public synchronized void decrement(String name, int i){ value--;
	System.out.println(name+" D"+i+" "+value);}
	
	public synchronized void printCounter(){ System.out.println(value);}
}
class MyThread1_3 extends Thread{
	Counter sharedCounter;
	
	public MyThread1_3(Counter c) {
		this.sharedCounter = c;
	}
	@Override
	public void run() {
		int i=0;
		while (i<300) {
			sharedCounter.increment(this.getName(),i);
			sharedCounter.decrement(this.getName(),i);	//내 생각에는 increment가 완료되기 전에도 decrement가 먼저 실행되기도 하고 여러번 실행되기도 하기 때문에
														//마이너스의 value값이 나올 수 있는 것 같다.
														//print할때도 마찬가지로 decrement나 increment메서드가 완료되기 전에 실행돼버리면 실제 값과 다름
			if(i%40==0){
				sharedCounter.printCounter();
			}
			try {
				sleep((int)(Math.random()*2));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
	}
}
public class ThreadEx1_3 {
	public static void main(String[] args) {
		Counter c = new Counter();
		new MyThread1_3(c).start();
		new MyThread1_3(c).start();
		new MyThread1_3(c).start();
		new MyThread1_3(c).start();
	}
}
