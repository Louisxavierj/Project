package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExcecution {
	WebDriver driver;
	
	@BeforeClass
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Test
	public void tc01() {
	driver.get("https://www.google.com/");
	System.out.println(Thread.currentThread().getId());
	}
	@Test
	public void tc02() {
		driver.get("https://www.facebook.com/");
		System.out.println(Thread.currentThread().getId());
		}
	@Test
	public void tc3() {
		driver.get("https://adactin.com/HotelApp/index.php");
		System.out.println(Thread.currentThread().getId());
		}
	@Test
	public void tc04() {
		driver.get("https://www.amazon.in/");
		System.out.println(Thread.currentThread().getId());
		}
	@Test
	public void tc05() {
		driver.get("https://www.flipkart.com/");
		System.out.println(Thread.currentThread().getId());
		}
	@Test
	public void tc06() {
		driver.get("https://www.snapdeal.com/");
		System.out.println(Thread.currentThread().getId());
		}
}
