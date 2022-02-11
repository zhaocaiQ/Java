package ch09;
//Area클래스 상속받기
//class 클래스명 extends 상속받을클래스이름
public class Volume extends Area {
	private int height;
	//매개변수가 없는 생성자, 기본생성자
	public Volume() {
		//기본값 입력해 둘 수 있음
//		super(10, 20);
//		this.height = 30;
		
		//Area클래스에서 protected로 설정했기때문에
		//변수명으로 설정 가능
		width = 10;
		length = 30;
		height = 20;
	}
	
	public Volume(int width, int length, int height) {
		//super(): 상위클래스의 생성자
		//Area클래스에 입력받은 값 넘길때 사용
//		super(width, length);
		this.width = width;
		this.length = length;
		this.height = height;
	}
	public int getVolume() {
		return getArea() * height;
	}
}
