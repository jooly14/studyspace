import java.util.Scanner;
public class Loop2{
	String s = "";
	Scanner sc;
	void init(){
		sc = new Scanner(System.in);
	}
	void add(String str){
		s = s + str;
	}
	void showData(){
	System.out.println(s);
	}
	void setData(){
		init();
		for(;;){
			System.out.print("입력(종료하려면 0을 입력하세요) : ");
			String data = sc.next();
			if(data.equals("0")){		//String 타입은 == 으로 비교를 할 수 없다!!! equals를 사용!!
				break;
			}else{
				add(data);
				showData();
			}
		}
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		Loop2 l = new Loop2();
		l.setData();
			
	}
}