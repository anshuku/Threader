package BillPughSingleton;

/*
 * Singleton Design Pattern - It's a creational design pattern and it returns the single instance of a class.
 * It's used in classes which are expensive and very time consuming to create - Connection factory, REST adapters, Dao, etc.
 * 
 * It needs three things viz. - 
 * private constructor to prevent instantiation with new operator.
 * public static method to return single instance of a class.
 * private static variable to store the single instance of a class
 * 
 * 
 * Bill Pugh Singleton design pattern support lazy loaded singleton object(defers the initialization of the instance till it’s referred).
 * Prevents eager loading and overheads of lock/unlock due to synchronization.
 * Class loader in java only loads the static inner class SingletonHelper in memory once.
 * Even if multiple threads call getInstance.
 * 
 */
public class BillPughSingleton {

	private BillPughSingleton() {

	}

	private static class SingletonHelper {
		private static final BillPughSingleton BILL_PUGH_SINGLETON_INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.BILL_PUGH_SINGLETON_INSTANCE;
	}

}
