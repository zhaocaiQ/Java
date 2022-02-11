package ch07;

public class StudentUse {
	public static void main(String[] args) {
		Student s = new Student();
		s.input("gun", 4.3, 5000000);
		//s.toString()이 출력되게 됨
		//Student클래스에 toString을 생성하지 않으면
		//s에 대한 위치정보가 나옴
		System.out.println(s);
	}
}
