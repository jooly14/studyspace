import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryTest {
	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		String str = null;
		dic.put("school", "학교");
		dic.put("map", "지도");
		while(true){
			System.out.print("영어 단어를 입력하시오 : ");
			str = sc.next();
			if(str.equals("quit")){
				break;
			}else{
				str = dic.get(str);
				if(str!=null){
					System.out.println("단어의 의미는 "+str);
				}
			}
		}
	}
}
