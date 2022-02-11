package ch07;

public class PointUse {
	public static void main(String[] args) {
		//자료형 참조변수=new 자료형()
		//object의 시작주소값을 p가 가리킴
		Point p = new Point();
		//참조변수.변수 or 참조변수.함수
		p.setName("gun");
		p.setJava(100);
		p.setDb(80);
		p.setMath(77);
		p.calc();
		p.print();
	}
}
