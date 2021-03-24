import java.util.Arrays;
import java.util.Collections;

public class LottoEx {
	public static void main(String[] args) {
		String[] nums = new String[45];
		for(int i=0;i<nums.length;i++){
			nums[i] = (i+1)+"";	
		}
		//shuffle ¹è¿­ÀÇ ³»¿ë À§Ä¡¸¦ ·£´ýÇÏ°Ô ¹Ù²ãÁÜ	//list¸¦ ¸Å°³º¯¼ö·Î ÁÜ
		//Arrays.asList() ¹è¿­À» ¸®½ºÆ®·Î ¹Ù²ãÁÜ
		Collections.shuffle(Arrays.asList(nums));
		for(int i=0;i<6;i++){
			System.out.println((i+1)+ " "+nums[i]);
		}
	}
}
