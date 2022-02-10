package ch02;

public class Condition {
	public static void main(String[] args) {
		int num = -5;
		//3항연산자
		// 조건식 ? true : false
		System.out.println(num > 0 ? num : -num);
		
		//위의 한줄을 조건문 표현
		if (num > 0) {
			System.out.println(num);
		}
		else {
			System.out.println(-num);
		}
	}
}
