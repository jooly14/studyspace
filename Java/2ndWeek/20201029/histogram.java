import java.util.Scanner;
public class histogram{
	//사용자가 1-10사이의 숫자를 입력하면 해당 범위의 누적량이 증가한다.
	int[] distribution;
	Scanner sc;
	public histogram(){
		distribution = new int[10];
		sc = new Scanner(System.in);
	}
	public void menu(){
		while(true){
			System.out.print("메뉴를 선택하세요(1.숫자입력 2.분포도보기 3.종료) : ");
			int sel = sc.nextInt();
			if(sel==1){
				insert();
			}else if(sel==2){
				show();
			}else if(sel ==3){
				break;
			}
		}
	}
	private void insert(){
		System.out.print("숫자를 입력하세요(1~100) :");
		int num = sc.nextInt();
		switch((num-1)/10){
			case 0 : distribution[0]++; break;
			case 1 : distribution[1]++; break;
			case 2 : distribution[2]++; break;
			case 3 : distribution[3]++; break;
			case 4 : distribution[4]++; break;
			case 5 : distribution[5]++; break;
			case 6 : distribution[6]++; break;
			case 7 : distribution[7]++; break;
			case 8 : distribution[8]++; break;
			case 9 : distribution[9]++; break;
			
		}
		System.out.println("입력되었습니다.");
	}
	private void show(){
		for(int i=0;i<distribution.length;i++){
			System.out.print(((10*i)+1)+" - "+(10*(i+1))+" :");
				for(int j=0;j<distribution[i];j++){
				System.out.print("*");
				}
			System.out.println();
		}
		
		
	}
	public static void main(String args[]){
		histogram h = new histogram();
		h.menu();
	}
}