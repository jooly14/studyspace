import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryTest {
	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		String str = null;
		dic.put("school", "�б�");
		dic.put("map", "����");
		while(true){
			System.out.print("���� �ܾ �Է��Ͻÿ� : ");
			str = sc.next();
			if(str.equals("quit")){
				break;
			}else{
				str = dic.get(str);
				if(str!=null){
					System.out.println("�ܾ��� �ǹ̴� "+str);
				}
			}
		}
	}
}
