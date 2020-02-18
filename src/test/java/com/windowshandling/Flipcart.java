package com.windowshandling;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipcart {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("samsung mobiles", Keys.ENTER);
		
		List<WebElement> allSamsungResult = driver.findElements(By.xpath("//div[contains(text(),'Samsung ')]"));
		System.out.println("All Result" + allSamsungResult.size());

		List<String> text = new ArrayList<String>();
		for (int i = 1; i <allSamsungResult.size(); i++) {
			String AllresultText = allSamsungResult.get(i).getText();
			System.out.println(AllresultText);
		}
		
		allSamsungResult.get(4).click();

		String parentId = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		Actions ac = new Actions(driver);
		for (String child : allwindow) {
			if (!parentId.equals(child)) {
				driver.switchTo().window(child);
			}
		}
		ac.moveToElement(driver.findElement(By.xpath("//span[text()='Home & Furniture']")));
		driver.findElement(By.xpath("//a[text()='Wall Shelves']")).click();
	}

}
