import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileChooserTest extends JFrame implements ActionListener{
	JButton btn;
	JLabel lbl;
	public FileChooserTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		btn = new JButton("이미지 선택");
		btn.addActionListener(this);
		lbl = new JLabel();
		lbl.setText("     이미지 파일을 선택해주세요");
		add(lbl);
		add(btn,"North");
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileChooserTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg&png", "jpg","png");
		fc.setFileFilter(filter);
		fc.setCurrentDirectory(new File("D:/kyj_java"));
		fc.setAcceptAllFileFilterUsed(false);
		int i = fc.showOpenDialog(this);
		//fc.showSaveDialog(this);
		if(i==JFileChooser.CANCEL_OPTION){
			lbl.setText("     이미지 파일을 선택해주세요");
			lbl.setIcon(null);
		}else{
			String path =fc.getSelectedFile().getPath();
			ImageIcon icon = new ImageIcon(path);
			Image img = icon.getImage();
			img = img.getScaledInstance(280, 250, Image.SCALE_SMOOTH);
			icon = new ImageIcon(img);
			lbl.setText("");
			lbl.setIcon(icon);
			
		}
	}

}
