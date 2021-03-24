import java.util.HashMap;

//제네릭 클래스
class GenericSub <T>{
	private T data;
	public void set(T data){
		this.data = data;
	}
	public T get(){
		return data;
	}
}
class GenericSub2 {
	private String data;
	public void set(String data){
		this.data = data;
	}
	public String get(){
		return data;
	}
}
public class GenericEx{
	public static void main(String[] args) {
		GenericSub<String> gs1 = new GenericSub<>();	//생성시에 타입매개변수의 타입을 정해주지 않으면 Object타입으로 설정된다.
		GenericSub<Integer> gs2 = new GenericSub<>();
		GenericSub<Double> gs3 = new GenericSub<>();
		GenericSub gs4 = new GenericSub();
		GenericSub gs5 = new GenericSub();
		GenericSub2 gs = new GenericSub2();
		gs1.set("abc");
		gs2.set(123);
		gs3.set(123.0);
		gs.set("abc");
		gs4.set("abc");
		gs5.set(123);
		//System.out.println((String)gs5.get());	//Integer타입인데 String타입으로 캐스팅하고 나니 에러 발생	
		//Object타입으로 설정되어있다보니 아무 타입으로 다운캐스팅이 가능함	//하지만 실행시에 예외 발생
//		System.out.println(gs1.get());
//		System.out.println(gs2.get()+1);
//		System.out.println(gs3.get()+0.1);
//		System.out.println(gs.get());
		
		//HashMap<K, V> map = new HashMap<>();
		HashMap<Integer, String> map = new HashMap<>();
		//K, V도 타입 매개변수, 기본은 Object타입
		map.put(1, "a");
		System.out.println(map.get(1));
	}
}
