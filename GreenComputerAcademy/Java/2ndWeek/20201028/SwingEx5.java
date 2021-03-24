//모든 클래스는 Object클래스에서 부터 상속받고 있다.
//내가 필요한 클래스 상속을 위해서는 extends 키워드를 사용한다.
import javax.swing.*;
import java.awt.event.*;
public class SwingEx5 extends JFrame implements ActionListener{
	SwingEx5(){
		JButton btn = new JButton("클릭");
		btn.addActionListener(this);
		this.add(btn);
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("눌렀다.");
	}
	public static void main(String args[]){
		SwingEx5 se = new SwingEx5();
		
	}
}