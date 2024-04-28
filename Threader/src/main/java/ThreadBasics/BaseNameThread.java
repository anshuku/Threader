package ThreadBasics;

//In this case run() method is not called as thread is Anonymous
public class BaseNameThread extends Thread{
	
	String name = "";
	
	//Cannot override the final method from Thread
//	public void setName(String name) {
//		this.name = name;
//	}
	
	BaseNameThread(String name){
		this.name = name;
		this.setName("t2");
		
	}

	@Override
	public void run() {
		System.out.println("Thread name is " + Thread.currentThread().getName());
		System.out.println("the name is " + this.name);
		System.out.println("Thread is running...");
		
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread("Thread1");
		thread.start();
		System.out.println("Thread name is " + thread.getName());
		
		BaseNameThread t1 = new BaseNameThread("t1");
		t1.start();
		
	}

}
