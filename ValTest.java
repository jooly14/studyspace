public class ValTest{
	public static void main(String[] args){
		byte b;//최소단위 1바이트, 범위 : -128~127
		short s;//-32768~32767
		int x; //정수 4바이트
		long l;
		
		float y; //실수, 유효숫자가 7개
		double d;//큰 실수, 유효숫자가 15개
		
		String z; //문자열
		char c; //문자 한글자
		
		boolean bo; //true 또는 false
		
		
		//남성표준 =  (1.10  * 체중kg ) - ( 128 * ( 체중kg제곱 / 키cm제곱 )
		//여성표준 =  (1.07 * 체중kg ) - ( 128 * (체중kg제곱 / 키cm제곱 )


		float weight=80.0f;//몸무게
		float height=170.0f;//키
		float result= (1.1f*weight) - (128f*((weight*weight)/(height*height)));//남성의 제지방량 계산
		float fResult= (1.07f*weight) - (128f*((weight*weight)/(height*height)));//여성의 제지방량 계산
		float result1 = weight - result;//체지방량 계산
		float result2 = (result*100)/weight;//제지방률 계산
		float result3 = 100-result2;//제지방률을 이용해서 체지방률 계산
		float result3_1 = (result1*100)/weight;//체지방량을 이용해서 체지방률을 계산
		System.out.println(result3);
		System.out.println(result3_1);

	}
}
