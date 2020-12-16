import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class ChatServerPrac extends JFrame implements ActionListener{
	JPanel pnl;
	JTable table_user;
	JTextArea ta;
	JTextField tf;
	DefaultTableModel model;
	String[] header = {"접속자"};
	String[][] content = {};
	
	String[] headerRoom = {"대화방 이름"};
	String[][] contentRoom = {};
	DefaultTableModel modelRoom;
	JTable tableRoom;
	
	HashMap<String, Room> roomMap = new HashMap<>();
	
	ServerSocket serverSocket;
	Socket clientSocket;
	HashMap<String, PrintWriter> map;
	
	public ChatServerPrac() {
		init();	
		setServer();
		
	}
	public void setServer(){
		try {
			map = new HashMap<>();
			serverSocket = new ServerSocket(5555);
			while (true) {
				clientSocket = serverSocket.accept();
				new serverThread(this,map,clientSocket,ta,model).start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setTitle("서버");
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
		
		
		modelRoom = new DefaultTableModel(contentRoom,headerRoom);
		tableRoom = new JTable(modelRoom);
		JScrollPane pane_tableRoom = new JScrollPane(tableRoom);
		pane_tableRoom.setBounds(0, 0, 600, 350);
		pnl.add(pane_tableRoom);
		
		add(pnl);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ChatServerPrac();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(tf.getText().substring(0, 2).equals("/s")){
			ta.append("Server("+tf.getText().substring(3,tf.getText().indexOf(" ", 3))+" 에게 귓속말) : "+tf.getText().substring(tf.getText().indexOf(" ", 3)+1)+"\n");
			System.out.println(tf.getText().substring(3,tf.getText().indexOf(" ", 3)));
			map.get(tf.getText().substring(3,tf.getText().indexOf(" ", 3))).println("Server("+tf.getText().substring(3,tf.getText().indexOf(" ", 3))+" 에게 귓속말) : "+tf.getText().substring(tf.getText().indexOf(" ", 3)+1));
		}else{
			ta.append("Server : "+tf.getText()+"\n");
			for(Map.Entry<String, PrintWriter> entry: map.entrySet()){
				entry.getValue().println("Server : "+tf.getText());
			}
		}
		tf.selectAll();
	} 
	
	public void createNewRoom(String[] split){
		modelRoom.addRow(new String[]{split[1]});
		roomMap.put(split[1], new Room(split[2],map.get(split[2])));
		synchronized (map) {
			for(Map.Entry<String, PrintWriter> entry:map.entrySet()){
				entry.getValue().println("/uout "+split[2]);
			}
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			if(model.getValueAt(i, 0).equals(split[2])){
				model.removeRow(i);
				break;
			}
		}
	}
	public HashMap<String, Room> getRoomMap(){
		return roomMap;
	}
}
class serverThread extends Thread{
	HashMap<String, PrintWriter> map;
	Socket clientSocket;
	JTextArea ta;
	DefaultTableModel model;
	BufferedReader br;
	PrintWriter pw;
	String id;
	ChatServerPrac chatServerPrac;
	public serverThread(ChatServerPrac chatServerPrac,HashMap<String, PrintWriter> map,Socket clientSocket, JTextArea ta,DefaultTableModel model) {
		this.map =map;
		this.clientSocket = clientSocket;
		this.ta = ta;
		this.model =model;
		this.chatServerPrac =chatServerPrac;
		try {
			pw = new PrintWriter(clientSocket.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			id = br.readLine();
			synchronized (map) {
				for(Map.Entry<String, PrintWriter> entry: map.entrySet()){
					entry.getValue().println("/uin "+id);
				}
				for(String s:map.keySet()){
					pw.println("/user " +s);
				}
				map.put(id, pw);
			}
			model.addRow(new String[]{id.toString()});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		String msg = null;
		String[] split = null;
			try {
				while((msg = br.readLine())!=null){
					split = msg.split(" ");
					if(split[split.length-1].equals("/room")){
						if(split[0].equals("/createRoom")){
							createNewRoom(split);
						}else{
							broadcast(id+" : "+msg);
							ta.append(id+" : "+msg+"\n");
						}
					}else{
						for(String roomName:chatServerPrac.getRoomMap().keySet()){
							System.out.println(roomName);
							if(split[split.length-1].equals(roomName)){
								broadcastRoom(msg,roomName);
								break;
							}
						}
					}
				}
			} catch (IOException e) {
				map.remove(id);
				synchronized (map) {
					for(Map.Entry<String, PrintWriter> entry:map.entrySet()){
						entry.getValue().println("/uout "+id);
					}
				}
				for (int i = 0; i < model.getRowCount(); i++) {
					if(model.getValueAt(i, 0).equals(id)){
						model.removeRow(i);
						break;
					}
				}
			}
	}
	public void broadcastRoom(String msg,String roomName){
		for(Map.Entry<String, PrintWriter> entry:chatServerPrac.getRoomMap().get(roomName).getParticipants().entrySet()){
			entry.getValue().println(msg);
		}
	}
	public void broadcast(String msg){
		synchronized (map) {
			for(Map.Entry<String, PrintWriter> entry: map.entrySet()){
				entry.getValue().println(msg);
			}
		}
	}
	public void createNewRoom(String[] split){
		chatServerPrac.createNewRoom(split);
	}
}