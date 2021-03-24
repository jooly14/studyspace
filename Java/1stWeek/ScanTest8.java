import java.util.Scanner;
public class ScanTest8{
	public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	System.out.println("숫자를 입력하세요 : ");
	int num = scanner.nextInt();
	String result = ((num%2)==1)?"홀수":"짝수";
	System.out.println(result);
	
	
	}
}

/*7 입력받은 숫자가 홀수 인지 짝수 인지 출력하는 프로그램을 작성하시오
   삼항연산자 이용*/