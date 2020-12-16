import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ChatClientPrac extends JFrame implements ActionListener{
	JPanel pnl;
	JTable table_user;
	JTextArea ta;
	JTextField tf;
	DefaultTableModel model;
	String[] header = {"접속자"};
	String[][] content = {};
	JButton newRoomBtn;
	
	NewRoomPnl newRoomPnl;
	
	PrintWriter pw;
	Socket socket;
	
	String id;
	
	String roomName = "";
	
	String[] headerRoom = {"대화방 이름"};
	String[][] contentRoom = {};
	DefaultTableModel modelRoom;
	JTable tableRoom;
	public ChatClientPrac() {
		init();
		setClient();
	}
	public void setClient(){
		try {
			id = JOptionPane.showInputDialog("아이디");
			setTitle(id+"님의 채팅창");
			socket = new Socket("127.0.0.1",5555);
			pw = new PrintWriter(socket.getOutputStream(),true);
			pw.println(id);
			new ClientThread(id, socket, ta, model, this).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		newRoomPnl = new NewRoomPnl(this);
		
		pnl = new JPanel();
		pnl.setLayout(null);
		model = new DefaultTableModel(content, header);
		table_user = new JTable(model);
		JScrollPane table_pane = new JScrollPane(table_user);
		table_pane.setBounds(600, 0, 200, 530);
		
		tf = new JTextField();
		tf.addActionListener(this);
		tf.setBounds(0, 500, 600, 30);
		ta =  new JTextArea();
		JScrollPane pane = new JScrollPane(ta);
		pane.setBounds(0, 350, 600, 150);
		pnl.add(table_pane);
		pnl.add(pane);
		pnl.add(tf);
		
		newRoomBtn = new JButton("대화방 만들기");
		newRoomBtn.setBounds(0, 300, 150, 50);
		newRoomBtn.addActionListener(this);
		
		modelRoom = new DefaultTableModel(contentRoom,headerRoom);
		tableRoom = new JTable(modelRoom);
		JScrollPane pane_tableRoom = new JScrollPane(tableRoom);
		pane_tableRoom.setBounds(0, 0, 600, 300);
		pnl.add(pane_tableRoom);
		
		
		pnl.add(newRoomBtn);
		add(pnl);
		setVisible(true);
		
	}
	public void createRoom(String name){
		newRoomPnl = new NewRoomPnl(this);
		remove(pnl);
		add(newRoomPnl);
		pw.println("/createRoom "+name+" "+id+" /room");
		roomName = name;
		setTitle("채팅방 : " + name);
		repaint();
		revalidate();
	}
	
	public String getRoomName(){
		return roomName;
	}
	public NewRoomPnl getNewRoomPnl(){
		return newRoomPnl;
	}
	public static void main(String[] args) {
		new ChatClientPrac();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==newRoomBtn){
			new ChatNewRoomDialog(this);
		}else if(e.getSource()==newRoomPnl.exitBtn){
			remove(newRoomPnl);
			add(pnl);
			roomName = "";
			repaint();
			revalidate();
		}else if(e.getSource()==newRoomPnl.tf){
			pw.println(newRoomPnl.tf.getText()+" /room "+roomName);
			tf.selectAll();
		}else{
			pw.println(tf.getText()+" /room");
			tf.selectAll();
			
		}
	}
}
class ClientThread extends Thread{
	Socket socket;
	JTextArea ta;
	DefaultTableModel model;
	BufferedReader br;
	ChatClientPrac chatClientPrac;
	public ClientThread(String id,Socket socket, JTextArea ta,DefaultTableModel model,ChatClientPrac chatClientPrac) {
		this.socket = socket;
		this.ta = ta;
		this.model = model;
		this.chatClientPrac =chatClientPrac;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		String msg;
		try {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while ((msg = br.readLine())!=null) {
				if(chatClientPrac.getRoomName().equals("")){
					System.out.println("ddddd");
					if(msg.substring(0,4).equals("/uin")){
						model.addRow(new String[]{msg.substring(5)});
					}else if(msg.substring(0,5).equals("/uout")){
						for (int i = 0; i < model.getRowCount(); i++) {
							if(model.getValueAt(i, 0).equals(msg.substring(6))){
								model.removeRow(i);
								break;
							}
						}
					}else{
						ta.append(msg+"\n");
					}
					
				}else{
					System.out.println(msg);
//					if(msg.substring(0,4).equals("/uin")){
//						newRoomPnl.model.addRow(new String[]{msg.substring(5)});
//					}else if(msg.substring(0,5).equals("/uout")){
//						for (int i = 0; i < newRoomPnl.model.getRowCount(); i++) {
//							if(newRoomPnl.model.getValueAt(i, 0).equals(msg.substring(6))){
//								newRoomPnl.model.removeRow(i);
//								break;
//							}
//						}
//					}else{
						chatClientPrac.getNewRoomPnl().ta.append(msg+"\n");
//					}
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
