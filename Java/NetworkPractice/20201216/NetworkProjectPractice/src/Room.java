import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class Room {
	HashMap<String,PrintWriter> Participants;
	String owner;
	
	public Room(String owner,PrintWriter pw) {
		Participants = new HashMap<>();
		Participants.put(owner,pw);
		this.owner = owner;
	}
	
	public HashMap<String, PrintWriter> getParticipants() {
		return Participants;
	}
	public void addMem(String name,PrintWriter pw){
		Participants.put(name,pw);
	}
	public void removeMem(String name){
		Participants.remove(name);
	}
}
