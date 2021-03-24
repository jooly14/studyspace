public class StringTest{
	String str = "";
	//add된 값을 이어서 출력한다.
	void add(String s){
		str = str+s;	
	}
	void add(boolean b){
		str = str+b;
	}
	void add(int i){
		str = str+i;
	}
	void showData(){
		System.out.println(str);
	}

	public static void main(String args[]){
		StringTest st = new StringTest();
		st.add("안녕");
		st.add(true);
		st.add(1);
		st.add("안녕");
		st.showData();	//안녕true1안녕	
	}
}