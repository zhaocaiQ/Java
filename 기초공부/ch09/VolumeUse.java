package ch09;

public class VolumeUse {
	public static void main(String[] args) {
		//Area생성, Volume생성
		//기본생성자 호출됨
		Volume v1 = new Volume();
		//값이 들어간게 없으므로 값 0으로 출력
		System.out.println(v1.getVolume());
		//값 3개입력
		Volume v2 = new Volume(10,20,30);
		System.out.println(v2.getVolume());
	}
}
