package shixzh.j2x3.y2017.m04.d24;

public abstract class Bank {

	public abstract void transfer(int from, int to, double amount) throws InterruptedException;

	public abstract double getTotalBalance();

	public abstract int size();
}
