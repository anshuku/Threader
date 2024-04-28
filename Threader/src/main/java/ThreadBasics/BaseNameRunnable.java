package ThreadBasics;

public class BaseNameRunnable implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Thread name is " + Thread.currentThread().getName());
		System.out.println("Thread is running...");
		
	}

	public static void main(String[] args) {
		
		BaseNameRunnable bnr = new BaseNameRunnable();
		
		Thread thread = new Thread(bnr, "t1");
		
		thread.start();

	}

}
