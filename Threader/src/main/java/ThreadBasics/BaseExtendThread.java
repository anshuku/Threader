package ThreadBasics;

public class BaseExtendThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Thread is running...");
	}

	public static void main(String[] args) {
		
		BaseExtendThread thread = new BaseExtendThread();
		thread.start();
	}

}
