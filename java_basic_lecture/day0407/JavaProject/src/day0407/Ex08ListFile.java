package day0407;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex08ListFile {
	public static final String FILENAME="/Users/gimzee/Documents/bitjava0314/person.txt";
	List<Person> list;
	Scanner sc;
	
	public Ex08ListFile() {
		// TODO Auto-generated constructor stub
		list=new Vector<Person>();
		sc=new Scanner(System.in);
		
		fileRead();
	}
	
	//처음 시작시 파일읽어서 list 에 데이타 넣기
	public void fileRead()
	{
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			while(true)
			{
				String line=br.readLine();
				if(line==null)
					break;
				String []s=line.split(",");
				Person p=new Person();
				p.setName(s[0]);
				p.setGender(s[1]);
				p.setAddr(s[2]);
				//list에 추가
				list.add(p);
			}
			System.out.println("총 "+list.size()+"개의 데이타 읽어옴!");
			
		} catch (FileNotFoundException e) {
			System.out.println("저장된 데이타 없음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) br.close();
				if(fr!=null) fr.close();
			}catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
	
	public void fileWrite() {
		//FileWriter 생성 후 list의 내용을 저장하기(*컴마로 연결해서 저장)
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			//list의 내용을 파일에 저장하기
			for(Person p:list)
			{
				String s = p.getName()+","+p.getGender()+","+p.getAddr()+"\n";
				fw.write(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fw != null)
				fw.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
	//메뉴숫자 입력후 리턴
	public int getMenu() {
		System.out.println(" ** 메뉴 선택 **");
		System.out.println("1.추가  2.전체출력  3.삭제  5.저장 및 종료");
		int n = Integer.parseInt(sc.nextLine());
		return n;
	}
	
	//이름으로 찾아서 삭제하기
	public void dataDelete() {
		boolean find = false;
		String searchName;
		System.out.println("삭제할 이름을 입력하세요");
		searchName = sc.nextLine();
		
		for(int i=0;i<list.size();i++) {
			Person p = list.get(i); //i번째 Person을 얻는다
			//이름 비교
			if(searchName.equals(p.getName())){
				find = true; //찾았으니 true로 변경
				list.remove(i); //i번 데이타 삭제
				break;
			}
		}
		if(find)
			System.out.println(searchName+"님 데이타 삭제 완료!!");
		else
			System.out.println(searchName+"님은 명단에 없습니다");
	}
	
	//데이타 입력 후 list에 추가하는 메서드
	public void dataAdd() {
		System.out.println("이름");
		String name = sc.nextLine();
		System.out.println("성별");
		String gender = sc.nextLine();
		System.out.println("주소");
		String addr = sc.nextLine();
		
		//Person 객체 생성
		Person p = new Person();
		p.setName(name);
		p.setGender(gender);
		p.setAddr(addr);
		
		//list에 추가
		list.add(p);
		
		System.out.println(list.size()+"번째 데이타가 추가되었습니다");
	}
	
	//전체 출력
	public void dataAllWrite() {
		System.out.println("번호\t이름\t성별\t주소");
		System.out.println("--------------------------------------------------------------");
		int n = 0;
		for(Person p:list) {
			System.out.println(++n+"\t"+p.getName()+"\t"+p.getGender()+"\t"+p.getAddr());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex08ListFile ex = new Ex08ListFile();
		while(true) {
			int n = ex.getMenu();
			switch(n) {
			case 1:
				ex.dataAdd();
				break;
			case 2:
				ex.dataAllWrite();
				break;
			case 3:
				ex.dataDelete();
				break;
			case 5:
				System.out.println("** 저장 후 프로그램을 종료합니다 **");
				ex.fileWrite();
				System.exit(0);
			}
			System.out.println();
		}
	}

}






