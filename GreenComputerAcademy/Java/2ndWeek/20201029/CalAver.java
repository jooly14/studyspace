import java.util.Scanner;
public class CalAver{
	int[] points;
	Scanner sc;
	public CalAver(){
		sc = new Scanner(System.in);
	}
	public void run(){
		System.out.print("학생의 수를 입력하세요 : ");
		int num = sc.nextInt();
		points = new int[num];
		for(int i = 0; i<num;i++){
			System.out.print("학생의 성적을 입력하세요 : ");
			while(true){
				int jum = sc.nextInt();
				if(jum>=0&&jum<=100){
					points[i] = jum;
					break;
				}else{
					System.out.println("잘못된 성적입니다. 다시 입력하세요");
				}
			}
		}
		int sum =0;
		for(int x:points){
			sum = sum+x;
		}
		System.out.println("성적 평균은 "+sum/points.length+"입니다.");
		
	}
	public static void main(String args[]){
		CalAver ca = new CalAver();
		ca.run();
	}
}