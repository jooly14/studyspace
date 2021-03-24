import java.util.Scanner;
public class ControlTest3{
	public static void main(String args[]){
		/*
		숫자를 3개 입력 받아 정렬하는 프로그램을 만드세요 (if문으로 크기를 비교하시면됩니다.)
		입력1:20
		입력2:10
		입력3:30

		10 20 30 <=출력
		*/
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫번째 숫자 : ");
		int x = scanner.nextInt();
		System.out.println("두번째 숫자 : ");
		int y = scanner.nextInt();
		System.out.println("세번째 숫자 : ");
		int z = scanner.nextInt();
		
		if((x>y)&&(x>z)){
			if(y>z){
			System.out.println(x+" "+y+" "+z);
			}else{
			System.out.println(x+" "+z+" "+y);		
			}
		}else if((y>z)&&(y>x)){
			if(x>z){
				System.out.println(y+" "+x+" "+z);
			}else{
				System.out.println(y+" "+z+" "+x);
			}
		}else{
			if(x>y){
				System.out.println(z+" "+x+" "+y);
			}else{
				System.out.println(z+" "+y+" "+x);
			}
		}
			
		//xyz xzy yxz yzx zxy zyx
		
		
	}
}