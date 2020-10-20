import java.util.Scanner;
public class ScanTest4{
	public static void main(String args[]){
	/* 3.cm로 입력 받은 키를 피트와 인치로 변환하는 프로그램을 만드시오.
1피트는 12인치 이고 1인치는 2.54cm입니다.
키입력 : 163
163cm는 5피트 4.1732283인치 입니다.*/

	Scanner scanner = new Scanner(System.in);
	System.out.println("키 입력 :");
	int height = scanner.nextInt();
	int feet = 12;
	float inch = 2.54f;
	float result1 = height/inch; //키를 인치 단위로 바꾼다.
	int result2 = (int)result1/feet; //피트를 뽑아내고
	float result3 = result1%feet; // 나머지 인치를 뽑아낸다.
	System.out.println(height +"cm는 " + result2 +"피트 " +result3+" 인치 입니다.");
	
	}
}