package ch02;

public class AndOr {
	public static void main(String[] args) {
		int a=27;
		System.out.println(a >= 20 && a < 30); //and연산
		System.out.println(a >= 20 || a < 30); //or 연산
		
		int b=37;
		System.out.println(b >= 20 && b < 30);
		System.out.println(b >= 20 || b < 20);
	}
}
