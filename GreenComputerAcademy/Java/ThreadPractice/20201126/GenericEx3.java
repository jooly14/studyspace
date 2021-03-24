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
		//ge.sub(box1); //여기서 문제가 생김!!!		Integer가 Number를 상속받은거지 Box<Integer>가 Box<Number>를 상속받은것은 아니다!!! 
		ge.sub(box2);
	}
}
