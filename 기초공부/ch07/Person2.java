package ch07;

public class Person2 {
	//private: 외부에서 접근 불가
	//같은 클래스 안에서만 사용가능: 같은 패키지내에서도 사용불가
	//인스턴스 변수
	private String name;
	private int age;
	private double height;
	
	//지역변수, 매개변수
	//setter 값을 저장하는 함수
	public void setName(String name) {
		//매개변수와 인스턴스 변수를 구분하기위해 this.name으로 입력
        //this.name == private String name
        //name == setName의 매개변수 String name
		this.name = name;
	}
	//getter 값을 읽는 함수
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	//나이에 조건 설정하여 오류발생 없애기
	public void setAge(int age) {
		//나이가 0미만이거나 150이상이면 오류뜨게 만듦
		if (age < 0 || age > 150) {
			System.out.println("error!");
		} else {
			this.age = age;
		}
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	//출력기능 함수생성
	public void print() {
		System.out.println("Name:"+name+ " Age:"+age+ " Height:"+height);
	}
}
