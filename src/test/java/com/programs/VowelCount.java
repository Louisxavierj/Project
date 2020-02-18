package com.programs;

public class VowelCount {
	public static void main(String[] args) {
		String s= "welcome";
		String vow="";
		int vCount=0;
		for (int i = 0; i <s.length(); i++) {
			char ch = s.charAt(i);
			if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='o') {
				vow=vow+ch;
				vCount++;
			}
		}
		System.out.println(vow);
		System.out.println(vCount);
	}
}
