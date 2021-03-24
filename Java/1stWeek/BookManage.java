import java.util.Scanner;
public class BookManage{
	String book1, book2, book3;
	Scanner sc;
	//스캐너 초기화 기능
	void init(){
		sc = new Scanner(System.in);
	}
	//책제목을 입력받는 기능
	void add(){
		System.out.print("책 제목 입력 : ");
		book1 = sc.next();
		System.out.print("책 제목 입력 : ");
		book2 = sc.next();
		System.out.print("책 제목 입력 : ");
		book3 = sc.next();
	}
	//책제목을 출력하는 기능
	void showData(){
		System.out.println(book1+", "+book2+", "+book3);
	}
	//메뉴를 보여주고 기능을 선택하게 함. 책입력, 책제목 출력, 종료 가능
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