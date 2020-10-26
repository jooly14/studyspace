import java.util.Scanner;
public class RandomEx{
	int myRan(int i){
			return ((int)(Math.random()*i));
		}
	public static void main(String args[]){
		/*
		double ran = Math.random();
		System.out.println(ran);
		int result = ((int)(ran*3))+1;
		System.out.println(result); //1~3의 임의의 숫자 출력
		
		//매개변수로 int를 받아서 받은 숫자까지 사이의 임의의 숫자가 1개 나오는 메서드 작성
		RandomEx r = new RandomEx();
		r.myRan(10);
		r.myRan(100);
		*/
		
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("묵찌빠게임(1:묵, 2:찌, 3:빠 0:종료) : ");
			int user =sc.nextInt();
			RandomEx re = new RandomEx();
			int com = re.myRan(3)+1;
			char cUser=' ';
			char cCom=' ';
			switch(user){
				case 1 : cUser='묵'; break;
				case 2 : cUser='찌'; break;
				case 3 : cUser='빠'; break;
			}
			switch(com){
				case 1 : cCom='묵'; break;
				case 2 : cCom='찌'; break;
				case 3 : cCom='빠'; break;
			}
			if(user==com){
				System.out.println(cUser+" vs "+cCom);
				System.out.println("비겼다.");
			}else if((user==1&&com==2)||(user==2&&com==3)||(user==3&&com==1)){
				System.out.println(cUser+" vs "+cCom);
				System.out.println("승리");
			}else if(user ==0){
				System.out.println("종료");
				break;
			}else{
				System.out.println(cUser+" vs "+cCom);
				System.out.println("패배");
			}
			
		}
	}
}