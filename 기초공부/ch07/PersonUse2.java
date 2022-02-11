package ch07;

public class PersonUse2 {
	public static void main(String[] args) {
		//자료형 참조변수=new 자료형();
		Person2 p1 = new Person2();
		//Person2 변수에 값을 저장하기 위해서는
		//setter함수를 불러와서 값을 전달해 입력해야 함
		p1.setName("kim");
		//p1.setAge(50);
		p1.setAge(500);
		p1.setHeight(180);
		p1.print();
	}
}
