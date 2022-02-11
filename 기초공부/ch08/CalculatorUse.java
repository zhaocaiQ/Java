package ch08;

public class CalculatorUse {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setLeft(10);
		c.setRight(20);
		c.sum();
		c.avg();
		Calculator c1 = new Calculator(10,20);
		c1.sum();
		c1.avg();
	}
}
