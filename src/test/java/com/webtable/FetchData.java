package com.webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchData {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-table/");
		List<WebElement> tRow = driver.findElements(By.tagName("tr"));
		for (int i = 0; i <tRow.size(); i++) {
			WebElement row = tRow.get(i);
			List<WebElement> tdata = row.findElements(By.tagName("td"));
			for (int j = 0; j <tdata.size(); j++) {
				WebElement head = tdata.get(j);
				String text = head.getText();
				System.out.println(text);
			}
		}
	}

}
