package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
// 1.BrowserLaunch
	public static WebDriver getBrowserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\Projects\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}
// 2. To load Url	 
	public void get(String siteUrl) {
		driver.get(siteUrl);
	}
// 3. GetTitle
	public static String toGetTitle() {
		String title = driver.getTitle();
		return title;
	}
// 4. Quite
	public void toquit() {
		driver.quit();
	}
// 5. Close
	public void close() {
		driver.quit();
	}
// 6.SendKeys
	public void type(WebElement element, String values) {
		element.sendKeys(values);
	}
// 7. Click	
	public static void btnClick(WebElement element) {
		element.click();
	}
// 8. Clear
	public void txtClear(WebElement element) {
		element.clear();
	}
// 9.GetAttribute	
	public String toGetAttribute(WebElement element) {
		String name = element.getAttribute("value");
		return name;
	}
//10.Is displayed
	public boolean elementIsDisplayed(WebElement Element){
		boolean display = Element.isDisplayed();
		return display;
	}
// 11. Is Enabled
	public boolean elementIsEnabled(WebElement Element) {
		boolean enable = Element.isEnabled();
		return enable;
	}
// 12. Is Selected
	public boolean elementIsSelected(WebElement Element){
		boolean selected = Element.isSelected();
		return selected;
	}
// 13.Mouse Over
	public void mouseOver(WebElement Element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(Element).build().perform();
	}
// 14.Drag and Drop
	public static void draganddrop(WebElement sourc, WebElement dest) {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(sourc, dest).build().perform();
	}
// 15. Dobule click
	public  void doubleclick(WebElement Element) {
			Actions ac = new Actions(driver);
			ac.doubleClick(Element).build().perform();
		}
// 16. Right Click
	public void rightclick(WebElement Element) {
			Actions ac = new Actions(driver);
			ac.contextClick(Element).build().perform();
		}
// 17. Select by value
	public  void dropdownVaue(WebElement Element, String value, String option) {
			Select sc = new Select(Element);
			if (option.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (option.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			} else if (option.equalsIgnoreCase("text")) {
				sc.selectByVisibleText(value);
			}
		}
// 18. Simple Alert
		public void simplealert() {
				Alert al = driver.switchTo().alert();
				al.accept();
		}
// 19. Prompt Alert

		public void promptalert() {
				Alert al = driver.switchTo().alert();
				al.sendKeys("Louis");
				al.accept();
		}
// 20. Confirmation Alert
		public  void confirmationalert(){
				Alert al = driver.switchTo().alert();
				al.dismiss();
		}
// 21. Screenshot
			public static File screenshot(String filename) throws IOException {
					TakesScreenshot ts = (TakesScreenshot) driver;
					File sourc = ts.getScreenshotAs(OutputType.FILE);
					File dest = new File(System.getProperty("user.dir")
							+ "\\src\\test\\resource\\com\\selenium\\reports\\ExtentReports\\ScreenShot\\" + filename + ".png");
					FileUtils.copyFile(sourc, dest);
					return dest;
			}
// 22. Navigate to
			public void siteNavigate(String site) {
				driver.navigate().to(site);
			}
// 23. Refresh
			public void navigateCommandReresh() {
				driver.navigate().refresh();
			}
// 24. Back
			public void navigateCommandBack() {
				driver.navigate().back();
			}
// 25. Forward
			public void navigateCommandForward() {
				driver.navigate().forward();
			}
// 26. FrameSwitch
			public void frameSwitching(WebElement element) {
				driver.switchTo().frame(element);
			}
			
// 27. Window Max
			public void windowManage() {
				driver.manage().window().maximize();
			}
// 28. Implicicty wait
			public void waitTime() {
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			}
			
			public void drop(WebElement element, int index) {

				new Select(element).selectByIndex(index);
			}
			
			public String getTextFromtheElement(WebElement element)  {
					String text = element.getText();
					return text;
}}
