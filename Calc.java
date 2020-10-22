//4칙 연산 계산기 만들기
public class Calc{
	void plus(int x, int y){
		System.out.println(x+" + "+y+" = "+(x+y));
	}
	void minus(int x, int y){
		System.out.println(x+" - "+y+" = "+(x-y));
	}
	void mult(int x, int y){
		System.out.println(x+" * "+y+" = "+(x*y));
	}
	void divide(int x, int y){
		System.out.println(x+" / "+y+" = "+(x/y));
	}

	public static void main(String args[]){
		Calc c = new Calc();
		c.plus(10,5);	//15
		c.minus(10,5);	//5
		c.mult(10,5);	//50
		c.divide(10,5);	//2
	}
}