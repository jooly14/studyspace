import java.util.Scanner;
public class ScanTest2{
	public static void main(String args[]){
	/*1.이름과 나이를 입력받아 출력하는 프로그램 
이름: 김철수
나이: 20
이름은 김철수이고 나이는 20입니다.*/
	Scanner scanner = new Scanner(System.in);
	System.out.println("이름 : ");
	String name = scanner.next();
	System.out.println("나이 : ");
	int age = scanner.nextInt();
	System.out.println("이름은 "+ name + "이고 나이는 " + age +"입니다." );
	
	}

}