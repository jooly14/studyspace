class Buffer{
	private int data;
	private boolean empty = true;
	
	public synchronized int get(){
		while (empty) {		//음식 재고량이 비어있으면 consumer는  기다린다.
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty = true;	//하나 만들면 하나 소비하는 형식	//소비했으니까 재고가 비어있고
		notifyAll();							//모두에게 알리면 consumer는 기다리고 producer는 생산한다.
		return data;
	}
	public synchronized void put(int data){
		while (!empty) {	//음식 재고량이 차있으면 producer는 기다린다.
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty = false; 
		this.data = data;
		notifyAll();
	}
}
class Producer implements Runnable{
	private Buffer buffer;
	
	public Producer(Buffer buffer){
		this.buffer = buffer;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			buffer.put(i);
			System.out.println("생산자: "+i+"번 케익을 생산하였습니다.");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
class Consumer implements Runnable{
	private Buffer buffer;
	public Consumer(Buffer drop) {
		buffer = drop;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			int data = buffer.get();
			System.out.println("소비자: "+ i +"번 케익을 소비하였습니다.");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
public class ProducerConsumerTest {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		new Thread(new Producer(buffer)).start();
		new Thread(new Consumer(buffer)).start();
	}
}
