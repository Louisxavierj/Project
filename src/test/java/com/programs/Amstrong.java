package com.programs;

public class Amstrong {
	public static void main(String[] args) {
		int num=100;
		int n=num;
		int result=0;
		int reminder=0;
		for (int i = 0; i <=num; i++) {
		while (num>0) {
			reminder=num%10;
			result=result*10+reminder;
			num=num/10;
		}
		if (n==result) {
			System.out.println(result);
		}
		}	
	
	
	}
}
