package ch08;

public class Person {
	private String name;
	private int height;
	private int weight;
	
	//
	public Person() {
		this("kim",150,100);
	}
	public Person(String name) {
		this(name,180,50);
	}
	public Person(String name, int height) {
		this(name,height,50);
	}
	public Person(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public void showInfo() {
		System.out.println("=== Info ===");
		System.out.println("Name:"+name);
		System.out.println("Height:"+height);
		System.out.println("Weight:"+weight);
	}
}
