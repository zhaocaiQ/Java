package ch04;

public class MultiTable2 {
	public static void main(String[] args) {
		int num = 9;
		for (int i=2; i <= num; i++) {
			for (int j=1; j <= num; j++) {
				System.out.println(i + "x" + j + "=" + i*j);
			}
		}
	}
}

