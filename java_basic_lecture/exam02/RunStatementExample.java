package exam02;

public class RunStatementExample {
	public static void main(String[] args) {
		int x = 20; 
		int y = 30;
		int result = 0;
		
		result = x + y;
		System.out.println("x + y = " + result);

		final double PI = 3.14;
		int radius = 10;
		double area = radius * radius * PI;
		
		System.out.printf("반지름이 %d인 원의 넓이는 %f입니다.", radius, area);
		System.out.println();
		
		int score = 65;
		if(score >= 60)
			System.out.println("합격");
		else
			System.out.println("불합격");
	}
}