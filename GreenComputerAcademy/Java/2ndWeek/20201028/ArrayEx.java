public class ArrayEx{
	
	public static void main(String args[]){
		/*
		int[] scores = new int[5];
			scores[0] = 10;
			scores[1] = 20;
			System.out.println(scores[0]);
		*/
		
		int[] a = new int[100];
		for(int i=0; i<100;i++){
			a[i] = (i+1)*10;
		}
		for(int x:a){
			System.out.print(x+" ");
		}
			
	}
}