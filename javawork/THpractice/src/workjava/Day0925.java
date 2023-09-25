package workjava;

import java.util.ArrayList;
import java.util.List;

public class Day0925 {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Cloneee original = new Cloneee("테스트");
		Cloneee copy = original.clone();
		
		copy.setName("테스트123");
		
		System.out.println(original.getName());
		System.out.println(copy.getName());

	}

}
