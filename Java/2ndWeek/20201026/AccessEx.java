public class AccessEx{
	public int i;
	
	public static void main(String args[]){
		/* 접근제어자 - 클래스, 메서드, 생성자, 변수의 제일 앞에 붙입니다.
		public	-아무나 사용가능
		안쓰면(default)	-같은 패키지(폴더) 사용가능
		private	-자신만 사용가능
		protected	-상속받은 자손만 사용가능
		*/
		MyAccess ma = new MyAccess();
		ma.print2();	//ma.print()메서드는 private메서드라서 컴파일 자체가 안됨
		
	}
}