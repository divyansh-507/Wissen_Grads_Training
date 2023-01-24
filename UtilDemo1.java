import java.util.*;

public class UtilDemo1
{
	public static void main(String []args)
	{
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getHours()+" : "+d1.getMinutes()+" : "+d1.getSeconds());
		
		Date d2 = new Date();
		d2.setMonth(9);
		d2.setDate(2);
		System.out.println(d2);

		System.out.println(d1.after(d2));
		System.out.println(d1.before(d2));
		System.out.println(d1.equals(d2));

		Date d3 = new Date();
		d3.setTime(4031327609979L);          // 'L' or 'l' to represent long values
		System.out.println(d3);
		System.out.println("------------------");
		
		String str = "Raju|22:25000;Clerk#raju@abc.com|Blore,Karnataka";

		StringTokenizer st = new StringTokenizer(str, "|#;:");
		// count tokens using a method
           // getNextToken() method to get the next token
		Stack s1 = new Stack();

		s1.push("111");
		s1.push("222");
		s1.push("333");
		s1.push("444");
		s1.push("555");	

		/*
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		System.out.println(s1.peek());
		System.out.println(s1.peek());
		*/

		
		System.out.println(s1.search("777"));
		System.out.println(s1.empty());
		System.out.println("---------------------");

		vector v1 = new Vector(2);

		v1.add("Hello");
		v1.add(new Integer(3223));
		v1.add(new Date());
		v1.add(new Thread());
		v1.add("Thank you");

		Enumeration e = v1.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement);
		}
	
	
	}
}