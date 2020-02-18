package com.testng;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider {
	WebDriver driver;
	
	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@BeforeMethod
	public void startTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@AfterClass
	public void quite() {
		driver.quit();
	}
	@AfterMethod
	public void endTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@Test(dataProvider="login")
	public void tc1(String s1, String s2) {
		driver.get("https://www.facebook.com/");
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys(s1);
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(s2);
		
	}
@org.testng.annotations.DataProvider(name="login")	
		public Object[][] data() {
			return new Object [][] {{"louis","123"},{"xavier","123"}};
		
		}
	}
	