package day0406;

//Member 내부 클래스
class Outer{
	int a = 10;
	static int b = 20;
	
	//내부 클래스
	class Inner{
		int c = 30;
		//static int d = 40; //member 내부클래스에서 static 변수 선언불가
		
		public void disp() {
			System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
		}
	}
	
	public void outerDisp() {
		//내부클래스 선언
		Inner in = new Inner();
		//내부클래스 메서드 호출
		in.disp();
	}
}
public class Ex04InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer out = new Outer();
		out.outerDisp();
		System.out.println();
		//외부 클래스의 메서드를 거치지않고 바로 내부클래스의 메서드를 호출하고자 할 경우
		Outer.Inner inner = new Outer().new Inner();
		inner.disp();
		
	}

}
