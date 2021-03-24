import java.util.Scanner;
public class IfTest3{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력하세요 : ");
		int point = scanner.nextInt();
		
		if(point>=90){
			System.out.println("A");
		}else if (point>=80){
			System.out.println("B");
		}else if(point>=70){
			System.out.println("C");
		}else{
			System.out.println("F");
		}
		
	}
}