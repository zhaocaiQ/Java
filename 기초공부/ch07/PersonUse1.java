package ch07;

public class PersonUse1 {
	public static void main(String[] args) {
		//자료형(Person1이라는 클래스가 하나의 자료형이 됨) 변수
		//new 자료형, 클래스를 읽어서 메모리에 로딩
		Person1 p1 = new Person1();
		//변수에 값을 저장
		p1.name = "Kim";
		//p1.age = 20;
		//변수에 직접 입력시 편하지만
		//아래와 같이 오류발생 가능성 있음
		p1.age = 200;
		p1.height = 180;
		System.out.println("Name:"+p1.name);
		System.out.println("Age:"+p1.age);
		System.out.println("Height:"+p1.height);
	}
}
