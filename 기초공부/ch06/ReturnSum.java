package ch06;

public class ReturnSum {
	static int sum(int a) {
		int result = 0;
		for (int i=1; i<=a; i++) {
			result += i;
		}
		return result; //결과값 리턴
	}
	public static void main(String[] args) {
		//함수 return값을 변수에 지정 가능
		int n = sum(50);
		System.out.println(n);
	}
}
