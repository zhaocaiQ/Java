package ch03;

import java.util.Scanner;

public class Year {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Year:");
		int year = sc.nextInt();
		//윤년이 되는 조건:
		//4의배수이고 100의 배수가 안되지만, 400의 배수는 가능
		if(year%4==0 && year%100 != 0 || year%400 ==0) {
			System.out.println(year+" is a leap year.");
		} else {
			System.out.println(year+" is not a leap year.");
		}
	}
}
