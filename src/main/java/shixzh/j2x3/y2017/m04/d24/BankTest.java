package shixzh.j2x3.y2017.m04.d24;

public class BankTest {

	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		//Bank b = new BankUnsynch(NACCOUNTS, INITIAL_BALANCE);
		//Bank b = new BankSynch(NACCOUNTS, INITIAL_BALANCE);
		Bank b = new BankSynch2(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}