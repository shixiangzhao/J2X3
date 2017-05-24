package shixzh.j2x3.y2017.m04.d26;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

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

		MatchCounter counter = new MatchCounter(new File(directory), keyword);
		// 创建一个task，计算总directory下的所有结果数
		FutureTask<Integer> task = new FutureTask<>(counter);
		// 启动一个计算，将Future对象交给这个线程，然后忘掉它；
		Thread t = new Thread(task);
		t.start();
		try {
			// Future对象的所有者在计算好结果之后就可以获得它，
			// get()方法阻塞直到计算完成, 还可以设置超时
			System.out.println(task.get() + " matching files.");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
