package shixzh.j2x3.y2017.m04.d26;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// Callable<Integer>类型参数是call()的返回值类型, 即最终返回Integer类型的异步计算
public class MatchCounter implements Callable<Integer> {

	private File directory;
	private String keyword;
	private int count;

	public MatchCounter(File directory, String keyword) {
		this.directory = directory;
		this.keyword = keyword;
	}

	@Override
	public Integer call() throws Exception {
		count = 0;
		try {
			File[] files = directory.listFiles();
			// Future保存异步计算的结果
			List<Future<Integer>> results = new ArrayList<>();

			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword);
					// 递归，创建一个task，计算子目录下所有结果数
					FutureTask<Integer> task = new FutureTask<>(counter);
					// 一个目录对应一个task，并保存在list中
					results.add(task);
					Thread t = new Thread(task);
					t.start();
				} else {
					if (search(file)) {
						count++;
					}
				}
			}
			// 统计所有目录下结果数总和
			for (Future<Integer> result : results) {
				try {
					// get()方法阻塞，直到统计出该子目录结果数
					count += result.get();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return count;
	}

	private boolean search(File file) {
		try (Scanner in = new Scanner(file)) {
			boolean found = false;
			int lineNumber = 0;
			while (!found && in.hasNextLine()) {
				lineNumber++;
				String line = in.nextLine();
				System.out.printf("LINE: %s:%d:%s%n", file.getPath(), lineNumber, line);
				if (line.contains(keyword)) {
					found = true;
					System.out.printf("RESULT: %s:%d:%s%n", file.getPath(), lineNumber, line);
				}
			}
			return found;
		} catch (IOException e) {
			return false;
		}
	}
}
