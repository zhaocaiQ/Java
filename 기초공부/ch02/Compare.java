package ch02;

public class Compare {
	public static void main(String[] args) {
		int a=65;
		char c='A';
		System.out.println(a == c); //비교(문자형은 저장된 숫자코드로 변환되서 비교됨)
		System.out.println(a != c); //not equal
		System.out.println(a = c); //대입
	}
}
