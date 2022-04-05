package day0404;

public class Ex07CallBy {

	public static void dataIn(Person p) {
		p.name = "강호동";
		p.addr = "부산";
	}
	
	public static void dataOut(Person p) {
		System.out.println("** 값 확인 **");
		System.out.println("이름 : "+p.name+", 주소 : "+p.addr);
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		dataIn(person); //주소가 전달되므로 dataIn에서 입력된 데이타는 person에 저장된다
		dataOut(person);
	}

}
