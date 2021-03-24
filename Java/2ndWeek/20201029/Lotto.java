public class Lotto{
	int[] selectedNum = new int[6];	// 로또 번호 5개 저장
	public void run(){
		for(int i=0; i<selectedNum.length;){	//조건에 맞는 입력값이 입력되었을때 i++을 할수 있도록 배치하면 자동으로 i값이 늘어나는 것을 막을 수 있다.
			boolean check = true;
				int num = (int)(Math.random()*45)+1; //1~45
				for(int j=0; j<i;j++){
					if(selectedNum[j] == num){
						check = false;
						System.out.println("중복된 숫자가 발견되었습니다.");
						break;
					}
					
				}
				if(check){
					selectedNum[i] = num;
					i++;
					System.out.println("입력되었습니다.");
				}	
				
		}
		for(int i:selectedNum){
		System.out.print(i+" ");
		}
	}
	public static void main(String args[]){
		Lotto l = new Lotto();
		l.run();
	}
	
}