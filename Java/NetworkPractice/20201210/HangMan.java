import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class HangMan {
	Random ran;
	FileReader fr = null;
	BufferedReader br = null;
	StringBuffer answer;
	String str;
	Vector<String> answerList;
	StringBuffer showAns;
	public HangMan() {
		ran = new Random();
		answerList = new Vector<>();
		showAns = new StringBuffer();
		readAnswer();
	}
	void readAnswer(){
		try {
			fr = new FileReader("ggg.txt");
			br = new BufferedReader(fr);
			while((str = br.readLine())!=null){
				answerList.add(str);
			}
			answer = new StringBuffer(answerList.get(ran.nextInt(answerList.size())));
			for (int i = 0; i < answer.length(); i++) {
				showAns.append("_");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(fr!=null){
						fr.close();
					}
					if (br!=null) {
						br.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		startGame();
	}
	void startGame(){
		Scanner sc = new Scanner(System.in);
		int cnt = 10;
		String playerAns = null;
		System.out.println("글자를 입력하시오 "+showAns);
		System.out.print("문자열을 추측하시오: ");
		playerAns = sc.nextLine();
		while (true) {
			cnt--;
			if(answer.indexOf(playerAns.substring(0,1))!=-1){
				showAns.setCharAt(answer.indexOf(playerAns.substring(0,1)), answer.charAt(answer.indexOf(playerAns.substring(0,1))));
			}
			if(showAns.indexOf("_")==-1){
				System.out.println(showAns);
				System.out.println("정답");
				break;
			}else if(cnt==0){
				System.out.println("실패");
				break;
			}else{
				System.out.println("글자를 입력하시오 "+showAns);
				System.out.print("문자열을 추측하시오 (남은 횟수:"+cnt+")");
				playerAns = sc.nextLine();
			}
		}
		
	}
	public static void main(String[] args) {
		new HangMan();
	}
}
