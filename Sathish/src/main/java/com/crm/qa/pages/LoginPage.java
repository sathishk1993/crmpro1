package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbutton;

	@FindBy(xpath = "//a[@class='navbar-brand']/img")
	WebElement labelname;

	public HomePage verifyuser(String name, String pass) {
		uname.sendKeys(name);
		pwd.sendKeys(pass);
		loginbutton.click();
		return new HomePage();
	}

	public boolean verifycrmprolabel() {
		return labelname.isDisplayed();

	}
}
