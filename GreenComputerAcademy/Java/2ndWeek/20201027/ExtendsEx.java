import javax.swing.*;

class ExtendsEx extends JFrame{
	
	ExtendsEx(){
		/*	상속을 받지 않았다면 이렇게 써야함
		JFrame f = new JFrame();
		f.setSize(300,200);
		f.setVisible(true);
		*/
		//상속을 받으면 JFrame의 필드,메서드 모두 나 자신의 것이 되므로 따로 JFrame을 생성할 필요가 없다.
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String args[]){
		new ExtendsEx();
	}
}