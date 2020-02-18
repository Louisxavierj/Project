package com.windowshandling;

public class MyException extends Exception {
	@Override
	public String getMessage() {
		return "not found";
	}
	public class Details{
		public void main(String[] args) {
			String env = "down";
			if (env.equals("down")) {
				try {
					throw new MyException();
				} catch (MyException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
