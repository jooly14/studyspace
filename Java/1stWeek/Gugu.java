public class Gugu{
	//정해진 숫자만큼 구구단을 출력한다.
	String str ="";
	void setNum(int dan, int num){
		for(int i =1;i<=num;i++){
			str= str + (dan+" x "+i+" = "+(dan*i)+"\n");
		}
	}
	void showData(){
		System.out.println(str);
	}
	public static void main(String args[]){
		Gugu g = new Gugu();
		g.setNum(3,5); //2단을 x5까지
		g.showData();
	}
}