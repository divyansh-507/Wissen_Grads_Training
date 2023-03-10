class A extends Thread{
	public void run(){
		for(int i=1;i<=20;i++){
			System.out.println(" i : "+i);	
			try{
				if(i%3 == 0)
					Thread.sleep(2000);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}

class B extends Thread{
	public void run(){
		for(int j=1;j<=20;j++)
			System.out.println(" j : "+j);
			try{
				if(j%4 == 0)
					Thread.sleep(5000);
			}
			catch(Exception e){
				System.out.println(e);
			}
	}
}

class C extends Thread{
	public void run(){
		for(int k=1;k<=20;k++)
			System.out.println(" k : "+k);
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){
				System.out.println(e);
			}
	}
}

public class ThreadFun2 throws Exception{
	public static void main(String []args){
		A a1 = new A();
		B b1 = new B();
		C c1 = new C();

		a1.start();
		b1.start();
		c1.start();
		
		Thread m1 = Thread.currentThread();
		
		a1.setName("Raju");
		a1.setPriority(8);

		System.out.println(a1);
		System.out.println(b1);
		System.out.println(c1);
		System.out.println(m1);

		a1.join();  		// to make main thread to start execution after a1 thread is completed
		b1.join();
		c1.join();

		System.out.println("a1 is alive : "+a1.isAlive());
		System.out.println("b1 is alive : "+b1.isAlive());
		System.out.println("c1 is alive : "+c1.isAlive());

		System.out.println("Main Exit");
	}
}