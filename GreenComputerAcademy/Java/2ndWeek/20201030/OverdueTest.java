package coding;

//연체료 계산을 위한 인터페이스
interface Overdue {
	public void getLateFees(int day);
}

// 인터페이스를 구현하지 않고 추상클래스로 만들어버림
// 상속받은 클래스에서 구현할 수 있도록
abstract class Book implements Overdue {
	int number;
	String title;
	String author;

	// object클래스의 equals메서드를 재정의함
	// number가 같은 경우 같은 book으로 취급
	public boolean equals(Object obj) {
		if (this.number == ((Book) obj).number) {
			return true;
		}
		return false;
	}
}

class Novel extends Book {
	int overdueFee = 300;

	@Override
	public void getLateFees(int day) {
		System.out.println(overdueFee * day);
	}

	// 생성자
	public Novel(int number, String title, String author) {
		this.number = number;
		this.title = title;
		this.author = author;
	}
}

class Poet extends Book {
	int overdueFee = 200;

	@Override
	public void getLateFees(int day) {
		System.out.println(overdueFee * day);
	}

	// 생성자
	public Poet(int number, String title, String author) {
		this.number = number;
		this.title = title;
		this.author = author;
	}
}

class ScienceFiction extends Book {
	int overdueFee = 600;

	@Override
	public void getLateFees(int day) {
		System.out.println(overdueFee * day);
	}

	// 생성자
	public ScienceFiction(int number, String title, String author) {
		this.number = number;
		this.title = title;
		this.author = author;
	}
}

public class OverdueTest {
	public static void main(String args[]) {
		Book[] books = new Book[3];
		books[0] = new Novel(111, "Novel", "Novel");
		books[1] = new Poet(222, "Poet", "Poet");
		books[2] = new ScienceFiction(333, "Poet", "Poet");
		boolean b = books[0].equals(books[1]);
		System.out.println(b);
		for(int i = 0;i<books.length;i++){
			System.out.print(books[i].number+"번 :");
			books[i].getLateFees(10);
		}
	}
}