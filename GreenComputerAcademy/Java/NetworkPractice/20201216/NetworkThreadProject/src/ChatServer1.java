import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer1 extends JFrame implements ActionListener{
	JLabel lbl;
	JTextArea ta_chat, ta_user;
	JScrollPane pane_chat, pane_user;
	JTextField tf;
	HashMap<String, PrintWriter> map;
	public ChatServer1() {
		init();	//UI ����
		serverSetting();
		
	}
	public void serverSetting(){
		try {
			ta_chat.append("������ ��ٸ��ϴ�.\n");
			ServerSocket serverSocket = new ServerSocket(5555);
			map = new HashMap<>();
			while (true) {
				Socket socket = serverSocket.accept();
				ChatThread chatThread = new ChatThread(socket,ta_user,map,ta_chat);
				chatThread.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		
		lbl = new JLabel("����");
		ta_chat = new JTextArea("== ä�� ���� ==\n");
		ta_user = new JTextArea("== ������ ==\n");
		pane_chat = new JScrollPane(ta_chat);
		pane_user = new JScrollPane(ta_user);
		
		tf = new JTextField();
		tf.addActionListener(this);
		
		add(lbl,"North");
		add(pane_chat,"Center");
		add(pane_user,"East");
		add(tf,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		new ChatServer1();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ChatProtocol.process(tf.getText(),this);
		tf.selectAll();
		
	}
	public void broadcast(String msg){
		ta_chat.append(msg+"\n");
		for(Map.Entry<String, PrintWriter> entry: map.entrySet()){
			entry.getValue().println(msg);
		}
	}
	public void ban(String toWhom, String msg){
		map.get(toWhom).println(msg);
	}
}
class ChatThread extends Thread{
	Socket socket;
	JTextArea ta_user;
	HashMap<String, PrintWriter> map;
	
	BufferedReader br;
	PrintWriter pw;
	String id;
	JTextArea ta_chat;
	public ChatThread(Socket socket,JTextArea ta_user,HashMap<String, PrintWriter> map,JTextArea ta_chat) {
		this.socket =socket;
		this.ta_user = ta_user;
		this.map = map;
		this.ta_chat =ta_chat;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(),true);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			id = br.readLine();
			ta_user.append(id+"\n");
			synchronized(map){
				for(Map.Entry<String, PrintWriter> entry:map.entrySet()){
					entry.getValue().println(id+"���� �����ϼ̽��ϴ�.\n");
				}
				map.put(id, pw);
				ta_chat.append(id+"���� �����ϼ̽��ϴ�.\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String msg = null;
		String[] splitMsg = null;
		try {
			while ((msg=br.readLine())!=null) {
				String output = ChatProtocol.process(msg,this,id);
				if(output.equals("ban")){
					break;
				}
			}
		} catch (IOException e) {
			ta_chat.append(id+"���� �����̽��ϴ�.\n");
			map.get(id).close();
			map.remove(id);
			ta_user.setText("== ������ ==\n");
			for(Map.Entry<String, PrintWriter> entry:map.entrySet()){
				ta_user.append(entry.getKey()+"\n");
			}
		}
	}
	
	
	public void banned(String msg){
			ta_chat.append(msg);
			map.get(id).close();
			map.remove(id);
			ta_user.setText("== ������ ==\n");
			for(Map.Entry<String, PrintWriter> entry:map.entrySet()){
				ta_user.append(entry.getKey()+"\n");
				entry.getValue().println(msg);
			}
	}
	public void broadcast(String msg){
		ta_chat.append(msg+"\n");
		synchronized (map) {
			for(Map.Entry<String, PrintWriter> entry :map.entrySet()){
				entry.getValue().println(msg);
			}
		}
	}
	
	public void whisper(String toWhom,String msg){
		map.get(toWhom).println(msg);
	}
}