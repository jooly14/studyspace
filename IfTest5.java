import java.util.Scanner;
public class IfTest5{
	public static void main(String args[]){
	//알바비 계산기 - 주5일제 기준
	Scanner scanner = new Scanner(System.in);
	System.out.println("일한 날짜 : ");
	int day = scanner.nextInt();
	System.out.println("하루당 일한 시간 : ");
	int time = scanner.nextInt();
	System.out.println("시급 : ");
	int hourlyWage = scanner.nextInt();
	int bonus;//한주단위 주휴수당
	int total;
	if((time>=3)&&((time*5)>=15)){
		bonus = time*hourlyWage*(day/5);
		total = (hourlyWage*time*day)+ bonus;
	}else{
		bonus = 0;
		total = hourlyWage*time*day;
	}
	System.out.println("주휴수당( "+ bonus+ "원 ) 포함 이번 달 알바비는 "+ total+"원입니다.");
	
	
	
	
	}
}