class Person3 implements Comparable{
	String name;
	int height;
	
	public Person3(String name, int height){
		this.name = name;
		this.height = height;
	}
	@Override
	public String toString(){
		return name +" "+height;
	}
	
	@Override
	public int compareTo(Object obj) {
        if (this.height == ((Person3)obj).height) {
            return 0;
        } else if(this.height < ((Person3)obj).height) {
            return -1;
        } else {
            return 1;
        }

    }
}
public class PersonTest3{
	public static Person3[] getMaximum(Person3[] array){
		Person3[] maxP = new Person3[array.length];
		maxP[0] =  array[0];
		
		
		for(int i=1;i<array.length;i++){
			if((maxP[0].compareTo(array[i]))==0){
				maxP[i] = array[i];
			}else if(maxP[0].compareTo(array[i])==-1){
				maxP[0]= array[i];
			}
			
		}
		
		return maxP;
	}
	public static void main(String args[]){
		Person3[] array = new Person3[3];
		array[0] =new Person3("홍길동",182);
		array[1] = new Person3("홍길근",175);
		array[2] =new Person3("홍기철",182);
		array = getMaximum(array);
		System.out.println("[가장 키가 큰 사람]");
		for(int i =0;i<array.length;i++){
			int cnt = 0;
			if(array[i]!=null){
				cnt++;
				System.out.println(cnt+". "+array[i]);
			}
		}
	}
}