package ch06;

public class Call {
	static void test1(int b) {
		System.out.println(b);
	}
	//num의 주소가 n에 카피됨
	static void test2(int[] n) {
		for (int i=0; i<n.length; i++) {
			System.out.print(n[i]+"\t");
		}
	}
	public static void main(String[] args) {
		int a=10;
		//call by value
		test1(a); //전달값 value
		//num 배열참조변수, 배열의 시작번지값
		int[] num = {10,20,30,40};
		System.out.println(num); //해시코드
		//call by reference
		test2(num); //전달값, 주소값
	}
}
