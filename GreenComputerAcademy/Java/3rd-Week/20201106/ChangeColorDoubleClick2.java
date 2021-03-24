import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

//이벤트가 발생할 때마다 새로운 객체를 붙여넣으려면!!
//리스너의 메서드에서 컨테이너를 불러오는 것이 필요하다.
//리스너가 해당 컨테이너에 붙어있는 경우에는 e.getsource를 활용해서 가져올수도 있다.
//하지만 그렇지 않은 경우에는 리스너 인터페이스를 구현하거나 어댑터를 상속받아 구현할때 생성자에서 컨테이너를 매개변수로 받아오는 것이 필요하다.
//거기서 받은 컨테이너를 리스너를 구현한 객체에 담아두고 리스너의 메서드가 호출될때 그 컨테이너를 이용해서 새로운 스윙객체를 컨테이너에 붙일 수 있다.
class MyMouseAdapter extends MouseAdapter{
	int check;
	JPanel pnl;
	public MyMouseAdapter(JPanel pnl){
		this.pnl = pnl;
	}
	
	
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
	
}
public class ChangeColorDoubleClick2 extends JFrame {
	int check = 0;
	JPanel pnl;
	public ChangeColorDoubleClick2(){
		init();
	}
	void init(){
		pnl = new JPanel();
		pnl.setBackground(Color.red);
		pnl.addMouseListener(new MyMouseAdapter(pnl));
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangeColorDoubleClick2();
	}
	
	

}
