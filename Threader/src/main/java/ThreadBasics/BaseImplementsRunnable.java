package ThreadBasics;

public class BaseImplementsRunnable implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Thread is running...");
		
	}

	public static void main(String[] args) {
		
		Thread thread = new Thread(new BaseImplementsRunnable());
		
		thread.start();

	}

	

}
