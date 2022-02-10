package ch05;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		Random rand = new Random();
		//정수 10개를 저장할 수 있는 배열 생성
		int[] nums = new int[10];
		for (int i=0; i < 10; i++) {
			//0~99사이의 숫자 랜덤 1개 뽑음
			//1~100사이의 숫자를 뽑고 싶어 +1해줌
			nums[i] = rand.nextInt(100) + 1;
			System.out.println(nums[i]);
		}
	}
}
