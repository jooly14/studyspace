import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
//MouseListener와 MouseMotionListener를 테스트해보았다.
//메서드를 각각 구현 실행해보았다.
//클릭할때마다 pressed, released, clicked 차례대로 발생
//클릭될 때 좌표를 가져오거나 클릭횟수를 확인할 수 있다.
public class MouseEventTest extends JFrame implements MouseListener,MouseMotionListener{
	public MouseEventTest(){
		setTitle("Mouse Event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		JPanel pnl = new JPanel();
		pnl.addMouseListener(this);
		pnl.addMouseMotionListener(this);
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseEventTest();
	}
	private void display(String string, MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(string+" X="+e.getX()+" Y="+e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse Dragged",e);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse Moved",e);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse Clicked (# of clicks : "+e.getClickCount()+")",e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse Entered",e);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse Exited",e);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse Pressed (# of clicks : "+e.getClickCount()+")",e);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse Released (# of clicks : "+e.getClickCount()+")",e);

	}

}
