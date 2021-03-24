import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MirrorClient extends JFrame{
	JTextArea ta;
	JTextField tf;
	
	Socket socket = null;
	
	PrintWriter pw = null;
	BufferedReader br = null;
	public MirrorClient() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane pane = new JScrollPane(ta);
		tf = new JTextField(30);
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tf.getText()!=null){
					pw.println(tf.getText());
				}
				ta.append("CLIENT : "+ tf.getText()+"\n");
				ta.setCaretPosition(ta.getDocument().getLength());
				tf.selectAll();
			}
		});
		
		add(pane);
		add(tf,"South");
		setVisible(true);
		tf.requestFocus();
		init();
		process();
	}
	void init(){
		try {
			socket = new Socket("localhost",5555);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pw = new PrintWriter(socket.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void process() throws IOException{
		String l =null;
		String client = null;
		try {
			while ((l = br.readLine())!=null) {
				if(l.equalsIgnoreCase("quit")){
					break;
				}
				ta.append("SERVER : "+l+"\n");
				ta.setCaretPosition(ta.getDocument().getLength());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.close();
		pw.close();
		socket.close();
		System.exit(0);
	}
	public static void main(String[] args) throws IOException {
		new MirrorClient();
	}
}
