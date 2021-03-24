import java.util.ArrayList;
import java.util.Vector;

//Collection	
// ArrayList, Vector : 이 두개는 99% 같다.
// 다른 점은 네트워크에서 차이점이 있다.
//배열의 단점 : 생성시 반드시 크기 결정해야한다.
//			 중간에 내용을 삭제하거나 추가할 수 없다.
public class ArrayListEx {
	public static void main(String[] args) {
		int[] array = new int[10]; 
		ArrayList<Integer> a = new ArrayList<>();
		//Vector<Integer> v = new Vector<>();
		
		array[0] = 10;
		a.add(0, 10);
		a.add(20);
		a.add(30);
		a.add(1, 50);	//중간에 값을 넣으면 뒤에 있던 것들이 한칸씩 밀려남
		a.set(1, 100);	//해당 인덱스의 내용을 바꾸기 //기존에 있던 내용을 변경시킴
		//v.add(6, 100);//차례대로 저장하지 않으면 안됨!!
		System.out.println(a.get(0));
		System.out.println(a.get(1));
		System.out.println(a.get(2));
		System.out.println(a.get(3));
		
		
	}
}
