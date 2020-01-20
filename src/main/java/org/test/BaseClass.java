package org.test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver getBrowser(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}else {
				throw new Exception("Please enter valid browserName");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	//getUrl
	public static void getUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void waitforElementVisibility(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 60);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) throws Exception {
		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsEnabled(WebElement element) throws Exception {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsSelected(WebElement element) throws Exception {
		try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void sendkeys(WebElement element, String values) throws Exception {
		try {
			waitforElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.clear();
				element.sendKeys(values);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void clickOnWebElement(WebElement element) throws Exception {
		try {
			waitforElementVisibility(element);
			if (elementIsDisplayed(element)) {
				element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void mouseHOverToElement(WebElement element) throws Exception {
		try {
			waitforElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void selectDropDown(WebElement element, String value, String option) throws Exception {
		try {
			//waitforElementVisibility(element);
			Select sc = new Select(element);
			if (option.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (option.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollToWebelement(WebElement element) throws Exception {
		try {
			waitforElementVisibility(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollUsingPixels(int width, int height) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("windows.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollToBottomOfThePage() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("windows.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void dragandDrop(WebElement src, WebElement tar) throws Exception {
		try {
			waitforElementVisibility(src);
			Actions ac = new Actions(driver);
			ac.dragAndDrop(src, tar).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void doubleClickOnTheElement(WebElement element) throws Exception {
		try {
			waitforElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void rightClickOnTheElement(WebElement element) throws Exception {
		try {
			waitforElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void alertAccept() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void alertDismiss() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void alertSendKeys(String value) throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void switchToDefaultContent() throws Exception {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getTextFromtheElement(WebElement element) throws Exception {
		try {
			waitforElementVisibility(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getAttributeFromTheWebelement(WebElement element, String attKey) throws Exception {
		try {
			waitforElementVisibility(element);
			String attribute = element.getAttribute(attKey);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void switchToFrame(WebElement element) throws Exception {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void screenShotontheWebpage(String filename) throws Exception {
		try {
			File des = new File(System.getProperty("user.dir") + "/library/screenshot/" + filename + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, des);
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

//	public static void switchToWindowHandle(String windowTitle) throws Exception {
//		try {
//			String fId = driver.getWindowHandle();
//			Set<String> pId = driver.getWindowHandles();
//			for (String x : pId) {
//				driver.switchTo().window(x);
//				String title = driver.getTitle();
//				if (title.equals(windowTitle)) {
//					driver.switchTo().window(x);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception();
//		}
//	}

	public static void driverClose() throws Exception {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void driverQuit() throws Exception {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getTitle() throws Exception {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getCurrentUrl() throws Exception {
		try {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void navigateToUrl(String url) throws Exception {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public void navigateCommands(String option) throws Exception {
		try {
			if (option.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			} else if (option.equalsIgnoreCase("backward")) {
				driver.navigate().back();
			} else if (option.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static List<String> fetchDynamicContentFromWebTable(String header) throws Exception {
		try {
			List<String> li = new ArrayList<String>();
			WebElement table = driver.findElement(By.tagName("//table"));
			List<WebElement> trow = table.findElements(By.tagName("tr"));
			for (int i = 0; i < trow.size(); i++) {
				List<WebElement> thead = trow.get(i).findElements(By.tagName("th"));
				for (int j = 0; j < thead.size(); j++) {
					String text = thead.get(j).getText();
					if (text.equals(header)) {
						List<WebElement> tdata = trow.get(i).findElements(By.tagName("td"));
						for (int k = 0; k < tdata.size(); k++) {
					String tdataContent = tdata.get(k).getText();
							li.add(tdataContent);
						}
					}
				}
			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}}
		public static void fetchValuesfromDataBaseUsingJDBC(String url, String userName, String passWord, String query,
				String columnName) throws Exception {
			try {
				List<String> li = new ArrayList<String>();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, userName, passWord);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String data = rs.getString(columnName);
					li.add(data);
				}
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception();
			}
		}
	}

	

