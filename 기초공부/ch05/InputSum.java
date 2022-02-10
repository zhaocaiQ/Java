package ch05;

import java.util.Scanner;

public class InputSum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//정수 5개 배열 생성
		int[] nums = new int[5];
		int sum =0; //합계저장변수
		for (int i=0; i<nums.length; i++) {
			//배열 수만큼 숫자입력받기
			System.out.print("Number"+(i+1)+":");
			//정수로 입력받은 수 배열에 저장
			nums[i] = sc.nextInt();
			//합산
			sum += nums[i];
		}
		System.out.println("Sum:"+sum);
	}
}
