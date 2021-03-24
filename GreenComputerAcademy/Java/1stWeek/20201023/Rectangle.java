public class Rectangle{
	int garo;
	int sero;
	Rectangle(){
		garo = 50;
		sero = 50;
	}
	Rectangle(int x){
		garo = x;
		sero = x;
	}
	Rectangle(int x, int y){
		garo = x;
		sero = y;
	}
	void printArea(){
		System.out.println("사각형의 넓이 : "+garo*sero);
	}
	void print(){
		System.out.println("가로길이 : "+garo+", 세로길이 : "+sero);
	}
	void showInfo(){
		print();
		printArea();
	}
	public static void main(String args[]){
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(20);
		Rectangle r3 = new Rectangle(20,45);
		r1.showInfo();
		r2.showInfo();
		r3.showInfo();
		/*
		r1.print();
		r1.printArea();
		r2.print();
		r2.printArea();
		r3.print();
		r3.printArea();
		*/
	}
}