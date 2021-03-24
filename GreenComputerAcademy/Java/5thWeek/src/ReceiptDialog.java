import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReceiptDialog extends JDialog{
	
	public ReceiptDialog(){
		//super(frame, true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//setSize(250,300);
		JPanel boxPnl = new JPanel();
		boxPnl.setBackground(Color.white);
		boxPnl.setLayout(new BoxLayout(boxPnl, BoxLayout.Y_AXIS));
		JPanel topPnl = new JPanel();
		topPnl.setBackground(null);
		topPnl.setLayout(new GridLayout(0,1));
		topPnl.add(new JLabel("                            "));
		topPnl.add(new JLabel("                                        영수증 "));
		topPnl.add(new JLabel("                            "));
		topPnl.add(new JLabel("   매장명 : JCafe"));
		topPnl.add(new JLabel("   주소 : 부산광역시 부산진구 부전동 중앙대로 688   "));
		topPnl.add(new JLabel("   전화번호 : 051-123-4567"));
		topPnl.add(new JLabel("   영수증 번호 : "));
		/*Date currentDate = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
		topPnl.add(new JLabel("   판매시간 :"));
		topPnl.add(new JLabel("-------------------------------------------------------------------------"));
		topPnl.add(new JLabel("   상품                            단가               수량               금액"));
		topPnl.add(new JLabel("-------------------------------------------------------------------------"));
		boxPnl.add(topPnl);
		
		JPanel listPnl = new JPanel();
		listPnl.add(new JLabel("여기 거래내역"));
		listPnl.setBackground(null);
		boxPnl.add(listPnl);
		
		//점선 붙이기 위한 패널
		JPanel linePnl1 = new JPanel(new GridLayout(0,1));
		linePnl1.add(new JLabel("-------------------------------------------------------------------------"));
		linePnl1.setBackground(null);
		boxPnl.add(linePnl1);
		
		JPanel totalPnl = new JPanel();
		totalPnl.setLayout(new GridLayout(0,2));
		totalPnl.add(new JLabel("   거래금액"));
		totalPnl.add(new JLabel(""));
		totalPnl.add(new JLabel("   부가세액"));
		totalPnl.add(new JLabel(""));
		totalPnl.add(new JLabel("   TOTAL"));
		totalPnl.setBackground(null);
		boxPnl.add(totalPnl);
		
		//점선 붙이기 위한 패널
		JPanel linePnl2 = new JPanel(new GridLayout(0,1));
		linePnl2.add(new JLabel("-------------------------------------------------------------------------"));
		linePnl2.setBackground(null);
		boxPnl.add(linePnl2);
		add(boxPnl);
		
		JPanel payPnl = new JPanel();
		payPnl.setLayout(new GridLayout(0,2));
		payPnl.add(new JLabel("   신용카드/현금"));
		payPnl.add(new JLabel(""));
		payPnl.add(new JLabel("   거스름돈"));
		payPnl.add(new JLabel(""));
		payPnl.setBackground(null);
		boxPnl.add(payPnl);
		
		JPanel linePnl3 = new JPanel(new GridLayout(0,1));
		linePnl3.add(new JLabel("-------------------------------------------------------------------------"));
		linePnl3.setBackground(null);
		boxPnl.add(linePnl3);
		
		JPanel stampPnl = new JPanel(new GridLayout(0,1));
		stampPnl.add(new JLabel("   적립된 스탬프: "));
		stampPnl.add(new JLabel("   총 스탬프: "));
		stampPnl.add(new JLabel("         ※스탬프 5개 이상 적립시 사용가능합니다. "));
		stampPnl.setBackground(null);
		boxPnl.add(stampPnl);
		
		JPanel linePnl4 = new JPanel(new GridLayout(0,1));
		linePnl4.add(new JLabel("-------------------------------------------------------------------------"));
		linePnl4.setBackground(null);
		boxPnl.add(linePnl4);
		
		//카드결제시 보여줄 패널
		//할부개월이랑 카드번호 가져와야함
		JPanel cardPnl = new JPanel(new GridLayout(0,1));
		cardPnl.add(new JLabel("                                     [[ 신용카드 ]]"));
		cardPnl.add(new JLabel("  할부개월 : "));
		cardPnl.add(new JLabel("  카드번호 : "));
		cardPnl.add(new JLabel("  승인번호 : 75813868"));
		cardPnl.add(new JLabel("  가맹번호 : 890691784"));
		cardPnl.setBackground(null);
		boxPnl.add(cardPnl);
		
		
		JPanel cashPnl = new JPanel(new GridLayout(0,1));
		cashPnl.add(new JLabel("                       [[ 현금영수증(소득공제) ]]"));
		cashPnl.add(new JLabel("  거래자번호 : "));
		cashPnl.add(new JLabel("  승인번호 : 75813868"));
		cashPnl.add(new JLabel("  국세청문의 http://현금영수증.kr에 등록! 문의:126"));
		cashPnl.setBackground(null);
		boxPnl.add(cashPnl);
		
		
		
		add(boxPnl);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new ReceiptDialog();
	}
}
/*영수증

매장명 :
주소 :
전화번호 :
판매시간 :
---------------------------------------------
상품		 단가	수량	금액
---------------------------------------------
카페라떼		4,000	  1	4,000
아이스티		3,800	  2	7,600
----------------------------------------------
거래금액		
부가세액
TOTAL				11,600
-----------------------------------------------
받은 금액		    12,000
거스름돈				   400
------------------------------------------------*/

/*신용카드
 할부개월, 카드번호,승인번호 : 75813868, 가맹번호 : 890691784
 */

/*현금
 현금영수증(소득공제)
 거래자번호
 승인번호
 국세청문의 http://현금영수증.kr에 등록! 문의:126
 */
 
 