package ch01;

public class LongEx {
	//main+Ctrl+space 누르면 자동으로 생성
	
	public static void main(String[] args) {
		//sysout+Ctrl+space System.out.println(); 자동생성
		//정수형 변수, 32bit
		//int a=2147483648; //범위초과면 int형으로 사용불가
		int a=20;
		System.out.println(a);
		//long 64bit
		long b=2147483648L; //long으로 써주면 해결가능
		System.out.println(b);
		//Integer 정수를 처리하는 클래스
		//F3: 세부적인 코드 확인가능
		//변수, 함수이름 대문자 => 상수:바뀌지 않는 값
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.SIZE); //사이즈 32bit
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.SIZE);
	}
}
