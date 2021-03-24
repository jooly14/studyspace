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
	int[] useTotal; //useTotal stackNameArray 두 배열 다 같은 순서로 되어 있어서 배열인덱스를 같이 써도 됨
	String[][] inventoryArray = new String[3][];	//이름 갯수 단위
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
		// 재고 품목 가져오기 // 어떤 재고를 가지고 있는지 찾아온다
		try {
			fr = new FileReader("files/inventory.txt");
			br = new BufferedReader(fr);
			String readData = null;

			while ((readData = br.readLine()) != null) {
				String[] inventoryData = readData.split("/");
				stockNameStr = stockNameStr + inventoryData[0] + "/"; // 인벤토리에 있는 재고들의 품목을 가져옴
				stockYesterDayStr = stockYesterDayStr + inventoryData[1] + "/"; // 인벤토리에 있는 재고들의 품목을 가져옴
				stockNameUnit = stockNameUnit + inventoryData[2] + "/"; // 인벤토리에 있는 재고들의 품목을 가져옴
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

		// 재고 품목을 배열에 넣었다. 그에 상응하는 사용량 배열을 생성
		// 인덱스를 같이 사용할 예정
		inventoryArray[0] = stockNameStr.split("/");
		inventoryArray[1] = stockYesterDayStr.split("/");
		inventoryArray[2] = stockNameUnit.split("/");
		
		
		useTotal = new int[inventoryArray[0].length];	// 총 사용된 재료양을 담을 예정
		
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String dt = transFormat.format(date);

		getUsingMaterialTotal("jcafe_"+dt+"/coffee.txt","files/coffee_material.txt");
		getUsingMaterialTotal("jcafe_"+dt+"/latte.txt","files/latte_material.txt");
		getUsingMaterialTotal("jcafe_"+dt+"/tea.txt","files/tea_material.txt");
					//매개변수 : 오늘의 판매자료(초기화자료에 판매량 반영된 자료),음료당 사용 재료 저장파일

		
	}
	void getUsingMaterialTotal(String fileName1, String fileName2){
		String drinkIdx = ""; // 몇번째 열에 있는 커피를 주문했는지 확인
		String drinkQuantity = "";	//판매된 음료 개수
		//System.out.println("==============오늘의 판매현황=============");
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
				// 결제내역에 포함된 메뉴의 인덱스만 가져오기
				if (!(splitdata[2].equals("0"))) { // 1개이상 판매된 메뉴만 가져옴
					drinkIdx = drinkIdx + idx + "/"; // 몇번째 열에 있는 메뉴인지 가져옴
					drinkQuantity = drinkQuantity + splitdata[2] + "/"; // 팔린 개수를 가져옴
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
		int[] drinkQuantityArrayInt = new int[drinkQuantityArray.length];	//총 재료 사용량을 더하기 위해서 int형 배열 생성
		if(!(drinkQuantityArray[0].equals(""))){
			for (int i = 0; i < drinkQuantityArray.length; i++) {
				drinkQuantityArrayInt[i] = Integer.parseInt(drinkQuantityArray[i]);
			}
		}
		String[] drinkIdxArray = drinkIdx.split("/");	
		//System.out.println("===========메뉴마다 사용되는 재료량==============");
		// 오늘의 결제내역에 있는 메뉴들을 찾아서 재고 사용량을 가져온다.
		if(!(drinkIdxArray[0].equals(""))){
			try {
				fr = new FileReader(fileName2);
				br = new BufferedReader(fr);
				String readData = null;
				int idx = 0;
				for (int i = 0; i < drinkIdxArray.length; i++) {	//인덱스 몇번 음료를 마셨냐
					while ((readData = br.readLine()) != null) {	//음료 재료 소비량을 줄 단위로 읽어온다
						/*System.out.print(idx + " ");
						System.out.println(readData);*/
						if (idx == Integer.parseInt(drinkIdxArray[i])) {
							String[] useMaterial = readData.split("/"); // 메뉴 당 사용되는 재료들의 목록
							for (int k = 0; k < inventoryArray[0].length; k++) {
								for (int j = 1; j < useMaterial.length; j += 2) {
									if (useMaterial[j].equals(inventoryArray[0][k])) {
										useTotal[k] = useTotal[k]
												+ Integer.parseInt(useMaterial[j + 1]) * drinkQuantityArrayInt[i]; // 재고를 각각 몇개 사용했는지 누적
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

			/*System.out.println("==============재고의 총 사용량=================");
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
