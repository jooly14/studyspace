import javax.swing.*;
import java.awt.*;
public class SwingArrayEx extends JFrame{
	SwingArrayEx(){
		this.setSize(700,700);
		this.setLayout(new FlowLayout());
		JButton[] btns = new JButton[200];
		
		for(int i = 0; i<btns.length;i++){
			btns[i] = new JButton(i+"");
			this.add(btns[i]);
		}
		this.setVisible(true);
	}
	public static void main(String args[]){
	SwingArrayEx sa = new SwingArrayEx();
	}
}