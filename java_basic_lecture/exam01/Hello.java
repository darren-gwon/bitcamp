/**
 * 도큐먼트 주석
 * javadoc 명령어로 API 도큐먼트를 생성하는데 사용
 */

// 패키지 선언
package exam01;

/*
클래스 선언
① 상속성(inheritance)
② 다형성(Polymorphism)
③ 캡슐화(encapsulation)
④ 정보은닉(information hiding)
클래스 이름은 소스 파일명과 동일(대소문자도 일치)해야한다. 
*/
public class Hello {
	/* java 명령어로 바이트 코드 파일을 실행하면
	 * 제일 먼저 main()메소드(entry point)를 찾아 블록 내부의 코드를 실행한다.
	 */
	public static void main(String[] args) {
		/* 실행문;
		 * :~ 변수 선언, 값 저장, 메소드 호출에 해당하는 코드
		 */
		System.out.println("출력 내용");
		
		int x;				// 변수 x 선언
		x = 1;				// 변수 x에 1을 저장
		int y = 2;			// 변수 y를 선언하고 2를 저장
		int result = x + y; // 변수 result를 선언하고 변수 x와 y를 더한 값을 저장
		
		// println() 메소드 호출
		System.out.println(result);
		
		// 컴파일러는 세미콜론(;)까지를 하나의 실행문으로 해석
		int a = 10; int b = 20;
		int sum =
				a + b;
		System.out.println(sum);

	}
}
