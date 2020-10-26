import java.util.Scanner;
public class IfFor{
	public static void main(String args[]){
	
		/*
		if(5<2)	//else는 가장 가까운 if문과 매칭이 된다.
			if(10>5)	//중괄호 없이도 if문을 작성할 수 있다.
				System.out.println("yes");
			else
				System.out.println("no");
		else
			System.out.println("바깥 if");
		//하지만 웬만해서는 중괄호를 빼지 않는 편이 좋다.
		*/
		/*
		int k = 1;
		for(int i =0;i<10;i++){
			for(int j = 0;j<10;j++){
				System.out.print(k +" ");
				k++;
			}
			System.out.println();
		}
		*/
		for(int i=2;i<10;i++){
			for(int j=1;j<10;j++){
				System.out.print(i+" * "+j+" = "+i*j+"   ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=1;i<10;i++){
			for(int j=2;j<10;j++){
				System.out.print(j+" * "+i+" = "+i*j+"   ");
			}
			System.out.println();
		}
		System.out.println("=======================");
		for(int i=0;i<5;i++){
			for(int j=0;j<i+1;j++){
			System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=======================");
		for(int i=0;i<5;i++){
			for(int j=0;j<5-i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=======================");
		for(int i=0;i<5;i++){
			for(int j=0;j<4-i;j++){
				System.out.print("  ");
			}
			for(int k=0;k<i+1;k++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("=======================");
		for(int i =0;i<5;i++){
			for(int j=0;j<i;j++){
				System.out.print("  ");
			}
			for(int k=0;k<5-i;k++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=======================");
		for(int i=0;i<5;i++){
			for(int j=0;j<4-i;j++){
				System.out.print("  ");
			}
			for(int k=0;k<i*2+1;k++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=======================");
		System.out.println("홀수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int u = sc.nextInt();
		for(int i=0;i<u;i++){
			for(int j=0;j<Math.abs(u/2-i);j++){
				System.out.print("  ");
			}
			for(int k=u;k>(Math.abs(u/2-i))*2;k--){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}