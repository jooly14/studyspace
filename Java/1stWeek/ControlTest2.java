import java.util.Scanner;
public class ControlTest2{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int x = scanner.nextInt();
		
		int result = 1;
		for(int i = 1; i<=x;i++){
			result = result*i;
		}	
		System.out.println(result);
	}
}

/*
팩토리얼 
입력받은 숫자까지의 곱을 구하시오.
입력이 5라면 => 1x2x3x4x5 의 값을 출력하면 됩니다.
*/