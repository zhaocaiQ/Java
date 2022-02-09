package ch02;

import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		//키보드입력기능
		Scanner sc = new Scanner(System.in);
		System.out.print("r:");
		//소수점까지 입력받기
		double r = sc.nextDouble();
		//2*원주율*반지름
		//Math.PI: 원주율
		double length = 2 * Math.PI * r; //둘레
		//원주율*반지름제곱(r*r)
		double area = Math.PI * r * r; //넓이
		System.out.println("반지름:"+r);
		//소수점 자리수 지정하여 출력
		//String("출력형식", 값)
		System.out.println("둘레:"+String.format("%.2f", length));
		System.out.println("넓이:"+String.format("%.2f", area));
	}
}
