package bit701.day0914;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex8_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Set<String> set=new HashSet<String>();
		Set<String> set=new TreeSet<String>(); //순차적으로 나온다
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("yellow");
		set.add("green");
		set.add("red");
		set.add("green");
		set.add("red");
		System.out.println(set.size()); //4
		
		for(String s:set) {
			System.out.println(s);
		}
	}

}
