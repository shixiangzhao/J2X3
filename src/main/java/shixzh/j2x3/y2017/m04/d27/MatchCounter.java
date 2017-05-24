package shixzh.j2x3.y2017.m04.d27;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MatchCounter implements Callable<Integer> {

	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;

	public MatchCounter(File directory, String keyword, ExecutorService pool) {
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	@Override
	public Integer call() {
		count = 0;
		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();

			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				} else {
					if (search(file)) {
						count++;
					}
				}
			}
			for (Future<Integer> result : results) {
				try {
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
