public class StringTest{
	public static void main(String args[]){
		String proverb = "A barking dog";
		String s1, s2, s3, s4;
		System.out.println("문자열의 길이 = " +proverb.length());
		char c1;
		s1 = proverb.concat(" never Bites!");	//+연산자로 대체 가능하기 때문에 잘 사용되지 않음
		s2 = proverb.replace('A','a');
		s3 = proverb.substring(2,5);	//글자를 자른다.
		s4 = proverb.toUpperCase();
		c1 = proverb.charAt(0);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(c1);
		System.out.println(proverb.equalsIgnoreCase("a Barking Dog"));
		System.out.println(proverb.replace("barking","sleeping"));
		//replaceAll()은 정규식을 이용
		System.out.println(proverb.toLowerCase());
	}
}