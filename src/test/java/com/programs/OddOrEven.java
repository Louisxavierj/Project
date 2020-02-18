package com.programs;

public class OddOrEven {
	public static void main(String[] args) {
		int oddCount=0;
		int evenCount=0;
		
		for (int i = 0; i <=100; i++) {
			if (i%2==0) {
				evenCount=evenCount+i;
			}else {
				oddCount=oddCount+i;
			}
		}
		System.out.println(oddCount);
		System.out.println(evenCount);
}
}
