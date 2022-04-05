package day0404;
//생성자(Constructor)
//특징 1. 객체 생성시 자동 호출
//특징 2. 생성자는 overloading이 가능하다
//특징 3. 생성자명은 반드시 클래스명과 동일해야한다
//특징 4. return타입이 없다(형식: 접근지정자 클래스명(인자))
//특징 5. 주로 멤버변수의 초기화를 담당한다
//특징 6. 같은 생성자끼리는 this() 로 호출

class Sawon{
	String name;
	String gender;
	String buseo;
	
	Sawon(){
		this("김길동","남자","홍보부");//3번째 생성자가 호출되어 결과값은 같이나오게 된다
//		System.out.println("기본 생성자");
//		name="김길동";
//		gender="남자";
//		buseo="홍보부";
	}
	
	Sawon(String name){
		this(name,"여자","교육부");
//		this.name = name;
//		gender = "여자";
//		buseo = "교육부";
	}
	
	Sawon(String name, String gender, String buseo){
		this.name = name;
		this.gender = gender;
		this.buseo = buseo;
	}
	
	public void write() {
		System.out.println("이 름 : "+name);
		System.out.println("성 별 : "+gender);
		System.out.println("부 서 : "+buseo);
		System.out.println();
	}
}
public class Ex10Const {

	public static void main(String[] args) {
		Sawon s1 = new Sawon();
		s1.write();
		
		Sawon s2 = new Sawon("이영자");
		s2.write();
		
		Sawon s3 = new Sawon("이미도","여자","인사부");
		s3.write();
	}
	
}
