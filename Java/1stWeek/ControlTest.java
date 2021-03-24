import java.util.Scanner;
public class ControlTest{
	public static void main(String args[]){
		//숫자를 입력 받습니다 1~12 입력받은 숫자에 맞는 "월을 영어로" 출력하세요(switch 문 사용을 사용해 주세요
		Scanner scanner = new Scanner(System.in);
		System.out.print("월을 입력해주세요 : ");
		int month = scanner.nextInt();
		String monthEng = null;
		switch(month){
			case 1: monthEng ="January";
			break;
			case 2: monthEng ="February";
			break;
			case 3: monthEng ="March";
			break;
			case 4: monthEng ="April";
			break;
			case 5: monthEng ="May";
			break;
			case 6: monthEng ="June";
			break;
			case 7: monthEng ="July";
			break;
			case 8: monthEng ="August";
			break;
			case 9: monthEng ="September";
			break;
			case 10: monthEng ="October";
			break;
			case 11: monthEng ="November";
			break;
			case 12: monthEng ="December";
			break;
		}
		System.out.println(monthEng);
	}
}