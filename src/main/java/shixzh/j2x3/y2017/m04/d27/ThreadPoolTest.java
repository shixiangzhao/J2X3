package shixzh.j2x3.y2017.m04.d27;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {

	public static void main(String[] args) {
		String directory;
		String keyword;
		if (args.length == 2) {
			directory = args[0];
			keyword = args[1];
		} else {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.print("Enter base directory: ");
			directory = in.nextLine();
			System.out.print("Enter keyword: ");
			keyword = in.nextLine();
		}
		// 如果有空闲线程可用，立即让它执行任务；如果没有，则创建一个新线程
		ExecutorService pool = Executors.newCachedThreadPool();

		MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
		// 将一个Runnable对象或Callable对象提交给ExecutorService
		// 该池会在方便的时候尽早执行提交的任务，返回Future对象，用来查询该任务的状态
		Future<Integer> result = pool.submit(counter);
		try {
			System.out.println(result.get() + " matching files.");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		pool.shutdown();

		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("largest pool size " + largestPoolSize);
	}
}
