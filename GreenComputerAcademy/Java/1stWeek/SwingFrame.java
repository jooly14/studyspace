import javax.swing.*;
import java.awt.*;

public class SwingFrame extends JFrame{
		public SwingFrame(){
			this.setLayout(new FlowLayout());
			JButton btn = new JButton("버튼");
			this.add(btn);
			this.setSize(300,200);
			this.setVisible(true);
		}
		
	public static void main(String[] args){
		new SwingFrame();
	}
}