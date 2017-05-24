package shixzh.j2x3.y2017.m04.d21;

public class CloneTest {
	public static void main(String[] args) {
		try {
			// 深度克隆
			Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
			Person p2 = CloneUtil.clone(p1); // 深度克隆
			p2.setAge(55);
			p2.getCar().setBrand("BYD");
			// 修改克隆的Person对象p2关联的汽车对象的品牌属性
			// 原来的Person对象p1关联的汽车不会受到任何影响，还是奔驰
			// 因为在克隆Person对象时其关联的汽车对象也被克隆了
			System.out.println(p1);

			Person2 p3 = new Person2("Hao LUO", 33, new Car("Benz", 300));
			Person2 p4 = p3.clone();
			p4.setAge(55);
			p4.getCar().setBrand("BYD");
			System.out.println(p3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
