import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class MyAlgorithm {
	public static <T extends Integer> T max(T x,T y){
		return x>y?x:y;
	}
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		String[] s = {"사과","배","바나나"};
		List list  = new ArrayList(Arrays.asList(s));
//		list.add("포도");
//		System.out.println(list);
//		list.add(2,"자몽");
//		System.out.println(list);
//		System.out.println(list.get(3));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for(Object obj: list){
			System.out.println(obj);
		}
		Iterator e = list.iterator();
		while(e.hasNext()){
			System.out.println(e.next());
		}
		
		
		}
}
class Stack <T>{
	private T[] stack;
	public void push(T data){
	}
	public T pop(){
		return null;	
	}
}
