package ch04;

public class Dowhile {
	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println(i);
			i++;
		} while(i>10);
		while(i>10) {
			System.out.println(i++);
		}
	}
}
