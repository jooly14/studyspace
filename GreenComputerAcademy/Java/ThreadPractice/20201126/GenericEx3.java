class Box<T extends Number> {
	Integer a;
	Box(Number a) {
		this.a = (Integer)a;
	}
}
public class GenericEx3 {
	public void sub(Box<Number> b){
		
	}
	public static void main(String[] args) {
		GenericEx3 ge = new GenericEx3();
		Box<Integer> box1 = new Box<>(10);
		Box<Number> box2 = new Box<>(10);
		//ge.sub(box1); //���⼭ ������ ����!!!		Integer�� Number�� ��ӹ������� Box<Integer>�� Box<Number>�� ��ӹ������� �ƴϴ�!!! 
		ge.sub(box2);
	}
}
