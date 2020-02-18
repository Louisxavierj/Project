package com.testng;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Day2 {
	WebDriver driver;
@BeforeClass
public void browserLaunch() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
}
@BeforeMethod
public void startTime() {
	Date d = new Date();
	System.out.println(d);
}


@Test(groups= {"smoke"})
//@Parameters({"userName" , "passWord"})

public void LogIn01() {
	WebElement userName = driver.findElement(By.id("email"));
	userName.sendKeys("smoke");
	//Assert.assertEquals("louis", userName.getAttribute("value"));
	WebElement passWord = driver.findElement(By.id("pass"));
	passWord.sendKeys("123");
	//Assert.assertEquals("123", passWord.getAttribute("value"));
	driver.findElement(By.id("u_0_b")).click();
}

@Test(groups= {"smoke"})
public void LogIn02() {
	WebElement userName = driver.findElement(By.id("email"));
	userName.sendKeys("louis");
	Assert.assertEquals("louis", userName.getAttribute("value"));
	WebElement passWord = driver.findElement(By.id("pass"));
	passWord.sendKeys("123456");
	Assert.assertEquals("123", passWord.getAttribute("value"));
	driver.findElement(By.id("u_0_b")).click();
}
@Test(groups="123")
public void LogIn03() {
	WebElement userName = driver.findElement(By.id("email"));
	userName.sendKeys("123456");
	Assert.assertEquals("louis", userName.getAttribute("value"));
	WebElement passWord = driver.findElement(By.id("pass"));
	passWord.sendKeys("louis");
	Assert.assertEquals("123", passWord.getAttribute("value"));
	driver.findElement(By.id("u_0_b")).click();
}
@Test(groups="unit")
public void LogIn04() {
	WebElement userName = driver.findElement(By.id("email"));
	userName.sendKeys("louis");
	Assert.assertEquals("louis", userName.getAttribute("value"));
	WebElement passWord = driver.findElement(By.id("pass"));
	passWord.sendKeys("123456");
	Assert.assertEquals("123", passWord.getAttribute("value"));
	driver.findElement(By.id("u_0_b")).click();
}
@Test(groups="adhoc")
public void LogIn05() {
	WebElement userName = driver.findElement(By.id("email"));
	userName.sendKeys("louis");
	Assert.assertEquals("louis", userName.getAttribute("value"));
	WebElement passWord = driver.findElement(By.id("pass"));
	passWord.sendKeys("123456");
	Assert.assertEquals("123", passWord.getAttribute("value"));
	driver.findElement(By.id("u_0_b")).click();
}
}















