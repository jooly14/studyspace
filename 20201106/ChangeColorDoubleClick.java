import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeColorDoubleClick extends JFrame {
	int check = 0;
	JPanel pnl;
	public ChangeColorDoubleClick(){
		init();
	}
	void init(){
		pnl = new JPanel();
		pnl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()>=2){
					check++;
					if(check==0){
						pnl.setBackground(Color.red);
					}else if(check==1){
						pnl.setBackground(Color.blue);
					}else if(check==2){
						pnl.setBackground(Color.green);
						check=-1;
					}
					
				}
				
			}
			
		});
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangeColorDoubleClick();
	}
	
	

}
