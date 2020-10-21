public class IfTest2{
	public static void main(String args[]){
	//조건문 if switch 삼항연산자
	//반복문 while for dowhile
			/*
			if(조건){
				참
			}else{
				거짓
			}		
			*/
		if(2>3){
			System.out.println("참");
		}else{
			System.out.println("거짓");
		}
		
		//3의 배수인가??
		int i = 5;
		if(i%2==0){
			System.out.println("2의 배수 입니다.");
		}else{
			if(i%3==0){
				
			}else{
				if(i%5==0){
				System.out.println("5의 배수 입니다.");
				}
			}
		}
		
		//위와 똑같은 것이지만 표기 방법이 다르다. 중첩 if문을 else if로 대체
		if(i%2==0){
			System.out.println("2의 배수 입니다.");
		}else if(i%3==0){
			System.out.println("3의 배수 입니다.");
		}else if(i%5==0){
			System.out.println("5의 배수 입니다.");
		}
	
	
	}
}