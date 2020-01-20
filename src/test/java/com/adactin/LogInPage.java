package com.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LogInPage extends BaseClass{
	public LogInPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy (id="username")
	private WebElement txtUserName;
	
	@FindBy (id="password")
	private WebElement txtPassWord;
	
	@FindBy (id="login")
	private WebElement loginBtnClick;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}

	public WebElement getLoginBtnClick() {
		return loginBtnClick;
	}

}
