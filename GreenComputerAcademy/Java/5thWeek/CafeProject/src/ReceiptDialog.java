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
		topPnl.add(new JLabel("                                        ������ "));
		topPnl.add(new JLabel("                            "));
		topPnl.add(new JLabel("   ����� : JCafe"));
		topPnl.add(new JLabel("   �ּ� : �λ걤���� �λ����� ������ �߾Ӵ�� 688   "));
		topPnl.add(new JLabel("   ��ȭ��ȣ : 051-123-4567"));
		topPnl.add(new JLabel("   ������ ��ȣ : "));
		/*Date currentDate = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
		topPnl.add(new JLabel("   �ǸŽð� :"));
		topPnl.add(new JLabel("-------------------------------------------------------------------------"));
		topPnl.add(new JLabel("   ��ǰ                            �ܰ�               ����               �ݾ�"));
		topPnl.add(new JLabel("-------------------------------------------------------------------------"));
		boxPnl.add(topPnl);
		
		JPanel listPnl = new JPanel();
		listPnl.add(new JLabel("���� �ŷ�����"));
		listPnl.setBackground(null);
		boxPnl.add(listPnl);
		
		//���� ���̱� ���� �г�
		JPanel linePnl1 = new JPanel(new GridLayout(0,1));
		linePnl1.add(new JLabel("-------------------------------------------------------------------------"));
		linePnl1.setBackground(null);
		boxPnl.add(linePnl1);
		
		JPanel totalPnl = new JPanel();
		totalPnl.setLayout(new GridLayout(0,2));
		totalPnl.add(new JLabel("   �ŷ��ݾ�"));
		totalPnl.add(new JLabel(""));
		totalPnl.add(new JLabel("   �ΰ�����"));
		totalPnl.add(new JLabel(""));
		totalPnl.add(new JLabel("   TOTAL"));
		totalPnl.setBackground(null);
		boxPnl.add(totalPnl);
		
		//���� ���̱� ���� �г�
		JPanel linePnl2 = new JPanel(new GridLayout(0,1));
		linePnl2.add(new JLabel("-------------------------------------------------------------------------"));
		linePnl2.setBackground(null);
		boxPnl.add(linePnl2);
		add(boxPnl);
		
		JPanel payPnl = new JPanel();
		payPnl.setLayout(new GridLayout(0,2));
		payPnl.add(new JLabel("   �ſ�ī��/����"));
		payPnl.add(new JLabel(""));
		payPnl.add(new JLabel("   �Ž�����"));
		payPnl.add(new JLabel(""));
		payPnl.setBackground(null);
		boxPnl.add(payPnl);
		
		JPanel linePnl3 = new JPanel(new GridLayout(0,1));
		linePnl3.add(new JLabel("-------------------------------------------------------------------------"));
		linePnl3.setBackground(null);
		boxPnl.add(linePnl3);
		
		JPanel stampPnl = new JPanel(new GridLayout(0,1));
		stampPnl.add(new JLabel("   ������ ������: "));
		stampPnl.add(new JLabel("   �� ������: "));
		stampPnl.add(new JLabel("         �ؽ����� 5�� �̻� ������ ��밡���մϴ�. "));
		stampPnl.setBackground(null);
		boxPnl.add(stampPnl);
		
		JPanel linePnl4 = new JPanel(new GridLayout(0,1));
		linePnl4.add(new JLabel("-------------------------------------------------------------------------"));
		linePnl4.setBackground(null);
		boxPnl.add(linePnl4);
		
		//ī������� ������ �г�
		//�Һΰ����̶� ī���ȣ �����;���
		JPanel cardPnl = new JPanel(new GridLayout(0,1));
		cardPnl.add(new JLabel("                                     [[ �ſ�ī�� ]]"));
		cardPnl.add(new JLabel("  �Һΰ��� : "));
		cardPnl.add(new JLabel("  ī���ȣ : "));
		cardPnl.add(new JLabel("  ���ι�ȣ : 75813868"));
		cardPnl.add(new JLabel("  ���͹�ȣ : 890691784"));
		cardPnl.setBackground(null);
		boxPnl.add(cardPnl);
		
		
		JPanel cashPnl = new JPanel(new GridLayout(0,1));
		cashPnl.add(new JLabel("                       [[ ���ݿ�����(�ҵ����) ]]"));
		cashPnl.add(new JLabel("  �ŷ��ڹ�ȣ : "));
		cashPnl.add(new JLabel("  ���ι�ȣ : 75813868"));
		cashPnl.add(new JLabel("  ����û���� http://���ݿ�����.kr�� ���! ����:126"));
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
/*������

����� :
�ּ� :
��ȭ��ȣ :
�ǸŽð� :
---------------------------------------------
��ǰ		 �ܰ�	����	�ݾ�
---------------------------------------------
ī���		4,000	  1	4,000
���̽�Ƽ		3,800	  2	7,600
----------------------------------------------
�ŷ��ݾ�		
�ΰ�����
TOTAL				11,600
-----------------------------------------------
���� �ݾ�		    12,000
�Ž�����				   400
------------------------------------------------*/

/*�ſ�ī��
 �Һΰ���, ī���ȣ,���ι�ȣ : 75813868, ���͹�ȣ : 890691784
 */

/*����
 ���ݿ�����(�ҵ����)
 �ŷ��ڹ�ȣ
 ���ι�ȣ
 ����û���� http://���ݿ�����.kr�� ���! ����:126
 */
 
 