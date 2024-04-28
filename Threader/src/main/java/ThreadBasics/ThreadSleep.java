package ThreadBasics;

//Threads are not precise, make them precise in execution with help of synchronization
public class ThreadSleep implements Runnable {
	
	@Override
	public void run(){
		for(int i = 1; i<5; i++) {
			
				try {
					Thread.sleep(-500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			System.out.println(Thread.currentThread().toString());
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		ThreadSleep ts1 = new ThreadSleep();
		ThreadSleep ts2 = new ThreadSleep();
		Thread thread1 = new Thread(ts1);
		Thread thread2 = new Thread(ts2);
		
		Thread.currentThread().setPriority(10);
		
		thread1.start();
		thread2.start();
		
		
		for(int j = 1; j<5; j++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().toString());
			System.out.println(Thread.currentThread().getName() + " " + j);
		}
	}

}
