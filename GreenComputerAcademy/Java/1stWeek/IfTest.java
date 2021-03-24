public class IfTest{
	public static void main(String[] args){
		System.out.println(5+9);
		System.out.println(5-9);
		System.out.println(5*9);
		System.out.println(5/9);//나누기
		System.out.println(9%2);//나머지

		int x = 8;//변수
		//조건문(분기)
		if((x%2) == 0){
			System.out.println("짝수");
		}else{
			System.out.println("홀수");
		}
	}
}