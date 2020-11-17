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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class FileIOTest2 extends JFrame implements ActionListener {
	JButton insertBtn, openBtn, saveBtn;
	JTextField name, title;
	JTable table;
	DefaultTableModel model;
	String[] header = { "번호", "제목", "글쓴이" };
	String[][] contents = {};
	int idx;
	File file;

	public FileIOTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);

		JPanel pnl = new JPanel();

		insertBtn = new JButton("입력");
		openBtn = new JButton("열기");
		saveBtn = new JButton("저장");
		name = new JTextField(5);
		title = new JTextField(10);
		insertBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		pnl.add(new JLabel("제목"));
		pnl.add(title);
		pnl.add(new JLabel("글쓴이"));
		pnl.add(name);
		pnl.add(insertBtn);
		pnl.add(openBtn);
		pnl.add(saveBtn);

		model = new DefaultTableModel(contents, header);
		table = new JTable(model);
		JScrollPane tablepnl = new JScrollPane(table);
		add(tablepnl);
		add(pnl, "South");
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileIOTest2();
	}
	void insertData(){
		String[] data = new String[3];
		data[0] = (idx + 1) + "";
		data[1] = title.getText();
		data[2] = name.getText();
		idx++;
		model.addRow(data);
		title.requestFocus();
		title.selectAll();
		name.selectAll();
	}
	//파일을 오픈할때 기존에 있던 데이터를 모두 테이블에서 지우고 파일의 내용을 불러온다
	void fileOpen(JFileChooser chooser){
		file = chooser.getSelectedFile();
		if (file != null) {
			int count = model.getRowCount();
			for (int i = 0; i < count; i++) {
				model.removeRow(0);
			}
			BufferedReader br = null;
			FileReader fr = null;
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String str = null;
				String[] readData = new String[3];
				while ((str = br.readLine()) != null) {
					readData = str.split("/");
					model.addRow(readData);
				}
				idx = Integer.parseInt(readData[0]);
				title.requestFocus();
				JOptionPane.showMessageDialog(this, "파일열기 완료");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (fr != null) {
						fr.close();
					}
					if (br != null) {
						br.close();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	} 
	//기존에 있던 파일이 아니라 새파일에 저장하는 경우
	void newFileSave(JFileChooser chooser){
		
			file = chooser.getSelectedFile();
			if (file != null) {
				PrintWriter pw = null;
				FileWriter fw = null;
				try {
					fw = new FileWriter(file, false);
					pw = new PrintWriter(fw);

					for (int i = 0; i < table.getRowCount(); i++) {
						String str = "";
						for (int j = 0; j < 3; j++) {
							str = str + table.getValueAt(i, j) + "/";
						}
						pw.println(str);
					}
					JOptionPane.showMessageDialog(this, "파일저장 완료");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						if (pw != null) {
							pw.close();
						}
						if (fw != null) {
							fw.close();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
	}
	//openfile로 가져온 파일에 저장하는 경우 변경된 내용을 반영
	//중복되게 저장되지 않게 함
	//confirmdialog로 저장여부 확인
	void currentFileSave(JFileChooser chooser){
		int choice = JOptionPane.showConfirmDialog(this, "변경된 사항을 저장하시겠습니까?");
		if (choice == JOptionPane.OK_OPTION) {
			file = chooser.getSelectedFile();
			if (file != null) {
				PrintWriter pw = null;
				FileWriter fw = null;
				try {
					fw = new FileWriter(file, false);
					pw = new PrintWriter(fw);

					for (int i = 0; i < table.getRowCount(); i++) {
						String str = "";
						for (int j = 0; j < 3; j++) {
							str = str + table.getValueAt(i, j) + "/";
						}
						pw.println(str);
					}
					JOptionPane.showMessageDialog(this, "파일저장 완료");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						if (pw != null) {
							pw.close();
						}
						if (fw != null) {
							fw.close();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		} else {
			JOptionPane.showMessageDialog(this, "저장 취소되었습니다.");
		}
	}
	//새 파일도 아니고, 열었던 파일도 아닌 기존에 있던 다른 파일에 저장하는 경우
	// 기존에 있던 내용에 내용을 더한다.
	void anotherFileSave(JFileChooser chooser){
		file = chooser.getSelectedFile();
		if (file != null) {
			PrintWriter pw = null;
			FileWriter fw = null;
			try {
				fw = new FileWriter(file, true);
				pw = new PrintWriter(fw);

				for (int i = 0; i < table.getRowCount(); i++) {
					String str = "";
					for (int j = 0; j < 3; j++) {
						str = str + table.getValueAt(i, j) + "/";
					}
					pw.println(str);
				}
				JOptionPane.showMessageDialog(this, "파일저장 완료");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (pw != null) {
						pw.close();
					}
					if (fw != null) {
						fw.close();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new File("d:/kyj_java/workspace/"));
		if (e.getSource() == insertBtn) {
			insertData();
		} else if (e.getSource() == openBtn) {
			int choice = chooser.showOpenDialog(this);
			if(choice== JFileChooser.APPROVE_OPTION){	//승인 버튼을 눌렀을 때만 열기 기능이 실행되도록 함
				fileOpen(chooser);
			}
		} else {
			int choice = chooser.showSaveDialog(this);
			if(choice == JFileChooser.APPROVE_OPTION){	//승인 버튼을 눌렀을 때만 저장기능이 실행되도록 함
				if (file == null) {
					newFileSave(chooser);
				} else {
					
					if (file.getPath().equals(chooser.getSelectedFile().getPath())) {
						currentFileSave(chooser);
					} else {
						anotherFileSave(chooser);
					}
				}
				
			}
		}
	}
}
