public class ValTest6{
	public static void main(String args[]){
		char a = 'a';
		String s = "abc"; //클래스명은 무조건 대문자로 시작 ,  변수명은 소문자로 시작, 상수는 모두 대문자로
		String s2 = "def";
		System.out.println(a);
		System.out.println(s);
		System.out.println(s+s2);//뭐든지 문자와 더하면 문자가 된다.
		
		int i =10;
		String s3 =s+i; 
		System.out.println(s3);
		
		System.out.println("----------------------");
		System.out.println();
		//System.out.println("abc \\");//역슬래시를 사용하고 싶을때는 \\
		//System.out.println("abc \");
		System.out.println("abc \b"); //백스페이스
		//System.out.println("abc \r"); //return
		System.out.println("abc \'"); 
		//System.out.println("abc \n"); //new line
	}
}