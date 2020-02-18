package com.adactinjunit;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.adactin.BookHotelPage;
import com.adactin.ConfirmationPage;
import com.adactin.LogInPage;
import com.adactin.SearchPage;
import com.adactin.SelectHotelPage;
import com.base.BaseClass;
import com.base.ExcelIntegration;

public class Adactin extends BaseClass {
	BaseClass base = new BaseClass();
	ExcelIntegration ex = new ExcelIntegration();
	
	@BeforeClass
	public static void browserLaunch() {
		BaseClass.getBrowserLaunch();
	}
	@Before
	public void startTime() {
		Date d = new Date();
		System.out.println("Start Time "+ d);
	}
	@After
	public void endTime() {
		Date d = new Date();
		System.out.println("End Time "+" " + d);
	}
	
	/*@AfterClass
	public static void quit() {
		driver.quit();
	}*/
	
	@Test
	public void tc1() throws IOException {
		base.get("https://adactin.com/HotelApp/index.php");
		LogInPage lp = new LogInPage();
		base.type(lp.getTxtUserName(), ex.getData(0,0));
		base.type(lp.getTxtPassWord(), ex.getData(1,0));
		base.btnClick(lp.getLoginBtnClick());
	}
	
	@Test
	public void tc2() throws IOException {
		SearchPage sr = new SearchPage();
		base.drop(sr.getLocation(),3);
		base.drop(sr.getHotel(), 2);
		base.drop(sr.getRoom(), 4);
		base.drop(sr.getRoomNo(), 2);
		base.type(sr.getInDate(), ex.getData(2, 0));
		base.type(sr.getOutDate(), ex.getData(3, 0));
		base.drop(sr.getAdultRoom(), 2);
		base.drop(sr.getChildRoom(), 2);
		base.btnClick(sr.getBtnSubmit());
		System.out.println("end");
	}
	@Test
	public void tc3() {
		System.out.println("start");
		SelectHotelPage sp = new SelectHotelPage();
		base.btnClick(sp.getRadioBtn());
		base.btnClick(sp.getContinueBtn());
	}
	@Test
	public void tc4() throws IOException {
		BookHotelPage bhp = new BookHotelPage();
		base.type(bhp.getFirstName(), ex.getData(4, 0));
		base.type(bhp.getLastName(), ex.getData(5, 0));
		base.type(bhp.getAddress(), ex.getData(6, 0));
		base.type(bhp.getCardNo(), ex.getData(7, 0));
		base.drop(bhp.getCardType(), 2);
		base.drop(bhp.getExpireDate(), 2);
		base.drop(bhp.getCardYear(), 11);
		base.type(bhp.getCvvNo(), ex.getData(8, 0));
		base.btnClick(bhp.getBtnBook());
	}
	@Test
	public void tc5() {
		ConfirmationPage cp = new ConfirmationPage();
		System.out.println(base.toGetAttribute(cp.getBooknumber()));
	}
	
	
	
	
	
	

}
