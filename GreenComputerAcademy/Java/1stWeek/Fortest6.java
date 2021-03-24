public class Fortest6{
	public static void main(String args[]){
		//369게임 100까지 10으로 나눈 나머지 	
		int clap = 0;
		for(int i =1;i<=100;i++){
			if((i%10==3)||(i%10==6)||(i%10==9)||(i%30==0)||(i/10==3)||(i/10==6)||(i/10==9)){
				System.out.print("짝 ");
				clap = clap +1;
				
			}else{
				System.out.print(i+" ");
			}
			
			if(i%10==0){
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("총 짝의 개수는 "+ clap +"개 입니다.");
	}
}