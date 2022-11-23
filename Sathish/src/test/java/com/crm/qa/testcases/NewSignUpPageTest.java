package com.crm.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.listeners.FailedScreenShots;
import com.crm.qa.base.Base;
import com.crm.qa.pages.NewSignUpPage;
import com.crm.qa.util.TestUtil;

@Listeners(FailedScreenShots.class)
public class NewSignUpPageTest extends Base {

	WebDriver driver;
	NewSignUpPage signuppage;

	@BeforeMethod
	public void setup() {
		driver = initialization();
		signuppage = new NewSignUpPage(driver);

	}

	@Test
	public void signuppagetest() {
		signuppage.clickonsignupbutton();
		signuppage.datadriven();
	}

	@DataProvider
	public Iterator<Object[]> gettestdata() {
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcelsheet();
		return testdata.iterator();
	}

	@Test(dataProvider = "gettestdata")
	public void verifyhomepagedetails() {

	}
}