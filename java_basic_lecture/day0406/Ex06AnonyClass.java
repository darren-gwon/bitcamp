package day0406;

abstract class AbstA{
	abstract public void hello();
}

interface InterAnony{
	public void process();
}

public class Ex06AnonyClass {
	AbstA aa = new AbstA() {
		
		@Override
		public void hello() {
			// TODO Auto-generated method stub
			System.out.println("익명 내부클래스에서 구현함");
		}
	};
	
	InterAnony ia = new InterAnony() {
		
		@Override
		public void process() {
			// TODO Auto-generated method stub
			System.out.println("process:익명 내부로 구현함!");
		}
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex06AnonyClass ex = new Ex06AnonyClass();
		ex.aa.hello();
		ex.ia.process();
	}

}
