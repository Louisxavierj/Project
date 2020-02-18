package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoReRunKnow {
	WebDriver driver;
	
	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	@Test
	public void tc1() {
		driver.get("https://www.facebook.com/");
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("louis");
		Assert.assertEquals("louis", userName.getAttribute("value"));
		WebElement passWord = driver.findElement(By.id("pass"));
		passWord.sendKeys("123");
		Assert.assertEquals("123", passWord.getAttribute("value"));
		driver.findElement(By.id("u_0_b")).click();
	}
	@Test(retryAnalyzer=IRetry.class)
	public void tc2() {
		driver.get("https://www.facebook.com/");
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("louis");
		Assert.assertEquals("xavier", userName.getAttribute("value"));
		WebElement passWord = driver.findElement(By.id("pass"));
		passWord.sendKeys("123");
		Assert.assertEquals("123", passWord.getAttribute("value"));
		driver.findElement(By.id("u_0_b")).click();
	}
}
