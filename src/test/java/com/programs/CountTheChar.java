package com.programs;

import java.util.LinkedHashMap;

public class CountTheChar {
	public static void main(String[] args) {
		String s = "louisxavier";
		char[] ch = s.toCharArray();
		LinkedHashMap<Character, Integer> mp = new LinkedHashMap<>();
		for (char c : ch) {
			if (mp.containsKey(c)) {
				Integer x = mp.get(c);
				mp.put(c, x++);
			}else {
				mp.put(c, 1);
			}
		}
		System.out.println(mp);
	}

}
