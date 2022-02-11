package ch10;

public class StaticVar {
	static int a = 10; //프로그램 시작 생성, 종료시 삭제
	int b = 20; //new 생성 후 사용가능
	
	public static void main(String[] args) {
		System.out.println(a);
		//System.out.println(b);
		//new로 StaticVar 인스턴스 생성 후
		//참조변수를 통해 변수b 사용
		StaticVar s = new StaticVar();
		System.out.println(s.b);
	}
}
