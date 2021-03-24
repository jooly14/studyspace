class AccessEx{
	private int i;
	private String str; //성별이 담김
	
	public int getI(){
		return i;
	}
	public void setI(int i){
		this.i = i;
	}
	public String getStr(){
		return str;
	}
	public void setStr(String str){
		this.str = str;
	}
	void gender(String s){
		if(s.charAt(0)=='1'){
			str = "남";
		}else if(s.charAt(0)=='2'){
			str = "여";
		}else{
			str = "잘못된 값";
		}
	}
	void print(){
		System.out.println(str);
	}
}

public class AccessExTest{
	public static void main(String args[]){
		AccessEx ae = new AccessEx();
		//ae.i = 10;	//프로젝트에서는 최대한 지향해야 하는 방식.
		//System.out.println(ae.i);
		ae.setI(10);
		System.out.println(ae.getI());
		ae.gender("223");	//사용자로부터 값을 받아서 이를 분석해서 str에 값을 넣는 기능
		//ae.str = "안녕";		//접근이 가능한 경우 예상치 못한 값이 저장될 수 있음
		ae.print();
		
	}
}