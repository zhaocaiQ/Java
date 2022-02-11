package ch09;

public class Area {
	//인스턴스,멤버변수, property
	//private int width;
	//private int length;
	
	//하위클래스에서 접근 가능
	protected int width;
	protected int length;
	
	
	//생성자, 클래스이름과 동일, 자동호출
	//값이 없을수도
	public Area() {}
	//있을수도 있음
	public Area(int width, int length) {
		//this.변수:인스턴스변수
		this.width = width;
		this.length = length;
	}
	public int getArea() {
		return width*length;
	}
}
