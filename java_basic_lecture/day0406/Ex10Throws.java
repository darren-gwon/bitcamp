package day0406;

public class Ex10Throws {

	public static void test1(String su1,String su2) throws NumberFormatException{
		int sum = Integer.parseInt(su1)*Integer.parseInt(su2);
		System.out.println((su1+"과"+su2+"의 곱한값은 "+sum+"입니다"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test1("4","5");
			test1("100","200");
			test1("백","삼백"); //여기서 exception발생하여 catch구현부가 바로 실행되므로 뒷부분은 실행안됨
			test1("2","3");
		}catch(NumberFormatException e) {
			System.out.println("문자가 전달됐어요!!:"+e.getMessage());
		}
	
		System.out.println("** 정상 종료 **");
	}

}
