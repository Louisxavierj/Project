package com.windowshandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test extends BaseClass{
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Test1 t = new Test1();
		btnClick(t.getClick());
		btnClick(t.getClick());
		
	}

}
