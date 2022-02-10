package ch05;

public class Stringformat {
	public static void main(String[] args) {
		String name="김철수";
		int age=20;
		double height=170.8;
		// %s: 스트링형식, %d: 정수형식, %f: 실수형식
		//앞의 형식의 개수와 값의 개수가 동일해야함
		//%숫자형식: 숫자를 입력하면 자리수 지정됨 ex)%10s: 10자리 스트링형식
		System.out.println(String.format("%s, %d, %f", name, age, height));
	}
}
