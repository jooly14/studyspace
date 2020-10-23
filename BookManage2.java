import java.util.Scanner;
public class BookManage2{
	String[] books = new String[3];
	Scanner sc;
	
	void init(){
		sc = new Scanner(System.in);
	}
	
	void add(){
		for(int i =0;i<3;i++){
			System.out.print("책 제목을 입력하세요 : ");
			books[i] = sc.next();
			
		}
	}
	
	void showData(){
		System.out.println(books[0]+", "+books[1]+", "+books[2]);
	}
	
	void selectMenu(){
		init();
		for(;;){
			System.out.print("메뉴를 선택하세요(1:책입력,2:책목록,3:종료) : ");
			int selected = sc.nextInt();
			if(selected==1){
				add();
			}else if(selected==2){
				showData();
			}else if(selected==3){
				break;
			}else{
				System.out.println("숫자 1,2,3 중에 선택하세요");
			}
		}
	}
	public static void main(String args[]){
	BookManage2 bm = new BookManage2();
	bm.selectMenu();
	
	}
}

/*
BookManage
1.책 입력
2.책 목록
3.종료
*/