public class LangDemo
{
	public static void main(String[]args){
		int a = 10;
		Integer i = new Interger(a);

		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toHexString(i));
		System.out.println(Interger.toOctalString(i));
		System.out.println(Integer.toString(i)+50);
		System.out.println(Integer.parseInt("4380")+20);
		
		
		byte b;
			
		b= (byte) a;

		a = Interger.paraseInt("25");
		System.out.println("--------------------");
		
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		
		System.out.println("--------------------");
		
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		System.out.println("--------------------");
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println("--------------------");
		
		
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);

		System.out.println("--------------------");
		
	}
}