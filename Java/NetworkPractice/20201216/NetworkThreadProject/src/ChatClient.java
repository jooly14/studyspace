import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{
	JLabel lbl;
	JTextArea ta;
	JScrollPane pane;
	JTextField tf;
	BufferedReader br;
	PrintWriter pw;
	public ChatClient() {
		init();
		clientSetting();
	}
	public void clientSetting(){
		String id = JOptionPane.showInputDialog("아이디 입력");
		try {
			Socket socket = new Socket("127.0.0.1",5555);
			pw = new PrintWriter(socket.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			lbl.setText("클라이언트("+id+")");
			pw.println(id);
			new ClientThread(br,pw,ta,socket,this).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		
		lbl = new JLabel("클라이언트");
		ta = new JTextArea();
		pane = new JScrollPane(ta);
		
		tf = new JTextField();
		tf.addActionListener(this);
		
		add(lbl,"North");
		add(pane,"Center");
		add(tf,"South");
		setVisible(true);
	}
	public static void main(String[] args) {
		new ChatClient();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		pw.println(tf.getText());
		tf.selectAll();
	}
	void exit(){
		System.exit(0);
	}
}
class ClientThread extends Thread{
	BufferedReader br;
	PrintWriter pw;
	JTextArea ta;
	Socket socket;
	ChatClient chatClient;
	public ClientThread(BufferedReader br, PrintWriter pw, JTextArea ta, Socket socket,ChatClient chatClient) {
		this.br = br;
		this.pw = pw;
		this.ta = ta;
		this.socket = socket;
		this.chatClient = chatClient;
	}
	@Override
	public void run() {
		String line = null;
		try {
			while ((line = br.readLine())!=null) {
				if(line.equals("/banned")){
					pw.println(line);
					break;
				}else{
					ta.append(line+"\n");
					ta.setCaretPosition(ta.getDocument().getLength());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(br!=null){
					br.close();
				}
				if(pw!=null){
					pw.close();
				}
				if(socket!=null){
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		chatClient.exit();
	}
	
}
