package ch10;

public class StaticMethod {
	static int a = 10; //프로그램 시작 생성, 종료시 삭제
	int b = 20; //new 생성 후 사용가능
	
	//static메소드도 곧바로 사용가능
	public static void printA() {
		System.out.println(a);
		//System.out.println(b);
		//new로 StaticMethod 인스턴스 생성 후
		//참조변수를 통해 변수b 사용
		StaticMethod s = new StaticMethod();
		System.out.println(s.b);
	}
	
	//new 생성 후 사용가능
	public void printB() {
		System.out.println(a);
		System.out.println(b);
	}
	public static void main(String[] args) {
		printA();
		//printB();
		
		//new로 StaticMethod 인스턴스 생성 후
		//참조변수를 통해 printB()변수 사용가능
		StaticMethod p = new StaticMethod();
		p.printB();
	}
}
