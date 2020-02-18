package com.adactin;


import java.io.IOException;

import com.base.BaseClass;
import com.base.ExcelIntegration;

public class AdactinMainProgram extends ExcelIntegration {
	public static void main(String[] args) throws IOException {
		BaseClass bc = new BaseClass();
		bc.getBrowserLaunch();
		bc.get("https://adactin.com/HotelApp/");
		LogInPage logInPage = new LogInPage();
		SearchPage sr = new SearchPage();
		SelectHotelPage shp = new SelectHotelPage();
		BookHotelPage bhp = new BookHotelPage();
		ConfirmationPage cp = new ConfirmationPage();
		bc.windowManage();
		bc.waitTime();
		bc.type(logInPage.getTxtUserName(), getData(0, 0));
		bc.type(logInPage.getTxtPassWord(), getData(1, 0));
		bc.btnClick(logInPage.getLoginBtnClick());
		bc.drop(sr.getLocation(), 3);
		bc.drop(sr.getHotel(), 2);
		bc.drop(sr.getRoom(), 4);
		bc.drop(sr.getRoomNo(), 2);
		bc.type(sr.getInDate(), getData(2, 0));
		bc.type(sr.getOutDate(), getData(3, 0));
		bc.drop(sr.getAdultRoom(), 2);
		bc.drop(sr.getChildRoom(), 2);
		bc.btnClick(sr.getBtnSubmit());
		bc.btnClick(shp.getRadioBtn());
		bc.btnClick(shp.getContinueBtn());
		bc.type(bhp.getFirstName(), getData(4, 0));
		bc.type(bhp.getLastName(), getData(5, 0));
		bc.type(bhp.getAddress(), getData(6, 0));
		bc.type(bhp.getCardNo(), getData(7, 0));
		bc.drop(bhp.getCardType(), 2);
		bc.drop(bhp.getExpireDate(), 2);
		bc.drop(bhp.getCardYear(), 11);
		bc.type(bhp.getCvvNo(), getData(8, 0));
		bc.btnClick(bhp.getBtnBook());
		System.out.println(bc.toGetAttribute(cp.getBooknumber()));

	}
}
