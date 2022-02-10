package ch06;

public class MultiTable {
	//매개변수 받을때는 지정해줘야함
	//개수와 자료형 일치해야함
	static void table(int dan) {
		System.out.println("=== Table "+dan+" ===");
		for (int i=1; i<=9; i++) {
			System.out.println(dan+"x"+i+":"+dan*i);
		}
	}
	static void allTable() {
		for (int i=2; i<=9; i++) {
			System.out.println("=== Table "+i+" ===");
			for (int j=1; j<=9; j++) {
				System.out.println(i+"x"+j+":"+i*j);
			}
		}
	}
	//main이 제일 먼저 실행
	public static void main(String[] args) {
		//table() 호출
		table(3);//함수(전달값)
		table(4);
		for (int i=2; i<=9; i++) {
			table(i);
		}
		allTable();
	}
}
