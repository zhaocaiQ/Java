package ch06;

public class ReturnAbs {
	//리턴타임, 되돌려줄값
	//void: 리턴값이 없을 때
	//리턴값이 있을때는 return값과 자료형이 같아야 함
	static int abs(int num) {
		//3항연산자
		//조건식 ? true : false
		return num > 0 ? num : -num;
	}
	public static void main(String[] args) {
		int a=-15;
		System.out.println(a);
		//abs함수 호출, 15리턴
		System.out.println(abs(a));
		//Math클래스에 이미 만들어져있음
		System.out.println(Math.abs(a));
	}
}
