import java.io.PrintWriter;
import java.util.Map;

public class ChatProtocol {
	public static void process(String msg,ChatServer1 chatServer1){
		String[] split = msg.split(" ");
		if(split[0].equals("/ban")){
			msg = "/banned";
			chatServer1.ban(split[1],msg);
		}else{
			chatServer1.broadcast("[����] "+msg);
		}
//		String[] split = tf.getText().split(" ");
//		if(split[0].equals("/ban")){
//			ban(tf.getText());
//		}else{
//			broadcast();
//		}
//		tf.selectAll();
//		
//	}
//	public void broadcast(){
//		ta_chat.append("[����] "+tf.getText()+"\n");
//		for(Map.Entry<String, PrintWriter> entry: map.entrySet()){
//			entry.getValue().println("[����] "+tf.getText());
//		}
//	}
//	public void ban(String msg){
//		map.get(msg.substring(5)).println("/banned");
//	}
		
		
	}
	public static String process(String msg,ChatThread chatThread,String id){
		String[] split = msg.split(" ");
		if(split[0].equals("/w")){
			chatThread.whisper(split[1],"[�ӼӸ�]"+id+": "+msg.substring(msg.indexOf(" ",3)+1));
		}else if(split[0].equals("/banned")){
			chatThread.banned(id+"���� ����Ǽ̽��ϴ�.\n");
			return "ban";
		}else{
			chatThread.broadcast(id+" : "+msg);
		}
		return "null";
//		if(splitMsg.length>2){
//			if(splitMsg[0].equals("/w")){
//				whisper(msg);
//			}else{
//				broadcast(msg);
//			}
//		}else{
//			if(msg.equals("/banned")){
//				ta_chat.append(id+"���� ����Ǽ̽��ϴ�.\n");
//				map.get(id).close();
//				map.remove(id);
//				ta_user.setText("== ������ ==\n");
//				for(Map.Entry<String, PrintWriter> entry:map.entrySet()){
//					ta_user.append(entry.getKey()+"\n");
//					entry.getValue().println(id+"���� ����Ǽ̽��ϴ�.\n");
//				}
//				break;
//			}else{
//				broadcast(msg);
//			}
//		}
		
	}
}
