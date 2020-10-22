import java.util.Scanner;
public class BookManage{
	String book1;
	String book2;
	String book3;
	Scanner sc;
	
	void init(){
		sc = new Scanner(System.in);
	}
	
	void add(){
		System.out.print("책 제목 입력 : ");
		String title = sc.next();
		book1 =title;
		System.out.print("책 제목 입력 : ");
		title = sc.next();
		book2 =title;
		System.out.print("책 제목 입력 : ");
		title = sc.next();
		book3 =title;		
	}
	
	void showData(){
		System.out.println(book1+", "+book2+", "+book3);
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
	BookManage bm = new BookManage();
	bm.selectMenu();
	
	}
}

/*
BookManage
1.책 입력
2.책 목록
3.종료
*/