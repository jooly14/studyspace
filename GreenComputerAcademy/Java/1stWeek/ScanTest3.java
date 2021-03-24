import java.util.Scanner;
public class ScanTest3{
	public static void main(String args[]){
	/*2.두개의 정수를 입력받아 앞의 숫자를 뒷 숫자로 나눈 값과 나머지를 출력하시오
숫자1 입력:23
숫자2 입력:5
23을 5로 나눈 나머지는 4이고 나머지는 3입니다.*/

	Scanner scanner = new Scanner(System.in);
	System.out.println("숫자1 입력 :");
	int num1 = scanner.nextInt();
	System.out.println("숫자2 입력 :");
	int num2 = scanner.nextInt();
	int result1 = num1/num2;
	int result2 = num1%num2;
	
	System.out.println(num1 +"을 "+num2 + "로 나눈 몫은 " + result1+ "이고 나머지는 "+ result2 +"입니다.");

	}

}