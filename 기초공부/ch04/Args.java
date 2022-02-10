package ch04;

public class Args {
	//main시작
	//[]대괄호: 자료형[]=> 배열참조변수
	public static void main(String[] args) {
		//length 데이터의 개수
		System.out.println(args.length);
		//args변수 길이가 0이기 때문에
		//for문 실행안됨
		for(int i=0; i<args.length; i++) {
			//배열참조변수[인덱스]
			System.out.println(args[i]);
		}
		
	}
}
