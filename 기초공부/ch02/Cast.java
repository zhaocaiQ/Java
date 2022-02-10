package ch02;

public class Cast {
	public static void main(String[] args) {
		double a = 10.5;
		//int 4바이트, double 8바이트로 =연산자로 변환 못함.
		//실수 -> 정수로 변환
		//(int) a: (변환할 자료형) 변수
		int b = (int) a;
		System.out.println(b);
		
		//정수 -> 실수는 =연산자로 변환가능
		int c=10;
		//정수변수 c가 자동으로 double로 변환되어 처리
		double d=c; //좌변8바이트, 우변 4바이트
		System.out.println(d);
	}
}
