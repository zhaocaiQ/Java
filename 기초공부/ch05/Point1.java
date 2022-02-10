package ch05;

public class Point1 {
	public static void main(String[] args) {
		String[] name= {"A","B","C","D","E"};
		int[] java= {100,80,70,60,90};
		int[] db= {80,90,95,85,75};
		int[] math= {99,89,79,69,77};
		int[] tot= {0,0,0,0,0};
		double[] avg=new double[5]; //new 메모리할당
		for (int i=0; i<name.length; i++) {
			tot[i] = java[i] + db[i] + math[i]; //총점
			avg[i] = tot[i]/3.0; //평균
		}
		//\t: 탭으로 띄우기
		System.out.println("Name"+"\t"+"Java"+"\t"+"DB"+"\t"+"Math"+"\t"+"Tot"+"\t"+"Avg");
		System.out.println("================================================");
		for (int i=0; i<name.length; i++) {
			//String.format으로 전체 4자리(소수점포함).소수점 첫째자리까지 출력
			System.out.println(name[i]+"\t"+java[i]+"\t"+db[i]+"\t"+math[i]+"\t"+tot[i]+"\t"+String.format("%4.1f", avg[i]));
		}
	}
}
