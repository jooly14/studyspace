import java.io.PrintWriter;
import java.util.Map;

public class ChatProtocol {
	public static void process(String msg,ChatServer1 chatServer1){
		String[] split = msg.split(" ");
		if(split[0].equals("/ban")){
			msg = "/banned";
			chatServer1.ban(split[1],msg);
		}else{
			chatServer1.broadcast("[°øÁö] "+msg);
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
//		ta_chat.append("[°øÁö] "+tf.getText()+"\n");
//		for(Map.Entry<String, PrintWriter> entry: map.entrySet()){
//			entry.getValue().println("[°øÁö] "+tf.getText());
//		}
//	}
//	public void ban(String msg){
//		map.get(msg.substring(5)).println("/banned");
//	}
		
		
	}
	public static String process(String msg,ChatThread chatThread,String id){
		String[] split = msg.split(" ");
		if(split[0].equals("/w")){
			chatThread.whisper(split[1],"[±Ó¼Ó¸»]"+id+": "+msg.substring(msg.indexOf(" ",3)+1));
		}else if(split[0].equals("/banned")){
			chatThread.banned(id+"´ÔÀÌ °­ÅğµÇ¼Ì½À´Ï´Ù.\n");
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
//				ta_chat.append(id+"´ÔÀÌ °­ÅğµÇ¼Ì½À´Ï´Ù.\n");
//				map.get(id).close();
//				map.remove(id);
//				ta_user.setText("== Á¢¼ÓÀÚ ==\n");
//				for(Map.Entry<String, PrintWriter> entry:map.entrySet()){
//					ta_user.append(entry.getKey()+"\n");
//					entry.getValue().println(id+"´ÔÀÌ °­ÅğµÇ¼Ì½À´Ï´Ù.\n");
//				}
//				break;
//			}else{
//				broadcast(msg);
//			}
//		}
		
	}
}
