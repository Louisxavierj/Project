package com.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetry implements IRetryAnalyzer {
	int minCount=0, maxCount=10;
	public boolean retry(ITestResult result) {
		if (minCount<maxCount) {
			minCount++;
			return true;
		}
		return false;
	}
}
