public class ValTest3{
	public static void main(String[] args){
		//원의 넓이 계산
		//반지름*반지름*PI(3.141592)
		float result;
		final float PI = 3.141592f;//상수에는 final 사용, 변수명은 대문자로만 한다.
		//PI = 20; 에러 발생, 상수는 변경 불가하므로..
		int radius = 5;
		result = PI * radius * radius;
		System.out.println(result);
		System.out.println(Math.PI);//미리 정의해둔 것을 사용할 수 있다.
	
		long speed = 300000l;//빛의 초당 속도
		long result1 =60l*60l*24l*365l;//1년이 몇 초
		long result2 = speed*result1;//1년에 가는 거리
		System.out.println(result2);
		
		
		
	}
}