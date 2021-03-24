import java.util.Scanner;
public class TheaterReserve{
	byte[] seats;
	Scanner sc;
	public TheaterReserve(){
		seats = new byte[10];
		sc = new Scanner(System.in);
	}
	public void startSystem(){
		while(true){
			System.out.print("좌석을 예약하시겠습니까?(1.예 또는 0.종료) : ");
			int selected = sc.nextInt();
			if(selected==1){
				reserve();
			}else if(selected==0){
				break;
			}
		}
	}
	private void reserve(){
		System.out.println("--------------------------------");
		for(int j=1;j<seats.length+1;j++){
			System.out.print(j+" ");			
		}
		System.out.println("--------------------------------");
		for(int i=0;i<seats.length;i++){			
			System.out.print(seats[i]+" ");
		}
		System.out.print("몇번째 좌석을 예약하시겠습니까?");
		int selected = sc.nextInt();
		seats[selected] = 1;
		System.out.println("예약되었습니다.");
	}
	
	public static void main(String args[]){
		TheaterReserve tr =new TheaterReserve();
		tr.startSystem();
	}
}