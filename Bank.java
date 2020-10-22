import java.util.Scanner;
public class Bank{
	int amount;
	Scanner scanner;
	//스캐너 초기화기능
	void init(){
		scanner = new Scanner(System.in);
	}
	//입금기능
	void deposit(int i){
		amount = amount+i;
		System.out.println(i+"원이 입금완료되었습니다.");
		checkAmount();
	}
	//출금기능_현재금액보다 더 많은 돈을 출금하는 경우 출금이 되지 않는다.
	void withdraw(int i){
		if(i>amount){
			System.out.println("잔액이 부족합니다.");
		}else{
		amount = amount - i;
		System.out.println(i+"원이 출금완료되었습니다.");
		}
		checkAmount();
	}
	//현재금액확인
	void checkAmount(){
		System.out.println("현재금액 : "+amount);
	}
	
	//원하는 메뉴를 선택할 수 있는 기능
	void select(){
		init();
		for(;;){
			System.out.print("원하는 기능을 선택하세요(입금:1,출금:2,종료:0)");
			int selected = scanner.nextInt();
			
			if(selected==1){
				System.out.print("입금할 금액을 입력하세요");
				int money = scanner.nextInt();
				deposit(money);
			}else if(selected==2){
				System.out.print("출금할 금액을 입력하세요");
				int money = scanner.nextInt();
				withdraw(money);
			}else if(selected==0){
				System.out.println("종료되었습니다.");
				break;
			}else{
				System.out.println("숫자 1,2,0을 선택하세요");
			}
		}
	}
	
	public static void main(String args[]){
		Bank bank = new Bank();
		bank.select();
		
	}
}