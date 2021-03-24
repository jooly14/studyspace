public class SwitchTest{
	public static void main(String args[]){
		/*
		switch(값){
			case "값1" : 실행구문1; break;
			case "값2" : 실행구문2; break;
			case "값3" : 실행구문3; break;
			default : 실행구문;
		}
		*/
		
		String str;
		switch("HI"){
			case "안녕" : str = "한국어"; 
			break;
			case "HI" : str = "영어"; 
			break;
			case "HOLA" : str = "스페인어"; 
			break;
			default : str = "몰라"; 
		}
		
		System.out.println(str); 
		
		
		
	}
}