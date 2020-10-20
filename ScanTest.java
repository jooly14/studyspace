import java.util.Scanner;//외부기능 끌어오기 위해 임포트

public class ScanTest{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);//외부로부터 입력받기 위해 Scanner 필요
		System.out.println("숫자를 입력해 주세요 : ");
		int i= scanner.nextInt();//입력받은 숫자를 변수에 담는다.
		System.out.println("입력받은 숫자는 " + i +"입니다.");
		System.out.println("=========================");
		System.out.println("문자를 입력해 주세요 : ");
		String str = scanner.next();
		System.out.println("입력받은 문자는 " + str +"입니다.");
		System.out.println("=========================");
		System.out.println("실수를 입력해 주세요 : ");
		float f = scanner.nextFloat();
		System.out.println("입력받은 실수는 " + f +"입니다.");
	}
}