package com.programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CharCount {
public static void main(String[] args) {
	String s = "louis louis louis xavier done";
	//char[] c = s.toCharArray();
	
	String[] c = s.split(" ");
	LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
	for (String d : c) {
		if (map.containsKey(d)) {
			Integer in = map.get(d);
			map.put(d, in+1);
		}else {
			map.put(d, 1);
		}
	}
System.out.println(map);	
}
}
