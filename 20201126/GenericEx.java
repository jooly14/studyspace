import java.util.HashMap;

//���׸� Ŭ����
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
		GenericSub<String> gs1 = new GenericSub<>();	//�����ÿ� Ÿ�ԸŰ������� Ÿ���� �������� ������ ObjectŸ������ �����ȴ�.
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
		//System.out.println((String)gs5.get());	//IntegerŸ���ε� StringŸ������ ĳ�����ϰ� ���� ���� �߻�	
		//ObjectŸ������ �����Ǿ��ִٺ��� �ƹ� Ÿ������ �ٿ�ĳ������ ������	//������ ����ÿ� ���� �߻�
//		System.out.println(gs1.get());
//		System.out.println(gs2.get()+1);
//		System.out.println(gs3.get()+0.1);
//		System.out.println(gs.get());
		
		//HashMap<K, V> map = new HashMap<>();
		HashMap<Integer, String> map = new HashMap<>();
		//K, V�� Ÿ�� �Ű�����, �⺻�� ObjectŸ��
		map.put(1, "a");
		System.out.println(map.get(1));
	}
}
