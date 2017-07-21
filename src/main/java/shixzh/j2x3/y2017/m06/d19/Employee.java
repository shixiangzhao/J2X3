package shixzh.j2x3.y2017.m06.d19;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee {

	public static final long RECORD_SIZE = 3;
    public static final int NAME_SIZE = 10;
    private String name;
	private double salary;
	private Date hireDate;

	public Employee() {
	}

	public Employee(String name, double salary, int year, int mouth, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, mouth - 1, day);
		this.hireDate = calendar.getTime();
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	@Override
	public boolean equals(Object otherObject) {

		if (this == otherObject) {
			return true;
		}
		if (otherObject == null) {
			return false;
		}
		if (this.getClass() != otherObject.getClass()) {
			return false;
		}
		Employee other = (Employee) otherObject;
		return Objects.equals(this.name, other.name) && this.salary == other.salary
				&& Objects.equals(this.hireDate, other.hireDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, salary, hireDate);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDate=" + hireDate + "]";
	}
}
