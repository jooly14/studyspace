import java.util.ArrayList;

public class AverageCalc <T extends Number>{
	public double getAverage(T[] nums){
		double d = 0;
		for(int i=0;i<nums.length;i++){
			//number Ÿ���� int double ������� ���� ��ȯ�� �� �ִ� �޼��尡 �����Ѵ�.
			d = d + nums[i].doubleValue();
		}
		return d/nums.length;
	}
}
