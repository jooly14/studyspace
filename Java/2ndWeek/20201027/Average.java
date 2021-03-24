public class Average{
	
	double getAverage(int a, int b){
		return (a+b)/2.0;
	
	}
	double getAverage(int a, int b, int c){
		return (a+b+c)/3.0;
	}
	
	double getAverage(int...v){
		double sum = 0;
		for(int x:v){
			sum = sum+x;
		}
		return sum/v.length;
	}
	
	public static void main(String args[]){
		Average av = new Average();
		System.out.println(av.getAverage(2,5));
		System.out.println(av.getAverage(2,5,7));
		System.out.println(av.getAverage(2,5,7,10));
		
	}
}