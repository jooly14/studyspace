public class ForTest3{
	public static void main(String args[]){
		int odd = 0;
		int even = 0;
		for(int i=1;i<=100;i++){
			if(i%2==0){
				even = even +i;
			}else{
				odd = odd +i;
			}
		}
		System.out.println(even);
		System.out.println(odd);
		
	}
}