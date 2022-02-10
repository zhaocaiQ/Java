package ch04;

public class WhileEx {
	public static void main(String[] args) {
		int i=1;
		//while(조건식) 조건식이 true이면 계속반복
		//멈출려면 break사용 break없으면 무한루트
		while(true) {
			System.out.println(i++);
			if(i>10) break;
		}
		//위와 같은식인데
		//if조건식을 while조건식에 적용
		i=1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
	}
}
