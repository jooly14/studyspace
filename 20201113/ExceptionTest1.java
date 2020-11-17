import java.io.IOException;

public class ExceptionTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stringt str = new String();	//에러이다. 오류가 아니라..
		//str = "안녕";
		try{
			System.out.println(10/0);	//java.lang.ArithmeticException
			System.out.println("여기");	//에러 발생으로 출력 안됨
			
		}catch(ArithmeticException e){
			//System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("여기는 무조건 출력됨");	//여기는 무조건 출력됨
		}
		
	}

}
