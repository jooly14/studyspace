import java.util.Arrays;
import java.util.Collections;

public class LottoEx {
	public static void main(String[] args) {
		String[] nums = new String[45];
		for(int i=0;i<nums.length;i++){
			nums[i] = (i+1)+"";	
		}
		//shuffle �迭�� ���� ��ġ�� �����ϰ� �ٲ���	//list�� �Ű������� ��
		//Arrays.asList() �迭�� ����Ʈ�� �ٲ���
		Collections.shuffle(Arrays.asList(nums));
		for(int i=0;i<6;i++){
			System.out.println((i+1)+ " "+nums[i]);
		}
	}
}
