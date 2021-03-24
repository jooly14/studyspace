public class ValTest4{
	public static void main(String args[]){
	//킬로미터 =마일 *1.60934
	float toKilo = 1.60934f;
	float result1 = 10f/1000f;//미터를 킬로미터로
	float result2 = result1/toKilo;//10미터를 마일로 계산
	System.out.println("10미터는 "+ result2 +"입니다.");
	
	float toPound = 2.20462f;
	float result3 = 100f/1000f; //그램을 킬로그램으로
	float result4 = result3*toPound;//100g을 파운드로 계산
	System.out.println(result4);
	
	float toPyeong = 0.3025f;//제곱미터를 평으로
	float result5 = 150f * toPyeong;//150제곱미터를 평으로 계산
	System.out.println(result5);
	}
}