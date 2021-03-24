//생성자 만들기
public class Date{
	int year, month, day;
	
	//기본생성자
	Date(){
		year = 2020;
		month = 10;
		day = 20;
	}
	
	//년만 입력받는 생성자
	Date(int y){
		year = y;
	}
	
	//년월을 입력받는 생성자
	Date(int y, int m){
		year = y;
		month = m;
		/*
		if(month<1||month>12){
			월이 0이하 or 13이상인 경우
		}else{
			month = m;
		}
		*/
	}
	
	//년월일을 입력받는 생성자
	Date(int y, int m, int d){
		year = y;
		month = m;
		day = d;
	}
	
	//년월일을 출력하는 생성자, 월이나 일이 입력되지 않은 경우 그 부분은 출력하지 않는다.
	void showDate(){
		
		if(month==0){
			System.out.println(year+"년");
		}else if(day==0){
			System.out.println(year+"년 "+month+"월");
		}else{
			System.out.println(year+"년 "+month+"월 "+day+"일");
		}
		//System.out.println(year+"년 "+month+"월 "+day+"일");
	}
	
	public static void main(String args[]){
		Date d1 = new Date();
		d1.showDate();
		Date d2 = new Date(2022);
		d2.showDate();
		Date d3 = new Date(2019,2);
		d3.showDate();
		Date d4 = new Date(2018,11,11);
		d4.showDate();
		
	}
}