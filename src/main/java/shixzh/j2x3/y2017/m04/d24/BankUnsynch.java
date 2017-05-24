package shixzh.j2x3.y2017.m04.d24;

public class BankUnsynch extends Bank {

	private final double[] accounts;

	public BankUnsynch(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
	}

	public void transfer(int from, int to, double amount) throws InterruptedException {
		if (accounts[from] < amount)
			return;
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.println(amount + " from " + from + " to " + to);
		accounts[to] += amount;
		System.out.println("Total Balance: " + getTotalBalance());
	}

	public double getTotalBalance() {
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
