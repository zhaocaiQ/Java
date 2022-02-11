package ch07;

public class Point {
	private String name;
	private int java;
	private int db;
	private int math;
	private int tot;
	private double avg;
	private String grade;
	
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		if (java < 0 || java > 100) {
			System.out.println("error");
		} else {
			this.java = java;
		}
	}
	public int getDb() {
		return db;
	}
	public void setDb(int db) {
		if (db < 0 || db > 100) {
			System.out.println("error");
		} else {
			this.db = db;
		}
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		if (math < 0 || math > 100) {
			System.out.println("error");
		} else {
			this.math = math;
		}
	}
	public void calc() {
		tot = java+db+math;
		avg = tot/3.0;
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else { 
			grade = "F";
		}
	}
	public void print() {
		System.out.println("Name:"+name);
		System.out.println("Java:"+java);
		System.out.println("DB:"+db);
		System.out.println("Math:"+math);
		System.out.println("Tot:"+tot);
		System.out.println("Avg:"+String.format("%4.1f", avg));
		System.out.println("Grade:"+grade);
	}
}
