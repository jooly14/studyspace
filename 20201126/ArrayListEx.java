import java.util.ArrayList;
import java.util.Vector;

//Collection	
// ArrayList, Vector : �� �ΰ��� 99% ����.
// �ٸ� ���� ��Ʈ��ũ���� �������� �ִ�.
//�迭�� ���� : ������ �ݵ�� ũ�� �����ؾ��Ѵ�.
//			 �߰��� ������ �����ϰų� �߰��� �� ����.
public class ArrayListEx {
	public static void main(String[] args) {
		int[] array = new int[10]; 
		ArrayList<Integer> a = new ArrayList<>();
		//Vector<Integer> v = new Vector<>();
		
		array[0] = 10;
		a.add(0, 10);
		a.add(20);
		a.add(30);
		a.add(1, 50);	//�߰��� ���� ������ �ڿ� �ִ� �͵��� ��ĭ�� �з���
		a.set(1, 100);	//�ش� �ε����� ������ �ٲٱ� //������ �ִ� ������ �����Ŵ
		//v.add(6, 100);//���ʴ�� �������� ������ �ȵ�!!
		System.out.println(a.get(0));
		System.out.println(a.get(1));
		System.out.println(a.get(2));
		System.out.println(a.get(3));
		
		
	}
}
