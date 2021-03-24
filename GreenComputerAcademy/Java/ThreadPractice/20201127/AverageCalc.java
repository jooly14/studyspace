import java.util.ArrayList;

public class AverageCalc <T extends Number>{
	public double getAverage(T[] nums){
		double d = 0;
		for(int i=0;i<nums.length;i++){
			//number 타입은 int double 등등으로 값을 변환할 수 있는 메서드가 존재한다.
			d = d + nums[i].doubleValue();
		}
		return d/nums.length;
	}
}
