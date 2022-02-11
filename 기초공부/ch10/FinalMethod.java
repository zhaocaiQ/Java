package ch10;

//클래스이름(FinalMethod) == 파일이름(FinalMethod)
//파일 1개, 클래스 1개가 좋음
//FinalMethod.class, T.class로 따로 저장
//but public 클래스가 두개는 안됨. -> main메소드만 있는 클래스에만 적어줌
//&파일이름과 public클래스 이름이 같아야 함

//T 인스턴스 생성 => FinalMethod 인스턴스 생성
//num = 10       num = 100
class T{
	private int num=10;
	public final void print() {
		System.out.println(num);
	}
}
public class FinalMethod extends T {
	int num=100;
	//override: method 재정의
	//class T에 final로 정의되어 있기때문에 변경불가
//	public void print() {
//		System.out.println(num);
//	}
	public static void main(String[] args) {
		FinalMethod f = new FinalMethod();
		//T클래스에 print메소드 있으므로
		//num 10 출력됨
		f.print();
	}
}
