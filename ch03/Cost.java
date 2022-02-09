package ch03;

import java.util.Scanner;

public class Cost {
	public static void main(String[] args) {
		//변수선언하기
		int point_use=0;
		int fee=0;
		int pay=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Name:");
		String name = sc.next();
		System.out.print("Price:");
		int price = sc.nextInt();
		System.out.print("Point:");
		int point = sc.nextInt();
		//가격이 20000이하면 배송비 2000원 붙음
		if (price < 20000) {
			fee = 2000;
		}
		//point가 10000점 이상이면 포인트 사용가능
		if (point >= 10000) {
			point_use = point;
			pay = price + fee - point;
		} else { 
			pay = price + fee;
		}
		System.out.println("Name:"+name);
		System.out.println("Price:"+price);
		System.out.println("Fee"+fee);
		System.out.println("Point:"+point);
		System.out.println("Point_use:"+point_use);
		System.out.println("Pay:"+pay);
		
	}
}
