package shixzh.j2x3.y2017.m04.d24;

import java.util.Arrays;

public class BankSynch2 extends Bank {

	private final double[] accounts;

	public BankSynch2(int n, double initialBalance) {
		accounts = new double[n];
		Arrays.fill(accounts, initialBalance);
	}

	public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
		while (accounts[from] < amount) {
			wait();
		}
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.println(amount + " from " + from + " to " + to);
		accounts[to] += amount;
		System.out.println("Total Balance: " + getTotalBalance());
		notifyAll();
	}

	public synchronized double getTotalBalance() {
		double sum = 0;
		for (double a : accounts) {
			sum += a;
		}
		return Math.round(sum * 100) / 100;
	}

	public int size() {
		return accounts.length;
	}
}
