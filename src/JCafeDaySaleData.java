import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

class JCafeDaySaleData{
	JCafeMain jc;
	JCafePayment jp;
	DefaultTableModel model;
	
	public JCafeDaySaleData(JCafeMain jc, JCafePayment jp, DefaultTableModel model) {
		this.jc = jc;
		this.jp = jp;
		this.model=model;
		
		saveData();
		jp.dispose();
	}
	void saveData(){
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);
		
		File file = new File(dt);
		BufferedWriter bfw = null;
		FileWriter fw = null;
		boolean isExists = file.exists();
		
		
		if(file.exists()){		//저장할 파일이 있다면 바로 이어서 저장
			try {
				fw = new FileWriter(file, true);
				bfw = new BufferedWriter(fw);
				
				for(int x = 0; x < model.getRowCount(); x++){
					Date data = new Date();
					SimpleDateFormat transFormat2 = new SimpleDateFormat("HH:mm:ss");
					String dt2 = transFormat2.format(data);
					bfw.write(dt2);
					bfw.write("/");
						bfw.write((String)(model.getValueAt(x, 0))+"/"
						+(String)(model.getValueAt(x, 1))+"/"
						+(String)(model.getValueAt(x, 2)));
					bfw.newLine();
				}
				bfw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				
					try {
						if(fw != null)fw.close();
						if(bfw != null)bfw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}else if(isExists == false){			//저장할 파일이 없다면 파일생성 후 저장
			
			String filename = "JCafeDaySaleData"+ File.separator +(dt+".txt");
			try {
				fw = new FileWriter(filename, true);
				bfw = new BufferedWriter(fw);
				
				for(int x = 0; x < model.getRowCount(); x++){
					Date time = new Date();
					SimpleDateFormat transFormat2 = new SimpleDateFormat("HH:mm:ss");
					String dt2 = transFormat2.format(time);
					bfw.write(dt2);
					bfw.write("/");
						bfw.write((String)(model.getValueAt(x, 0))+"/"
								+(String)(model.getValueAt(x, 1))+"/"
								+(String)(model.getValueAt(x, 2)));
					bfw.newLine();
				}
				bfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}