package ch03;

import java.util.Scanner;

public class Point2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("point:");
		int point = sc.nextInt();
		String grade = "";
		//switch(조건식) 정수 or 스트링
		switch ((int) (point/10)) {
			case 10: //case 10이 없으면 100점 받은 사람이 F학점 받게 됨.
			case 9:
				grade = "A";
				break; //switch구문 벗어남
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			default: //나머지
				grade = "F";
				//맨마지막 조건은 break안써도 됨.
		}
		System.out.println("Point:"+point);
		System.out.println("Grade:"+grade);
	}
}