package day0405;

class Fruit{
	private int danga;
	
	public Fruit() {
		danga = 1000;
	}
	
	Fruit(int danga){
		
		this.danga = danga;
	}
	
	public int getDanga() {
		return danga;
	}
}
//////////////////////////////////////////////////////
class Orange extends Fruit{
	private String name;
	
	public Orange() {
		name = "오랜지";
	}
	
	Orange(String name){
		this.name = name;
	}
	
	Orange(String name, int danga){
		super(danga);
		this.name = name;
	}
	
	public void write() {
		//오버라이딩된 danga 메서드가 없으므로, super.getDanga(), this.getDanga 둘다 사용가능하다
		System.out.println("과일명:"+name+",단가:"+this.getDanga());
	}
}

public class Ex05Inheri {

	public static void main(String[] args) {
		
		Orange []or = new Orange[3];
		or[0] = new Orange();
		or[1] = new Orange("키위");
		or[2] = new Orange("딸기",3000);
		
		for(Orange o:or)
			o.write();
		
		System.out.println();
		
		for(int i = 0;i<or.length;i++) {
			or[i].write();
		}
		
	}
}
