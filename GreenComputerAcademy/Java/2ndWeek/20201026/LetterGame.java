import java.util.Scanner;
public class LetterGame{
	int answer = ((int)(Math.random()*100))+1;
	Scanner sc;
	int uAnswer;
	int count = 0;
	void init(){
		sc = new Scanner(System.in);
	}
	void start(){
		init();
		do{
			count++;
			System.out.println("정답을 추측하여 보시오(범위 : 0~100) : ");
			uAnswer = sc.nextInt();
			if(uAnswer>answer){
				System.out.println("제시한 정수가 높습니다.");
			}else if(uAnswer<answer){
				System.out.println("제시한 정수가 낮습니다.");
			}else{
				System.out.println("축하합니다. 시도 횟수는 "+count+"회 입니다.");
			}
			
		}while(uAnswer!=answer);
	}
	public static void main(String args[]){
		LetterGame game = new LetterGame();
		game.start();
		
	}
}