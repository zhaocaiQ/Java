package ch08;

public class PersonUse {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.showInfo();
		Person p2 = new Person("seo");
		p2.showInfo();
		Person p3 = new Person("kim",160);
		p3.showInfo();
		Person p4 = new Person("park",190,90);
		p4.showInfo();
	}
}
