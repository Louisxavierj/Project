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

public class TestNg {
	WebDriver driver;
	
	@BeforeClass
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\Projects\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@AfterClass
	public void quite() {
		driver.quit();
	}
	
	@BeforeMethod
	public void startTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@AfterMethod
	public void endTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@Test
	public void tc01() {
		driver.get("https://www.facebook.com/");
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("testNg");
		WebElement passWord = driver.findElement(By.id("pass"));
		passWord.sendKeys("testNg");
		WebElement click = driver.findElement(By.id("u_0_b"));
		click.click();
		
	}

}
