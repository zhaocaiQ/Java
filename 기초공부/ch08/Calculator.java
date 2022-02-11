package ch08;

public class Calculator {
	//인스턴스, 멤버변수
	private int left;
	private int right;
	
	//생성자, 리턴타입(void등)없음, 클래스이름과 같음
	public Calculator() {
		System.out.println("기본 생성자 자동호출...");
	} //기본생성자
	
	public Calculator(int left, int right) {
		this.left = left;
		this.right=right;
	}
	
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	
	public void sum() {
		System.out.println(left+right);
	}
	public void avg() {
		System.out.println((left+right)/2);
	}
}
