package ch06;
//클래스 = 변수+함수(method)
public class VoidEx {
	//메소드 정의
	//static: 정적, 프로그램시작~끝 메모리에 자리차지
	//void: return을 안해도 되는 함수, 결과값이 없는 함수
	static void hello() {
		System.out.println("hello");
	}
	
	//접근권한 
	public static void main(String[] args) {
		System.out.println("start");
		//위에 정의한 hello()메소드 호출
		hello();
		System.out.println("end");
	}
}
