package ch05;

public class Array2D {
	public static void main(String[] args) {
		//[] 배열첨자 1개: 1차원배열, 2개: 2차원배열
		int[][] nums = {{10,20,30},{40,50,60},{70,80,90}};
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums[i].length; j++) {
				System.out.println(nums[i][j]);
			}
		}
	}
}
