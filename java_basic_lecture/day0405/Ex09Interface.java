package day0405;

//interface는 상수와 추상메서드만 구현이 가능하므로 final과 abstract는 생략하는 경우가 많다.
interface InterA{
	int SPEED = 100; //final 상수임
	public void speedWrite(); //abstract 메서드임
}

class My implements InterA{
	@Override
	public void speedWrite() {
		//SPEED = 120; //상수이므로 값변경 할 수 없음
		System.out.println("나의 스피드는 "+SPEED+"입니다");
	}
	
}

public class Ex09Interface {

	public static void main(String[] args) {

		//InterA a = new InterA(); //멍미?
		
		InterA a = new My();
		a.speedWrite();
	}

}
