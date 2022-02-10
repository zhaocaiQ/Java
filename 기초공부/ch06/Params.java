package ch06;

public class Params {
	static int add(int a, int b) {
		return a+b; //호출한 곳으로 리턴
	}
	static int minus(int a, int b) {
		return a-b;
	}
	static int multi(int a, int b) {
		return a*b;
	}
	static int divide(int a, int b) {
		return a/b;
	}
	public static void main(String[] args) {
		int n = add(10, 20);
		System.out.println(n);
		//위에 n의 자료형을 지정해줬기 때문에
		//따로 자료형 지정안하고 사용가능
		n = minus(10,20);
		System.out.println(n);
		n = multi(10,5);
		System.out.println(n);
		n = divide(10,5);
		System.out.println(n);
	}
}
