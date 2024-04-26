package ThreadBasics;

class AB implements Runnable{
	
	public void run() {
		
		System.out.println("The state of current thread inside run of AB for thread " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t1 inside AB " + ThreadStateLearn.t1.getState());
		try {
			
			Thread.sleep(100);
			
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("The state of current thread post sleep inside run of AB for thread " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t1 inside AB after t2 sleeps is " + ThreadStateLearn.t1.getState());
		
		try {
			
			Thread.sleep(100);
			
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("The state of current thread post join inside run of AB for thread " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t1 inside AB after t2 joins " + ThreadStateLearn.t1.getState());
		

		try {
			
			Thread.sleep(100);
			
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("t2 join inside AB");
		
		System.out.println("The state of current thread post join and sleep inside run of AB for thread " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t1 inside AB after t2 joins " + ThreadStateLearn.t1.getState());
		
		
	}
	
}


public class ThreadStateLearn implements Runnable {
	
	public static ThreadStateLearn thr;
	
	public static Thread t1;
	
	public void run() {
		
		System.out.println("The state of t1 inside ThreadStateLearn run " + t1.getState());
		System.out.println("The state of current thread " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		AB abc = new AB();
		Thread t2 = new Thread(abc);
		t2.setName("t2");
		System.out.println("The state of t2 after creation " + t2.getState());
		
		t2.start();
		
		System.out.println("The state of t2 after starting it is " + t2.getState());
		
		System.out.println("t1 sleep");
		
		try {
			//Making the thread t1 sleep so that it moves to timed_waiting
			Thread.sleep(200);
			//Making the thread t1 wait so that it moves to waiting
			//t1.wait();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Post sleep");
		
		System.out.println("The state of current thread ps " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t2 is " + t2.getState());
		
		System.out.println("t2 join");
		try {
			//Making the thread t2 join so that it moves to timed_waiting
			t2.join(200);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Post join");
		
		System.out.println("The state of current thread pj " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t2 ps is " + t2.getState() + " calling join on t2");
		
		try {
			//Making the thread t1 sleep so that it moves to timed_waiting
			Thread.sleep(200);
			//Making the thread t1 wait so that it moves to waiting
			//t1.wait();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("The state of current thread pj and ps " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t2 pj and ps is " + t2.getState() + " calling join on t2");
	}
	
	public static void main(String[] args) {
		thr = new ThreadStateLearn();
		t1 = new Thread(thr);
		t1.setName("t1");
		
		System.out.println("The state of current thread " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t1 after creating it is " + t1.getState());
		
		t1.start();
		
		//Thread.yield();
		
		//System.out.println("The state of current thread " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
		
		System.out.println("The state of t1 post start() " + t1.getState());
	}

}