class A extends Thread{
	public void run(){
		for(int i=1;i<20;i++)
			System.out.println("i : "+i);
	}
}

class B extends Thread{
	public void run(){
		for(int j=1;j<20;j++)
			System.out.println("j : "+j);
	}
}

class C extends Thread{
	public void run(){
		for(int k=1;k<20;k++)
			System.out.println("k : "+k);
	}
}

public class ThreadDemo{
	public static void main(String []args){
		A a1 = new A();
		B b1 = new B();
		C c1 = new C();

		a1.start();
		b1.start();
		c1.start();
		System.out.println("Main Exit");
	}
}