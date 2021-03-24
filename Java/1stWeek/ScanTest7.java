import java.util.Scanner;
public class ScanTest7{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("힘 : ");
		int power = scanner.nextInt();
		System.out.println("면적 : ");
		int area = scanner.nextInt();
		int pa = power * area;
		System.out.println(pa +"파스칼");
	}
}
/*6 압력의 세기를 가리켜 압력이라 말하기도 한다. 
  앞의 정의와 같이 압력의 세기는 (힘)÷(면적)의 단위로 표시된다. 
  국제단위계에서는 1㎡에 1N의 힘이 일정하게 미칠 때의 압력의 세기가 단위이다. 
  이것을 파스칼이라 부르며 Pa라고 표기한다. 힘과 면적을 입력받아 Pa를 출력하시오*/