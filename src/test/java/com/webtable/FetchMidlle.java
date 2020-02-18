package com.webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchMidlle {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-table/");
		//to get the middle row middle element
		List<WebElement> tRow = driver.findElements(By.tagName("tr"));
			WebElement row = tRow.get(tRow.size()/2);
			List<WebElement> tdata = row.findElements(By.tagName("td"));
				WebElement data = tdata.get(tdata.size()/2);
				String text = data.getText();
				System.out.print(text+" ");

}
}

