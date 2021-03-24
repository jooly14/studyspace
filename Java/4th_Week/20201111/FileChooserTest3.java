import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserTest3 extends JFrame implements ActionListener{
	JButton btn;
	JLabel lbl;
	JFileChooser chooser;
	public FileChooserTest3(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		btn = new JButton("이미지 선택");
		btn.addActionListener(this);
		lbl = new JLabel();
		
		add(btn,"North");
		add(lbl);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileChooserTest3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
		chooser.setCurrentDirectory(new File("D:/kyj_java"));
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(this);
		if(ret!=JFileChooser.APPROVE_OPTION){
			JOptionPane.showMessageDialog(this, "이미지가 선택되지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
		}else{
			String path =chooser.getSelectedFile().getPath();
			try {
				FileReader read = new FileReader(path);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
