class Buffer{
	private int data;
	private boolean empty = true;
	
	public synchronized int get(){
		while (empty) {		//���� ����� ��������� consumer��  ��ٸ���.
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty = true;	//�ϳ� ����� �ϳ� �Һ��ϴ� ����	//�Һ������ϱ� ��� ����ְ�
		notifyAll();							//��ο��� �˸��� consumer�� ��ٸ��� producer�� �����Ѵ�.
		return data;
	}
	public synchronized void put(int data){
		while (!empty) {	//���� ����� �������� producer�� ��ٸ���.
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
			System.out.println("������: "+i+"�� ������ �����Ͽ����ϴ�.");
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
			System.out.println("�Һ���: "+ i +"�� ������ �Һ��Ͽ����ϴ�.");
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
