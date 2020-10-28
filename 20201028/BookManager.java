import java.util.Scanner;
public class BookManager{
	private String[] books = new String[10];
	private Scanner sc;
	private int selected;
	private String name;
	private void init(){
		sc = new Scanner(System.in);
	}
	public void selectMenu(){
		init();
		for(;;){
			System.out.println("메뉴를 선택하세요 (1)책입력 (2)책검색 (3)책삭제 (4)책목록 (0)종료 : ");
			selected = sc.nextInt();
			if(selected==1){
				System.out.println("책번호를 입력하세요 : ");
				selected = sc.nextInt();
				System.out.println("책제목을 입력하세요 : ");
				name =sc.next();
				insert();
			}else if(selected==2){
				System.out.println("검색할 번호를 입력하세요 : ");
				selected = sc.nextInt();
				search();
			}else if(selected==3){
				System.out.println("삭제할 번호를 입력하세요 : ");
				selected = sc.nextInt();
				delete();
			}else if(selected==4){
				allBooks();
			}else{
				break;
			}
		}
	}
	
	private void insert(){
		books[selected]=name;
	}
	private void search(){
		System.out.println("책제목 : "+books[selected]);
	}
	private void delete(){
		books[selected]="";
	}
	private void allBooks(){
	String bList ="";
	for(int i =0;i<books.length;i++){
		if(books[i]==null){
			
		}else{
		bList = bList+"["+books[i]+"] ";
		}
	}
	System.out.println(bList);
	}
	public static void main(String args[]){
		BookManager bm = new BookManager();
		bm.selectMenu();
	}
	
}