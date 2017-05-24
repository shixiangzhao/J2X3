package shixzh.j2x3.y2017.m04.d25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class SearchTask implements Runnable {

	private BlockingQueue<File> queue;
	private String keyword;

	public SearchTask(BlockingQueue<File> queue, String keyword) {
		this.queue = queue;
		this.keyword = keyword;
	}

	@Override
	public void run() {
		try {
			boolean done = false;
			while (!done) {
				File file = queue.take();
				if (file == FileEnumerationTask.DUMMY) {
					queue.put(file);
					done = true;
				} else {
					Search(file);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void Search(File file) throws FileNotFoundException {
		try (Scanner in = new Scanner(file)) {
			int lineNumber = 0;
			while (in.hasNextLine()) {
				lineNumber++;
				String line = in.nextLine();
				System.out.printf("LINE: %s:%d:%s%n", file.getPath(), lineNumber, line);
				if (line.contains(keyword)) {
					System.out.printf("RESULT: %s:%d:%s%n", file.getPath(), lineNumber, line);
				}
			}
		}
	}
}
