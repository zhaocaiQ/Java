package ch07;

public class Employee {
	private String name;
	private int basic;
	private int bonus;
	private int total;
	private int tax;
	private int salary;
	
	public void input(String name, int basic) {
		this.name = name;
		this.basic = basic;
	}
	public void calc() {
		bonus = basic*3;
		total = basic+bonus;
		//(int) 자료형 변환
		tax = (int)(total*0.033);
		salary = total-tax;
	}
	public void print() {
		System.out.println("Name:"+name);
		System.out.println("Basic:"+basic);
		System.out.println("Bonus:"+bonus);
		System.out.println("Total:"+total);
		System.out.println("Tax:"+tax);
		System.out.println("Salary:"+salary);
	}
	
}
