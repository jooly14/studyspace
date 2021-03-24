import java.util.ArrayList;

public class RandomList <T> {
	ArrayList<T> arr = new ArrayList<>();
	public void add(T item){
		arr.add(item);
	}
	public T select(){
		int id = (int)(Math.random()*arr.size());
		return arr.get(id);
	}
	public static void main(String[] args) {
		RandomList<Integer> list = new RandomList<>();
		for (int i = 0; i < 40; i++) {
			list.add(i);
		}
		System.out.println(list.select());
	}
}
