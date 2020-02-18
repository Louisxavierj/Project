package com.windowshandling;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Test1 extends BaseClass{
	public Test1() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="u_0_b")
	private WebElement click;
	public WebElement getClick() {
		return click;
	}
	

}
