import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListEx2 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("�ϳ�");
		list.add("��");
		list.add("��");
		list.add("��");
		
		Iterator<String> e = list.iterator();
		
		while(e.hasNext()){
			System.out.println(e.next());
		}
		System.out.println("-----------");
		for(String str:list){
			System.out.println(str);
		}
		System.out.println("-----------");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		//asList()��� �� ���� �̷��� �ص� ��
		Integer[] ints = {1,2,3,4,5,6,7,8,9,10};
		ArrayList<Integer> alist = new ArrayList<>();
		for(int i=0;i<ints.length;i++){
			alist.add(ints[i]);
			System.out.println(alist.get(i));
		}
		System.out.println(alist);
	}
}
