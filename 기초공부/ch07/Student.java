package ch07;

public class Student {
	private String name;
	private double point;
	private int tuition;
	private int scholarship;
	//값을 setter함수 따로 안만들고
	//한번에 입력 받을 수 있음
	public void input(String name, double point, int tuition) {
		//this.변수: 인스턴스 변수
		this.name = name;
		this.point = point;
		this.tuition = tuition;
		if (point>=4.3) {
			scholarship = tuition;
		} else if (point>=4.0) {
			scholarship = 2500000;
		} else if (point>=3.5) {
			scholarship = 1000000;
		}
	}
	//@..:어노테이션, 코드에 대한 도움말
	@Override //﻿object로 이미 설정되어 있는 함수를 제정의하고 싶을 때 사용
	public String toString() {
		String str = "Name:" + name + "\n";
		str += "Point:" + point + "\n";
		str += "Tuition:" + tuition + "\n";
		str += "Scholarship:" + scholarship + "\n";
		return str;
	}
}
