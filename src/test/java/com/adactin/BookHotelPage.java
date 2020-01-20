package com.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass {
	public BookHotelPage () {
		PageFactory.initElements(driver, this);
	}
	@FindBy (id="first_name")
	private WebElement firstName;
	
	@FindBy (id="last_name")
	private WebElement lastName;
	
	@FindBy (id="address")
	private WebElement address;
	
	@FindBy (id="cc_num")
	private WebElement cardNo;
	
	@FindBy (id="cc_type")
	private WebElement cardType;
	
	@FindBy (id="cc_exp_month")
	private WebElement expireDate;
	
	@FindBy (id="cc_exp_year")
	private WebElement cardYear;
	
	@FindBy (id="cc_cvv")
	private WebElement cvvNo;
	
	@FindBy (id="book_now")
	private WebElement btnBook;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardNo() {
		return cardNo;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpireDate() {
		return expireDate;
	}

	public WebElement getCardYear() {
		return cardYear;
	}

	public WebElement getCvvNo() {
		return cvvNo;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}
	
	
}
