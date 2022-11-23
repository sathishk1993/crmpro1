package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.listeners.FailedScreenShots;
import com.crm.qa.base.Base;
import com.crm.qa.pages.LoginPage;

@Listeners(FailedScreenShots.class)
public class LoginPageTest extends Base {

	//log4j means it helps to log the activites performed during the program execution
	// we should create log4j.properties only in resources folder
	//types of logs
	// info,warn,error,fatal
	
	WebDriver driver;
	LoginPage login;
	Logger log =Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initialization();
		login = new LoginPage(driver);

	}

	@Test(groups ="smoke")
		public void loginpagetest() {
		log.info("*************** Login into the application****************");
		
		log.fatal("there is no fatal error");
		log.debug("this is debug mode");
		login.verifyuser(prop.getProperty("username"), prop.getProperty("password"));

	}
	
//	@Test(groups = {"smoke","Sanity"})
//	public void dataprovider() {
//	login.verifyuser(prop.getProperty("username"), prop.getProperty("password"));
//
//}

	@Test
	public void verifycrmprolabeltest() {
		log.warn("*************There is some issue over here warning********");

		Assert.assertEquals(login.verifycrmprolabel(), false);
	}

}
