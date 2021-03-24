import java.util.Scanner;
public class IfTest4{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("월급을 입력해주세요 : ");
		int salary = scanner.nextInt();
		System.out.println("판매량을 입력해주세요 : ");
		int count = scanner.nextInt();
		float bonus;
		if(count>=10){
			bonus = 0.1f;
		}else if(count>=5){
			bonus = 0.05f;
		}else{
			bonus = 0.0f;
		}
		
		if(bonus == 0){
			System.out.println("기본급 "
						+ salary +"만원 + 보너스 "+((int)(salary*bonus))
						+"만원 = " +(int)(salary*(1+bonus))+"만원입니다.");
		}else{
			System.out.println("이번달 월급은 판매량"+count+"를 넘었으므로 기본급 "
						+ salary +"만원 + 보너스 "+((int)(salary*bonus))
						+"만원 = " +(int)(salary*(1+bonus))+"만원입니다.");
		}
	
	}
}
