import java.util.Scanner;
public class Loop{
	String s = "";
	void add(String str){
		s = s + str;
	}
	void showData(){
	System.out.println(s);
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		Loop l = new Loop();
			for(;;){
				System.out.print("입력(종료하려면 0을 입력하세요) : ");
				String data = scanner.next();
				if(data.equals("0")){		//String 타입은 == 으로 비교를 할 수 없다!!! equals를 사용!!
					break;
				}else{
				l.add(data);
				l.showData();
				}
			}
	}
}