package com.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ConfirmationPage extends BaseClass {
	
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//input[@name='order_no']")
	private WebElement booknumber;
	public WebElement getBooknumber() {
		return booknumber;
	}
	

}
