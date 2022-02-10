package ch04;

public class ForEx {
	public static void main(String[] args) {
		int num = 10;
		//for조건이 true일동안 반복
		//for(초기식; 조건식; 증가감소식)
		//변수 i 지정
		//i가 num 작거나 같아야 함
		//위의 조건 만족하면 i += 1해줌
		for (int i = 1; i <= num; i++) {
			System.out.println(i);
		}
	}
}
