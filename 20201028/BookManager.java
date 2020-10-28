import java.util.Scanner;
public class BookManager{
	private String[] books;
	private Scanner sc;
	private int selected;
	public BookManager(){	//변수를 초기화한다.
		sc = new Scanner(System.in);
		books = new String[10];
	}
	public void selectMenu(){
		for(;;){
			System.out.print("메뉴를 선택하세요 (1)책입력 (2)책검색 (3)책삭제 (4)책목록 (0)종료 : ");
			selected = sc.nextInt();
			if(selected==1){
				insert();
			}else if(selected==2){
				search();
			}else if(selected==3){
				delete();
			}else if(selected==4){
				allBooks();
			}else{
				System.out.println("=======[시스템 종료]=======");
				break;
			}
		}
	}
	
	private void insert(){
		String name;
		System.out.println("=======[책입력 메뉴]=======");
		System.out.print("책번호를 입력하세요 : ");
		selected = sc.nextInt();
		System.out.print("책제목을 입력하세요 : ");
		name =sc.next();
		books[selected]=name;
	}
	private void search(){
		System.out.println("=======[책검색 메뉴]=======");
		System.out.print("검색할 번호를 입력하세요 : ");
		selected = sc.nextInt();
		System.out.println("책제목 : "+books[selected]);
	}
	private void delete(){
		System.out.println("=======[책삭제 메뉴]=======");
		System.out.print("삭제할 번호를 입력하세요 : ");
		selected = sc.nextInt();
		books[selected]="";
	}
	private void allBooks(){
		System.out.println("=======[책목록 메뉴]=======");
		for(int i =0;i<books.length;i++){
			if(books[i]==null||books[i]==""){
				
			}else{
				System.out.println(i+"번 : "+books[i]);
			}
		}	
	}
	public static void main(String args[]){
		BookManager bm = new BookManager();
		bm.selectMenu();
	}
	
}