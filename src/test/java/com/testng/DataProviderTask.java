package com.testng;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTask {
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
	@Test(dataProvider="search")
	public void tc1(String s1) {
		driver.get("https://www.amazon.in/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(s1, Keys.ENTER);
		List<WebElement> allResult = driver.findElements(By.xpath("//span[contains(text(),'Samsung')]"));
		System.out.println("Result Count " + allResult.size());
		for (WebElement x : allResult) {
			System.out.println(x.getText());
		}
	}
@org.testng.annotations.DataProvider(name="search")	
		public Object[][] data() {
			return new Object [][] {{"samsung mobile"},{"i phone mobile"}, {"Nokia Mobile"}};
		}
}
