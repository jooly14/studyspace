import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileIOTest extends JFrame implements ActionListener{
	JButton btnOpen, btnSave;
	JTextArea ta;
	JFileChooser chooser;
	File file;
	public FileIOTest(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		JPanel pnl = new JPanel();
		btnOpen = new JButton("열기");
		btnSave = new JButton("저장");
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);
		pnl.add(btnOpen);
		pnl.add(btnSave);
		ta = new JTextArea();
		chooser = new JFileChooser();
		
		add(pnl,"South");
		add(ta);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileIOTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
		chooser.setFileFilter(filter);
		if(e.getSource()==btnOpen){
			chooser.setCurrentDirectory(new File("D:/kyj_java/workspace/"));
			chooser.showOpenDialog(this);
			file = chooser.getSelectedFile();
			FileReader fr = null;
			BufferedReader br = null;
			chooser.setCurrentDirectory(file);
			
			if(file!= null){
				ta.setText("");
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					String read = null;
					while((read =br.readLine())!=null){
						ta.append(read+"\n");
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						if(br!=null){
							br.close();
						}
						if(fr!= null){
							fr.close();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}else{
			chooser.showSaveDialog(this);
			file = chooser.getSelectedFile();
			if(file!= null){
				FileWriter fw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(file,true);
					pw = new PrintWriter(fw);
					pw.println(ta.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						if(pw!= null){
							pw.close();
						}
						if(fw!= null){
							fw.close();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
