import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MirrorServer extends JFrame{
	 ServerSocket serverSocket = null;
	 PrintWriter pw = null;
	 PrintWriter pw2 = null;
	 BufferedReader br = null;
	 BufferedReader br2 = null;
	 Socket clientSocket = null;
	 Socket clientSocket2 = null;
	 JTextArea ta;
	 JTextField tf;
	public MirrorServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		tf = new JTextField(30);
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(tf.getText()!=null){
					pw.println(tf.getText());
					pw2.println(tf.getText());
					ta.append("SERVER : "+tf.getText()+"\n");
				}
				tf.selectAll();
			}
		});
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane pane = new JScrollPane(ta);
		add(pane);
		add(tf,"South");
		setVisible(true);
		tf.requestFocus();
		init();
		
		process();
	}
	void init(){
	    // �̷�����
	     
	      
	      try {
	         serverSocket = new ServerSocket(5555);
	         ta.append("1 ���� ���� �Ϸ�\n");
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      ta.append("2 ���� �����\n");
	      try {
	         clientSocket = serverSocket.accept();
	         ta.append("3 Ŭ���̾�Ʈ �����\n");
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      //=============��Ʈ��ũ ������====================
	         try {
				pw = new PrintWriter(clientSocket.getOutputStream(),true);
				br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		         ta.append("4 ��� ���� ���� ��\n");
				pw.println("Ŭ���̾�Ʈ�� ������ ȯ���մϴ�.");
				pw.flush();
				ta.append("5 �λ縻 ���� �Ϸ�\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         
	         
	         
	         ta.append("2_1 ���� �����\n");
	         try {
	        	 clientSocket2 = serverSocket.accept();
	        	 ta.append("3_1 Ŭ���̾�Ʈ �����\n");
	         } catch (IOException e) {
	        	 // TODO Auto-generated catch block
	        	 e.printStackTrace();
	         }
	         //=============��Ʈ��ũ ������====================
	         try {
	        	 pw2 = new PrintWriter(clientSocket2.getOutputStream(),true);
	        	 br2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
	        	 ta.append("4 ��� ���� ���� ��\n");
	        	 pw2.println("Ŭ���̾�Ʈ�� ������ ȯ���մϴ�.");
	        	 pw2.flush();
	        	 ta.append("5 �λ縻 ���� �Ϸ�\n");
	         } catch (IOException e) {
	        	 // TODO Auto-generated catch block
	        	 e.printStackTrace();
	         }

	}
	void process(){
		  String l=null;
		  String l2=null;
	         try {
				while(true){
					if((l=br.readLine())!= null){
						System.out.println(l);
						if(l!=null){
							// Ŭ���̾�Ʈ�� ���� ���� ������ ��� �о����
							pw.println(l);//Ŭ���̾�Ʈ�� ����
							pw2.println(l);//Ŭ���̾�Ʈ�� ����
							ta.append("CLIENT : "+l+"\n");
							if(l.equalsIgnoreCase("quit")){
								break;
							}
							
						}
						if((l2=br2.readLine())!= null){
							// Ŭ���̾�Ʈ�� ���� ���� ������ ��� �о����
							pw.println(l2);//Ŭ���̾�Ʈ�� ����
							pw2.println(l2);//Ŭ���̾�Ʈ�� ����
							ta.append("CLIENT : "+l2+"\n");
							if(l2.equalsIgnoreCase("quit")){
								break;
							}
							
						}
					}
				 }
				ta.append("��� ����\n");
				pw.close();
				br.close();
				clientSocket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	      
	}
   public static void main(String[] args) {
	   new MirrorServer();
   }
}

