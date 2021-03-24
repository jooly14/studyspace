import java.util.Scanner;
public class ScanTest6{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("500원의 갯수 :");
		int count500 = scanner.nextInt();
		System.out.println("100원의 갯수 :");
		int count100 = scanner.nextInt();
		System.out.println("50원의 갯수 :");
		int count50 = scanner.nextInt();
		System.out.println("10원의 갯수 :");
		int count10 = scanner.nextInt();
		
		int hap = (count10*10) + (count50*50)+ (count100*100) +(count500*500);
		System.out.println("총 "+ hap +"원입니다.");

	}
}
/*5 저금통에 있는 돈의 금액을 계산하는 프로그램을 작성하시오.
500원 : 5
100원 : 3
50원 : 2
10원 0
총 2900원 입니다.*/