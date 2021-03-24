public class OperTest{
	public static void main(String args[]){
		System.out.println(1+2);//산술연산자
		System.out.println(1-2);
		System.out.println(1*2);
		System.out.println(1/2);
		System.out.println(1%2);
		int i = 1;
		System.out.println("---증감연산자---");
		System.out.println(i++);//후위연산자
		System.out.println(++i);//전위연산자
		System.out.println(i--);
		System.out.println(--i);
		System.out.println("================");
		System.out.println(1>2);
		System.out.println(1<2);
		System.out.println(1>=2);
		System.out.println(1<=2);
		System.out.println(1==2);
		System.out.println(1!=2);

		System.out.println("================");
		System.out.println((1<2)&&(2>3));//둘다 참이어야 참
		System.out.println((1<2)||(2>3));//둘중 하나라도 참이면 참
		
		
	}
}