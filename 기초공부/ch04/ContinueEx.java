package ch04;

public class ContinueEx {
	public static void main(String[] args) {
		for (int i=1; i <= 20; i++) {
			if(i%5 == 0) continue; //다음단계로 넘어감
			System.out.println(i);
		}
	}
}
