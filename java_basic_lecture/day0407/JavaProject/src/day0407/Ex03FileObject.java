package day0407;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*
 * 직렬화란(Serialization)?

직렬화란 객체를 데이타 스트림으로 만드는것을 뜻한다

객체를 저장된 데이타를 스트림에 쓰기(write) 위해 연속적인(serial) 데이타로 변환하는것을 말한다

반대로 스트림으로부터 데이타를 읽어서 객체를 만드는것을 역직렬화(deserialization)라고 한다
 * 
 */
public class Ex03FileObject {
	public static final String FILENAME = "/Users/gimzee/Documents/bitjava0314/info.txt";
	
	public static void shopSave() {
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명");
		String sang = sc.nextLine();
		System.out.println("색상");
		String color = sc.nextLine();
		System.out.println("단가");
		int price = Integer.parseInt(sc.nextLine());
		
		//Shop 객체 생성
		Shop shop = new Shop(sang, color, price);
		
		//Object 단위로 저장하는 방법
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(FILENAME);
			oos = new ObjectOutputStream(fos);
			//Object 단위로 저장하기
			oos.writeObject(shop);
			System.out.println("저장완료!!");
		} catch (FileNotFoundException e) {
			System.out.println("파일 없음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) oos.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void shopRead() {
		System.out.println("파일에서 읽은 shop 데이타 출력");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(FILENAME);
			ois = new ObjectInputStream(fis);
			//파일에서 shop단위로 읽기
			Shop shop = (Shop)ois.readObject();
			System.out.println("상품명:"+shop.getSang());
			System.out.println("색상:"+shop.getColor());
			System.out.println("단가:"+shop.getPrice());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) ois.close();
				if(fis != null) fis.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shopSave();
		shopRead();
	}

}
