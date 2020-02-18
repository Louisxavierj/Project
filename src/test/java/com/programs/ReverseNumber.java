package com.programs;

public class ReverseNumber {
	public static void main(String[] args) {
		int num = 123;
		int n=num;
		int result=0;
		int reminder=0;
		while (num>0) {
			reminder = num%10;
			result=((result*10)+ reminder);
			num=num/10;
		}
		System.out.println("revers"+n+"is" + result);
		
		
	}

}
