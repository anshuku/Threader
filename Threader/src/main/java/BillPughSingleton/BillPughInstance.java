package BillPughSingleton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BillPughInstance {

	public static void main(String[] args) {

		BillPughInstance ins = new BillPughInstance();
		BillPughSingleton bps = BillPughSingleton.getInstance();

		givenSynchronizedLazyLoadedImpl_whenCallGetInstance_thenReturnSingleton();

	}

	private static void givenSynchronizedLazyLoadedImpl_whenCallGetInstance_thenReturnSingleton() {
		Set<BillPughSingleton> setHoldingSingletonObj = new HashSet<>();
		List<Future<BillPughSingleton>> futures = new ArrayList<>();

		//Created a thread pool which reuses a fixed number of thread from an unbounded queue.
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		System.out.println("1 the current thread is " + Thread.currentThread().getName());
		Callable<BillPughSingleton> runnableTask = () -> {
			System.out.println("run called for " + Thread.currentThread().getName());
			return BillPughSingleton.getInstance();
		};
		System.out.println("2 the current thread is " + Thread.currentThread().getName());

//		ExecutorService executorService = Executors.newFixedThreadPool(10);

		int count = 0;
		while (count < 10) {
			futures.add(executorService.submit(runnableTask));
			count++;
		}

		futures.forEach(e -> {
			try {
				setHoldingSingletonObj.add(e.get());
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		});
		executorService.shutdown();
		System.out.println("the count is " + count + " the size of set is " + setHoldingSingletonObj.size());

	}

}
