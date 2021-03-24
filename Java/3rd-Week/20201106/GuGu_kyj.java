import java.util.Scanner;
public class GuGu_kyj{
	Scanner sc;
	int input; //입력받은 숫자
	
	public GuGu_kyj(){
		sc = new Scanner(System.in);
	}
	void run(){
		while(true){
			System.out.print("숫자를 입력하세요 : ");
			input = sc.nextInt();
			if(input<2){
				System.out.println("잘못된 입력입니다. 더 큰 수를 입력하세요.");
			}else if(input>9){
				System.out.println("잘못된 입력입니다. 더 작은 수를 입력하세요.");
			}else{
				break;
			}
		}
		calculate();
		
		
	}
	void calculate(){
		for(int i=1;i<10;i++){
			System.out.println(input+" X "+i+" = "+(input*i));
		}
	}
	public static void main(String args[]){
		GuGu_kyj p = new GuGu_kyj();
		p.run();
	}
}