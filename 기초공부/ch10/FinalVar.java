package ch10;
//Math는 final 클래스이므로 상속금지
//public class FinalVar extends Math 
public class FinalVar {
	//final: 변경불가
	//static: 메모리에 계속 남아있음
	final static int MAX_NUM = 500;
	
	public static void main(String[] args) {
		System.out.println(MAX_NUM);
		System.out.println(Math.PI); //final의 대표예시
		//final변수는 바꾸려고 하면 오류뜸
		//MAX_NUM=200;
	}
}
