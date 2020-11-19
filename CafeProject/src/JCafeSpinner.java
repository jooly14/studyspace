import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.UtilDateModel;

//발주 등록 버튼을 누르면 나오게 될 화면
public class JCafeSpinner extends JDialog implements ActionListener {
	JPanel pnl;
	JLabel laY, laM, laD;
	JTable table;
	String str[] = { "재료명", "현 재고량", "표준사용량", "표준발주", "실제발주", "Over/Loss" };
	// deadlinelist.txt에 저장된 내용 : 재료명/실제 인벤/전일재고량/표준사용량/표준 재고량/overloss/비고
	// 표준 사용량은 일주일 단위로 사용했던 재료량을 표시
	// 표준 발주= 현 재고량 - 표준사용량
	// 실제 발주는 직접 적을 수 있게 설정
	String strTable[][] = {};
	DefaultTableModel tmodel;
	UtilDateModel dmodel;
	String day1;

	String[][] useData = new String[6][];

	Calendar cal;
	String dt;
	int[] usageSum;//표준사용량

	public JCafeSpinner() {
		cal = Calendar.getInstance();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		dt = transFormat.format(cal.getTime());
		
		this.setSize(500, 530);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		table = new JTable();
		table.setModel(new DefaultTableModel(strTable,str)

		{
			boolean[] columnEditables = new boolean[] { false, false, false, false, true, false};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tmodel = (DefaultTableModel) table.getModel();
		
		
		readFile();
		getAverageUsage();
		setTableData();

		pnl = new JPanel();
		JScrollPane sp = new JScrollPane(table);
		pnl.add(sp);
		this.add(pnl);
		this.setVisible(true);

	}

	void readFile() {

		FileReader fr = null;
		BufferedReader br = null;
		String data[] = { "", "", "", "", "", "" };
		try {
			fr = new FileReader("jcafe_" + dt + "/deadlinelist.txt");
			br = new BufferedReader(fr);
			String readData = "";
			while ((readData = br.readLine()) != null) {
				String[] deadlinelistData = readData.split("" + "/");
				for (int i = 0; i < data.length; i++) {
					data[i] = data[i] + deadlinelistData[i] + "/";
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < data.length; i++) {
			useData[i] = data[i].split("/");
		}

		// 확인용 코드
		/*
		 * for(int i=0;i<useData.length;i++){ for(int
		 * j=0;j<useData[i].length;j++){ System.out.print(useData[i][j]); }
		 * System.out.println(); }
		 */

	}

	void getAverageUsage() {
		String[][] dayUsage = new String[7][];
		for (int i = 0; i < 7; i++) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			String dt2 = transFormat.format(cal.getTime());
			dayUsage[i] = readUsage(dt2).split("/");

		}

		int[][] usageIntArray = new int[dayUsage[0].length][dayUsage.length];
		for (int i = 0; i < dayUsage[0].length; i++) {
			for (int j = 0; j < dayUsage.length; j++) {
				usageIntArray[i][j] = Integer.parseInt(dayUsage[j][i]);

			}
		}
		usageSum = new int[usageIntArray.length];
		int sum = 0;
		for(int j=0;j<usageIntArray.length;j++){
			for(int i=0;i<usageIntArray[0].length;i++){
				sum = sum + usageIntArray[j][i];
			}
			usageSum[j] = sum;
			sum = 0;
		}

	}

	String readUsage(String dt) {
		FileReader fr = null;
		BufferedReader br = null;
		String usageStr = "";
		try {
			fr = new FileReader("jcafe_" + dt + "/deadlinelist.txt");
			br = new BufferedReader(fr);
			String readData = "";
			while ((readData = br.readLine()) != null) {
				String[] deadlinelistData = readData.split("" + "/");
				usageStr = usageStr + deadlinelistData[3] + "/";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return usageStr;

	}

	void setTableData() {
		/*
		 * for (int i = 0; i < useData.length; i++) { for (int j = 0; j <
		 * useData[i].length; j++) { System.out.print(i + "/" + j);
		 * System.out.println("/" + useData[i][j] + "/"); }
		 * System.out.println(); }
		 */
		String[] content = new String[6];
		for (int j = 0; j < useData[0].length; j++) {
			// System.out.println("/" + useData[i][j] + "/");
			content[0] = useData[0][j];
			content[1] = useData[1][j];
			content[2] = usageSum[j]+"";
			if((usageSum[j]-Integer.parseInt(useData[1][j]))<0){
				content[3] = "0";
			}else{
				content[3] = (usageSum[j]-Integer.parseInt(useData[1][j])) + "";
			}
			content[4] = "";
			content[5] = useData[5][j];
			tmodel.addRow(content);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		new JCafeSpinner();
	}

}
