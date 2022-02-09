package ch01;

//자주 사용되는 클래스: String, System, Integer은 바로 사용가능
//그외엔 클래스 호출해야함
import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		//Scanner드래그 후 Ctrl+Shift+O입력하면 import할 수 있는 것 뜸
		//Scanner: 키보드 입력 기능 제공
		//new: 클래스(변수+함수) 내용을 메모리에 적재하기 위해 쓰임
		//System.in: 입력장치(키보드)
		Scanner sc = new Scanner(System.in);
		//println: print+line 출력+줄바꿈
		//print: 출력만(줄바꿈x)
		System.out.print("Name:");
		//사용자가 입력한 것을 sc.next()로 받음
		//sc: 참조변수.함수()
		String name = sc.next(); //키보드로 문자열 입력
		System.out.println("Name:"+name);
		System.out.print("Age:");
		int age = sc.nextInt(); //숫자입력
		System.out.println("Age:"+age);
	}
}
