import java.util.HashSet;
import java.util.Set;

public class CollectionOperation {
	public static void main(String[] args) {
		String[] str1 ={"1","2","3","4","5"};
		String[] str2 ={"4","5","6","7","8"};
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		Set<String> set3 = new HashSet<>();
		Set<String> set4 = new HashSet<>();
		
		for(int i=0;i<str1.length;i++){
			set1.add(str1[i]);
			set2.add(str1[i]);
			set3.add(str1[i]);
			set4.add(str2[i]);
		}
		
		//set1.clear();	//셋 안에 있는 값을 다 제거한다.
		System.out.println("합집합");
		set1.addAll(set4);
		System.out.println(set1);
		System.out.println("교집합");
		set2.retainAll(set4);
		System.out.println(set2);
		System.out.println("차집합");
		set3.removeAll(set4);
		System.out.println(set3);
	}
}
