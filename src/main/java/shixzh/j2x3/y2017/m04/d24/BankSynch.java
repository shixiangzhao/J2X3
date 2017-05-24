package shixzh.j2x3.y2017.m04.d24;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankSynch extends Bank {

	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;

	public BankSynch(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}

	public void transfer(int from, int to, double amount) throws InterruptedException {
		bankLock.lock();
		try {
			while (accounts[from] < amount) {
				sufficientFunds.await();
			}
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.println(amount + " from " + from + " to " + to);
			accounts[to] += amount;
			System.out.println("Total Balance: " + getTotalBalance());
			sufficientFunds.signalAll();
		} finally {
			bankLock.unlock();
		}
	}

	public double getTotalBalance() {
		bankLock.lock();
		try {
			double sum = 0;
			for (double a : accounts) {
				sum += a;
			}
			return Math.round(sum * 100) / 100;
		} finally {
			bankLock.unlock();
		}
	}

	public int size() {
		return accounts.length;
	}
}
