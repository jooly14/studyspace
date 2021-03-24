public class VendingMachine{
	int money = 0;//받은 금액
	int selected; //선택된 음료 번호
	int inventory[] = new int[10]; //재고량
	String[] canName = new String[10];
	int canPrice[] = new int[10];
	int revenue = 0; //총수익
	
	void getMoney(int money){
		this.money = this.money + money;
		System.out.println(money +"원을 지급받았습니다.");
	}
	
	//지불된 금액이 부족한 경우, 선택된 음료 재고가 부족한 경우 따로 처리
	void selectCan(int selected){
		if(money<canPrice[selected]){
			returnMoney();	
		}else if(inventory[selected]==0){
			outOfStock();
		}else{
		this.selected = selected;
		System.out.println(canName[selected] +"이(가) 선택되었습니다.");
		calculate();
		giveCan();
		giveChange();
			
		}
	}
	//잔액과 수익을 계산
	void calculate(){
		this.money = money -canPrice[selected];
		this.revenue = revenue +canPrice[selected];
		System.out.println(canPrice[selected] + "원이 계산되었습니다.");
	}
	//재고량을 하나 감소시키고 캔을 제공
	void giveCan(){
		inventory[selected] = inventory[selected] -1;
		System.out.println(canName[selected] +"이(가) 나왔습니다.");
		System.out.println("캔의 재고량이 "+inventory[selected] +"개 남았습니다.");
	}
	
	void giveChange(){
		System.out.println("거스름돈 "+money +"원이 나왔습니다.");
		money = 0;
	}
	
	void returnMoney(){
		System.out.println("금액이 부족합니다. "+money +"원이 반환되었습니다.");
		money = 0;
	}
	
	void outOfStock(){
		System.out.println("재고가 없습니다. "+money +"원이 반환되었습니다.");
		money = 0;
	}
	
	
	public static void main(String args[]){
		
		VendingMachine vm = new VendingMachine();
		
		//재고량, 판매하는 제품이름,가격 설정
		vm.inventory[0] = 250;
		vm.inventory[1] = 200;
		vm.canName[0] = "사이다";
		vm.canName[1] = "콜라";
		vm.canPrice[0] = 800;
		vm.canPrice[1] = 900;
		
		
		
		//돈을 넣고 캔을 선택해서 구입
		vm.getMoney(1000);
		vm.selectCan(1);
		/*
		vm.calculate();
		vm.giveCan();
		vm.giveChange();
		*/
	}
	
}