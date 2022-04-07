package day0406;

interface InterA{
	public void draw();
}

//interface가 interface를 상속받을 경우 extends
interface InterB extends InterA{
	public void play();
}

//class에서 InterB를 구현할 경우 InterA가 가진것도 오버라이드해야한다
class My1 implements InterB{

	public void show() {
		System.out.println("My1이 가진 메서");
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("draw");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("play");
	}
	
}

public class Ex01Interface {

	public static void main(String[] args) {

		My1 a1 = new My1();
		a1.draw();
		a1.play();
		a1.show(); //My1만 가지고 있는 메서
		
		InterB a2 = new My1(); //오버라이드된 메서드만 호출 가능
		a2.draw();
		a2.play();
		//a2.show(); //에러
	}

}
