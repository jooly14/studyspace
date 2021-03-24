import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JCafeGetStockData extends JFrame {
	int[] useTotal; //useTotal stackNameArray �� �迭 �� ���� ������ �Ǿ� �־ �迭�ε����� ���� �ᵵ ��
	String[][] inventoryArray = new String[3][];	//�̸� ���� ����
	public JCafeGetStockData() {
		stockManage();
		/*setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(0, 5));
		for (int i = 0; i < useTotal.length; i++) {
			pnl.add(new JLabel(inventoryArray[0][i]));
			pnl.add(new JLabel());
			pnl.add(new JLabel(inventoryArray[1][i]+inventoryArray[2][i]));
			pnl.add(new JLabel());
			pnl.add(new JLabel(useTotal[i] + ""));
		}
		add(pnl);
		pack();
		setVisible(true);*/
	}

	void stockManage() {
		FileReader fr = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		FileWriter fw = null;

		String stockNameStr = "";
		String stockYesterDayStr = "";
		String stockNameUnit = "";
		// ��� ǰ�� �������� // � ��� ������ �ִ��� ã�ƿ´�
		try {
			fr = new FileReader("files/inventory.txt");
			br = new BufferedReader(fr);
			String readData = null;

			while ((readData = br.readLine()) != null) {
				String[] inventoryData = readData.split("/");
				stockNameStr = stockNameStr + inventoryData[0] + "/"; // �κ��丮�� �ִ� ������ ǰ���� ������
				stockYesterDayStr = stockYesterDayStr + inventoryData[1] + "/"; // �κ��丮�� �ִ� ������ ǰ���� ������
				stockNameUnit = stockNameUnit + inventoryData[2] + "/"; // �κ��丮�� �ִ� ������ ǰ���� ������
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

		// ��� ǰ���� �迭�� �־���. �׿� �����ϴ� ��뷮 �迭�� ����
		// �ε����� ���� ����� ����
		inventoryArray[0] = stockNameStr.split("/");
		inventoryArray[1] = stockYesterDayStr.split("/");
		inventoryArray[2] = stockNameUnit.split("/");
		
		
		useTotal = new int[inventoryArray[0].length];	// �� ���� ������ ���� ����
		
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);

		getUsingMaterialTotal("jcafe_"+dt+"/coffee.txt","files/coffee_material.txt");
		getUsingMaterialTotal("jcafe_"+dt+"/latte.txt","files/latte_material.txt");
		getUsingMaterialTotal("jcafe_"+dt+"/tea.txt","files/tea_material.txt");
					//�Ű����� : ������ �Ǹ��ڷ�(�ʱ�ȭ�ڷῡ �Ǹŷ� �ݿ��� �ڷ�),����� ��� ��� ��������

		
	}
	void getUsingMaterialTotal(String fileName1, String fileName2){
		String drinkIdx = ""; // ���° ���� �ִ� Ŀ�Ǹ� �ֹ��ߴ��� Ȯ��
		String drinkQuantity = "";	//�Ǹŵ� ���� ����
		//System.out.println("==============������ �Ǹ���Ȳ=============");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName1);
			br = new BufferedReader(fr);
			String readData = null;
			int idx = 0;
			while ((readData = br.readLine()) != null) {
				//System.out.print(idx + ":");
				//System.out.println(readData);
				String[] splitdata = readData.split("/");
				// ���������� ���Ե� �޴��� �ε����� ��������
				if (!(splitdata[2].equals("0"))) { // 1���̻� �Ǹŵ� �޴��� ������
					drinkIdx = drinkIdx + idx + "/"; // ���° ���� �ִ� �޴����� ������
					drinkQuantity = drinkQuantity + splitdata[2] + "/"; // �ȸ� ������ ������
				}
				idx++;
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

		String[] drinkQuantityArray = drinkQuantity.split("/");
		int[] drinkQuantityArrayInt = new int[drinkQuantityArray.length];	//�� ��� ��뷮�� ���ϱ� ���ؼ� int�� �迭 ����
		if(!(drinkQuantityArray[0].equals(""))){
			for (int i = 0; i < drinkQuantityArray.length; i++) {
				drinkQuantityArrayInt[i] = Integer.parseInt(drinkQuantityArray[i]);
			}
		}
		String[] drinkIdxArray = drinkIdx.split("/");	
		//System.out.println("===========�޴����� ���Ǵ� ��ᷮ==============");
		// ������ ���������� �ִ� �޴����� ã�Ƽ� ��� ��뷮�� �����´�.
		if(!(drinkIdxArray[0].equals(""))){
			try {
				fr = new FileReader(fileName2);
				br = new BufferedReader(fr);
				String readData = null;
				int idx = 0;
				for (int i = 0; i < drinkIdxArray.length; i++) {	//�ε��� ��� ���Ḧ ���̳�
					while ((readData = br.readLine()) != null) {	//���� ��� �Һ��� �� ������ �о�´�
						/*System.out.print(idx + " ");
						System.out.println(readData);*/
						if (idx == Integer.parseInt(drinkIdxArray[i])) {
							String[] useMaterial = readData.split("/"); // �޴� �� ���Ǵ� ������ ���
							for (int k = 0; k < inventoryArray[0].length; k++) {
								for (int j = 1; j < useMaterial.length; j += 2) {
									if (useMaterial[j].equals(inventoryArray[0][k])) {
										useTotal[k] = useTotal[k]
												+ Integer.parseInt(useMaterial[j + 1]) * drinkQuantityArrayInt[i]; // ��� ���� � ����ߴ��� ����
									}
								}
							}
							idx++;
							break;
						}
						idx++;
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

			/*System.out.println("==============����� �� ��뷮=================");
			for (int i = 0; i < useTotal.length; i++) {
				System.out.print(stackNameArray[i] + ":");
				System.out.println(useTotal[i]);
			}*/
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JCafeGetStockData();
	}

}
