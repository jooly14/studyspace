public class MethodEx{ // 클래스는 첫글자 대문자
	void myMethod(){ // 메서드는 반환형 + 괄호()
		// void => 반환형이 없다
	}
	
	String myMethod2(){
		String str="asdf";
	//String 은 문자열=>" "   char 문자=> ' '
	// 반환형이 String 이다.
	// 결과(return)는 뭐가 됐든 반드시 int 여야한다.
		return "";
	}
	
	int myMethod3(char c){// 메서드는 첫글자 소문자
		//char c와 같은 매개변수를 받아서 사용가능
		//매개변수의 개수, 타입, 순서 에 따라서
		//메서드 이름이 같더라도 다른 메서드로 인식된다.
		return 0;
	}
	
	
	public static void main(String args[]){
		//여기에 써진 순서대로 진행됩니다.
		// 클래스를 사용하기 위해서는 생성(new)부터!!
		// 생성된 클래스안의 값은 . <=을 통해서 접근
		MethodEx me = new MethodEx();
		// 생성된 값("new MethodEx()")을
		// me 라는 변수에 담아서 사용
		me.myMethod();
		me.myMethod2();
		me.myMethod3('c');// () 안에 값이 없으면 에러
		
	}
}








