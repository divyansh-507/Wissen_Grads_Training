class A implements Runnable
{
	public void run(){
		System.out.println(Thread.currentThread().getName()+" had Started ...");
		
		synchronized(this)          //autolock (in case of same object executed by multiple threads)
		{
			for(int i=1;i<=20;i++){
				System.out.println(Thread.currentThread().getName()+" : "+i);
				try{
					Thread.sleep(500);
				}
				catch(Exception e){
					System.out.println(e);	
				}
			}
		}
	}
}

public class SynchronizedDemo{
	public static void main(String []args){
		A a1 = new A();

		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a1);
		Thread t3 = new Thread(a1);

		t1.setName("Rita");
		t2.setName("Geeta");
		t3.setName("Sita");	

		t1.start();
		t2.start();
		t3.start();

		System.out.println("Main Exit");
	}
}