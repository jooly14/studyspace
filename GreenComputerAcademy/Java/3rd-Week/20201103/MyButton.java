import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

//BtnColor_Location에서 버튼을 만들때 사용
public class MyButton extends JButton{
	MyButton(String str, Color c){
		this.setBackground(c);
		this.setText(str);
		this.setPreferredSize(new Dimension(50,50));
	}
	public MyButton(String str) {
		this.setBackground(Color.CYAN);
		this.setText(str);
		this.setPreferredSize(new Dimension(50,50));
	}
	
}
