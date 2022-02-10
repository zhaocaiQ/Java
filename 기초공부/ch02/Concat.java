package ch02;

public class Concat {
	public static void main(String[] args) {
		//문자+문자 연산
		String a="Hello "+"java"+" hi"+" there";
		System.out.println(a);
		//문자+숫자 연산
		//숫자->문자로변환되어 합쳐짐
		//"point:"+"100"
		String b="point:"+100;
		System.out.println(b);
	}
}
