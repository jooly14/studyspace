import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TalentShowEx {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		double sum = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("심사위원의 점수 : ");
			Scanner sc = new Scanner(System.in);
			list.add(sc.nextDouble());
			sum = sum + list.get(i);
		}
		double max = Collections.max(list);
		double min = Collections.min(list);
		sum = sum-max-min;
		System.out.println("점수의 합"+sum);
	}
}
