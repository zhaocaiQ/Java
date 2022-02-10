package ch02;

public class Arithmetic {
	public static void main(String[] args) {
		double a=10;
		double b=7;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b); //곱셈
		System.out.println(a/b); //나눗셈(몫)
		//String(클래스).format(함수)(출력형식, 값)
		//%.1f %: 출력할위치 .1: 소수첫째자리 f: 실수형
		//부동소수점(소수점이 고정이아니라 왔다갔다함)
		System.out.println(String.format("%.1f", a/b));
		System.out.println(String.format("%.2f", a/b));
		//%전체자리수(소수점포함).소수이하자리수
		//%5.2: 5칸.소수둘째자리
		System.out.println(String.format("%5.2f", a/b));
		System.out.println(a%b); //나눗셈(나머지)/정수형
	}
}
