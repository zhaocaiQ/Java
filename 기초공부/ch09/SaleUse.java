package ch09;

public class SaleUse {
	public static void main(String[] args) {
		Sale s = new Sale();
		s.input(1, "TV", 100, 10);
		s.calc();
		s.print();
	}
}
