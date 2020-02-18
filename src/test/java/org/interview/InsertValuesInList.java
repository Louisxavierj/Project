package org.interview;

import java.util.ArrayList;
import java.util.List;

public class InsertValuesInList {
	
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		/*for (int i = 0; i <l.size(); i++) {
			System.out.println(l.get(i));
		}*/
		for (Integer x : l) {
			System.out.println(x);
		}
	}

}
