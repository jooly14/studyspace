import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MessengerB {
	protected JTextField textField;
	protected JTextArea textArea;
	
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	final int myPort = 6000;
	final int otherPort = 5000;
	
	public MessengerB() throws IOException{
		MyFrame f = new MyFrame();
		address = InetAddress.getByName("127.0.0.1");
		socket = new DatagramSocket(myPort);
	}
	
	public void process(){
		while (true) {
			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(packet);
				textArea.append("RECEIVED: "+ new String(buf)+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	class MyFrame extends JFrame implements ActionListener{
		public MyFrame() {
			super("MessengerB");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			textField = new JTextField(30);
			textField.addActionListener(this);
			textArea = new JTextArea();
			textArea.setEditable(false);
			JScrollPane pnl = new JScrollPane(textArea);
			add(textField, BorderLayout.PAGE_END);
			add(pnl,BorderLayout.CENTER);
			setSize(300,200);
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = textField.getText();
			byte[] buffer = s.getBytes();
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length,address,otherPort);
			try {
				socket.send(packet);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textArea.append("SENT: "+s+"\n");
			textField.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
	}
	public static void main(String[] args) throws IOException {
		MessengerB m = new MessengerB();
		m.process();
	}
}
