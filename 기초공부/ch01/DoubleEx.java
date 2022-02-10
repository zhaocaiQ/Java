package ch01;
//정수: 소수점이 없음
//실수: 소수점이 있음
public class DoubleEx {
	public static void main(String[] args) {
		//소수점이 있는 수를 사용할 때는 float보다 double을 사용함
		//실수형 변수, 8바이트
		double a=10.5;
		System.out.println(a);
		//실수형 변수, 4바이트
		float b=10.5F;
		System.out.println(b);
	}
}
