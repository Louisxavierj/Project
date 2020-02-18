package com.windowshandling;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1 {
	
	@Test
	public void windowHandles() throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor j = (JavascriptExecutor)driver;
		WebElement ad = driver.findElement(By.id("div-close"));
		j.executeScript("arguments[0].click()", ad);
		driver.findElement(By.xpath("(//img[@src=\"/images/login.png\"])[1]")).click();
		String parent = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for (String child : allwindows) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
			}
		}
		WebElement userName = driver.findElement(By.id("User_Id"));
		userName.sendKeys("12345");
		WebElement know = driver.findElement(By.xpath("//a[text()='Know more >>']"));
		Actions ac = new Actions(driver);
		ac.contextClick(know);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement tex = driver.findElement(By.xpath("//li[text()='Online Security']"));
		String text = tex.getText();
		System.out.println(text);
		
	}

}
