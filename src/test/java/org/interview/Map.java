package org.interview;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Map {
	public static void main(String[] args) {
		java.util.Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(10, "louis");
		m.put(20, "xavier");
		m.put(30, "john");
		Set<Entry<Integer, String>> all = m.entrySet();
		System.out.println(all);
		for (Entry<Integer, String> x : all) {
			System.out.println(x.getKey());
			System.out.println(x.getValue());
		}
		
		
	}

}
