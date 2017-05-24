package shixzh.j2x3.y2017.m04.d24;

public class TransferRunnable implements Runnable {

	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;

	public TransferRunnable(Bank b, int from, double max) {
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}

	public void run() {
		try {
			while (true) {
				int toAccount = (int) (bank.size() * Math.random());
				double amount = Math.round(maxAmount * Math.random() * 100) / 100;
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
