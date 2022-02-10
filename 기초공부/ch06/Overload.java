package ch06;
//over load
//중복  함수호출
//같은 클래스에서 함수이름이 같은 경우
public class Overload {
	//동일한 이름의 함수를 생성할때
	//함수의 매개변수의 자료형이나, 개수를 다르게 해야함
	static void print(int i) {
		System.out.println("Int:"+i);
	}
	static void print(String s) {
		System.out.println("Str:"+s);
	}
	static void print(double d) {
		System.out.println("Double:"+d);
	}
	public static void main(String[] args) {
		//매개변수가 int면 int매개변수를 갖고있는 함수호출됨
		print(10);
		print(100.5);
		print("Jave");
	}
}
