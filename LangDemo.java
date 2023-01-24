class A implements Cloneable       // to make clonning possible
{
	int x;
	public String toString()     // automatically gets invoked when we print something
	{
		return "The object with value of x : "+x;
	}
	public A Clone()
	{
		try{
			return (A)super.clone();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	public void finalize(){
		System.out.println("Object with value "+x+" getting destroyed");
	}
}

public class LangDemo{
	public static void main(String []args){
		A a1 = new A();
		a1.x = 10;
	
		A a2 = new A();
		a2.x = 50;
		
		A a3 = a1.clone();
		// a3.x = 2000;
		System.out.println(a1.equals(a2));
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);

		Class c1 = a3.getClass();
		System.out.pritnln("a3 is an object of class : "+c1.getName());
		Class c1 = "Hello".getClass();
		System.out.pritnln(" 'Hello' is an object of class : "+c1.getName());		
		
		a2 = null;
		a1 = null;

		System.gc();

		String s1 = "Hello";
		String s2 = "Hello";

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}