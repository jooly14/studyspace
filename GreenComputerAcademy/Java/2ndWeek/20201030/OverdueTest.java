package coding;

//��ü�� ����� ���� �������̽�
interface Overdue {
	public void getLateFees(int day);
}

// �������̽��� �������� �ʰ� �߻�Ŭ������ ��������
// ��ӹ��� Ŭ�������� ������ �� �ֵ���
abstract class Book implements Overdue {
	int number;
	String title;
	String author;

	// objectŬ������ equals�޼��带 ��������
	// number�� ���� ��� ���� book���� ���
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

	// ������
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

	// ������
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

	// ������
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
			System.out.print(books[i].number+"�� :");
			books[i].getLateFees(10);
		}
	}
}