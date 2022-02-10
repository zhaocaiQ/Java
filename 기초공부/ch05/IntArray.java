package ch05;

public class IntArray {
	public static void main(String[] args) {
		//자료형[] 배열참조변수={}//배열
		int[] nums= {10,20,30,40,50};
		//배열참조변수.length : 자료의 개수
		for (int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
		//확장 for문
		//개별값 : 집합
		//nums에 있는 값을 하나씩 꺼냄
		for (int n : nums) {
			System.out.println(n);
		}
	}
}
