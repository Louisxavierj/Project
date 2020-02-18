package com.programs;

public class Palindrome {
	public static void main(String[] args) {
		int num = 120;
		int n=num;
		int reminder=0;
		int result=0;
		
		while (num>0) {
			reminder=num%10;
			result=result*10+reminder;
			num=num/10;
		}
		if (n==result) {
			System.out.println("palindrom");
		}else {
			System.out.println("not");
		}
		
	}

}
