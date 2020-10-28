import java.util.Scanner;
public class StudentManager{	
	Student[] std;
	Scanner sc;
	public StudentManager(){
	std = new Student[10];
	sc = new Scanner(System.in);
	}
	public void selectMenu(){
		while(true){
			insertNumber("메뉴를 선택하세요 (1)학생추가 (2)학생검색 (3)학생삭제 (4)전체학생출력 (0)종료 : ");
			int selected = sc.nextInt();
			if(selected==1){
				insert();
			}else if(selected==2){
				search();
			}else if(selected==3){
				delete();
			}else if(selected==4){
				printAll();
			}else if(selected==0){
				System.out.println("종료되었습니다.");
				break;
					//System.exit(0);	강제종료
			}
		}
	}
	void insert(){
		System.out.println("학생추가 메뉴입니다.");
		String gender = "";
		insertNumber("번호를 입력하세요 :");
		int num = sc.nextInt();
		insertNumber("학년을 입력하세요 :");
		int grade = sc.nextInt();
		System.out.print("이름을 입력하세요 :");
		String name = sc.next();
		while(true){
			System.out.print("성별을 입력하세요 :");
			gender = sc.next();
			if(gender.equals("남")||gender.equals("여")){
				break;
			}else{
				System.out.println("남이나 여 중에 입력하세요.");
			}
		}
		std[num] = new Student(grade, name, gender);
		System.out.println("추가되었습니다.");
	}
	void search(){
		System.out.println("학생검색 메뉴입니다.");
		insertNumber("번호를 입력하세요 :");
		int num = sc.nextInt();
		if(std[num]==null){
			System.out.println("학생 정보가 없습니다.");
		}else{
			System.out.println(std[num]);
		}
	}
	void delete(){
		System.out.println("학생삭제 메뉴입니다.");
		insertNumber("번호를 입력하세요 :");
		int num = sc.nextInt();
		if(std[num]==null){
			System.out.println("삭제할 학생정보가 없습니다.");
		}else{
		std[num] = null;
		System.out.println("삭제되었습니다.");
		}
	}
	void printAll(){
		System.out.println("[학생 리스트]");
		System.out.println();
		for(int i = 0; i<std.length;i++){
			if(std[i]!=null){
				System.out.println("============== "+i+"번 학생의 정보 ==============");
				System.out.println(std[i]);
				System.out.println();
			}	
		}
	}
	void insertNumber(String str){
		while(true){
			System.out.print(str);
			if(!(sc.hasNextInt())){
					sc.next();
					System.out.println("숫자를 입력하세요!!!");
			}else{
				break;
			}
		}
	}
	public static void main(String args[]){
		StudentManager sm = new StudentManager();
		sm.selectMenu();
	}
}