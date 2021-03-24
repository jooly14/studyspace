class WrapperEx{
	public static void main(String args[]){
		int x = 10;
		String y = "20";
		System.out.println(x+y); //1020
		int intY = Integer.parseInt(y);
		System.out.println(x+intY); //30
		
		Integer i = 10;
		System.out.println(i.byteValue());
		System.out.println(i.doubleValue());
		System.out.println(Integer.toBinaryString(20));
		System.out.println(Integer.toHexString(20));
		System.out.println(Integer.toOctalString(20));
		
	}
}