package day0407;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Set의 특징은 1.비순차적 2.중복데이타 허용X
public class Ex04Set {

	public static void main(String[] args) {
		//제네릭 <String> : 문자열만 넣을 수 있다.
		Set<String> set = new HashSet<String>();
		set.add("apple");
		set.add("orange");
		set.add("apple");   //중복
		set.add("banana");
		set.add("orange");  //중복
		set.add("kiwi");
//		set.add(100);//String이 아닌경우 오류발생
		
		System.out.println(set.size()); //총갯수-중복갯수 = 4가 출력
		
		System.out.println("출력 방법 1");
		for(String s:set) {
			System.out.println(s);
		}
		
		System.out.println("출력 방법 2");
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		
	}

}
