package com.programs;

public class StringReverse {
	public static void main(String[] args) {
		String s = "louis";
		String c="";
		for (int i = s.length()-1; i>=0; i--) {
			char ch = s.charAt(i);
			c=c+ch;
		}
		System.out.println(c);
	}

}
