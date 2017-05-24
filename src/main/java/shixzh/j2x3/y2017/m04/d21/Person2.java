package shixzh.j2x3.y2017.m04.d21;

public class Person2 implements Cloneable {

	private String name; // 姓名
	private int age; // 年龄
	private Car car; // 座驾

	public Person2(String name, int age, Car car) {
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Person2 clone() {
		Person2 s = null;
		try {
			s = (Person2) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

}
