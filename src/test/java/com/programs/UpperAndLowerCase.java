package com.programs;

public class UpperAndLowerCase {
	public static void main(String[] args) {
		String s = "LouisXavier@123";
		int uCaseCount=0;
		int lCaseCount=0;
		int sCharCount=0;
		int nCount=0;
		String upperCase="";
		String lowerCase="";
		String sChar="";
		String number="";
		for (int i = 0; i <s.length(); i++) {
			char ii = s.charAt(i);
			if (Character.isUpperCase(ii)) {
				upperCase= upperCase+ii;
				uCaseCount++;
			}else if (Character.isLowerCase(ii)) {
				lowerCase= lowerCase+ii;
				lCaseCount++;
			} else if (Character.isAlphabetic(ii)) {
				sChar = sChar+ii;
				sCharCount++;
			}else {
				number=number+i;
				nCount++;
			}
			
		}
		System.out.println("UperCaseCount "+uCaseCount);
		System.out.println("UperCase " + upperCase);
		System.out.println("LowerCase Count " + lCaseCount);
		
	}

}
