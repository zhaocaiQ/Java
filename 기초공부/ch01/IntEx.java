package ch01;
//주석 comment
//Ctrl+F11 실행 단축키

//public 모든 곳에서 접근 가능
//자바는 모든 프로그램이 클래스 단위로 작성됨
//class: 변수+함수
//{} 중괄호: 코드블록(코드시작과 끝을 나타냄)
public class IntEx {
	//static: 정적, 고정적(메모리에서 계속 자리차지하고 있음)
	//void: 계산만 하는 함수 <-> 계산하고 값 돌려주는 함수도 있음
	//main: 프로그램 시작
	//() 소괄호: argument 인자/파라미터 입력 공간
	//String 문자열
	//[] 대괄호: 배열 array(여러개의 값을 한번에 저장하는 것) 표현
	public static void main(String[] args) {
		//int 정수형, 자료형 변수명
		int a=100; //정수 변수 a에 100입력
		// . : 멤버연산자(System클래스 안에 있는 변수명 나열됨
		System.out.println(a); // a의 값을 출력
		//문자열 변수, "큰따옴표(문자 여러글자 저장 가능), ' 작은따옴표
		String str="hello";
		System.out.println(str);
		//char: 문자 1개만 입력
		char c='A';
		System.out.println(c);
	}
}
