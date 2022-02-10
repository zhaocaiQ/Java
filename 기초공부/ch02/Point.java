package ch02;

import java.util.Scanner;

public class Point {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name:");
		String name = sc.next();
		System.out.print("Java:");
		int java = sc.nextInt();
		System.out.print("DB:");
		int db = sc.nextInt();
		System.out.print("Math:");
		int math = sc.nextInt();
		int tot = java + db + math;
		//평균 나누면 실수형태로 나올 수 있기 때문에 double로 지정
		double avg = tot/3.0;
		System.out.println("Name:"+name);
		System.out.println("Java:"+java);
		System.out.println("DB:"+db);
		System.out.println("Math:"+math);
		System.out.println("Tot:"+tot);
		System.out.println("Avg:"+String.format("%5.1f", avg));
	}
}
