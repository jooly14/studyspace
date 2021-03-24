//Synchronization ����ȭ
//������ �������� ���ÿ� ������ �ڿ��� �����ϴ� ��� ������ ���� �� �ִ�.
//����ȭ �۾��� �ϸ� ������ �ڿ��� �ѹ��� �ϳ��� �����常 ������ �� �ִ�.
//synchronized�޼��尡 ���Ե� ��ü ��ü�� lock�ȴٰ� ��.
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
			sharedCounter.decrement(this.getName(),i);	//�� �������� increment�� �Ϸ�Ǳ� ������ decrement�� ���� ����Ǳ⵵ �ϰ� ������ ����Ǳ⵵ �ϱ� ������
														//���̳ʽ��� value���� ���� �� �ִ� �� ����.
														//print�Ҷ��� ���������� decrement�� increment�޼��尡 �Ϸ�Ǳ� ���� ����Ź����� ���� ���� �ٸ�
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
