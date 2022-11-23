package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.excel.util.Xlsx_Reader;
import com.crm.qa.util.TestUtil;

public class NewSignUpPage extends Base {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signupbutton;

	@FindBy(id = "payment_plan_id")
	WebElement editondropdown;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement fname;

	@FindBy(xpath = "//input[@name='surname']")
	WebElement lname;

	@FindBy(xpath = "//input[@name='email']")
	WebElement mail;

	@FindBy(xpath = "//input[@name='email_confirm']")
	WebElement confirmmailid;

	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pass;

	@FindBy(xpath = "//input[@name='passwordconfirm']")
	WebElement confirmpass;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "//button[@id='submitButton']")
	WebElement submit;

	public NewSignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonsignupbutton() {
		signupbutton.click();

	}

	public void datadriven() {

		select(editondropdown, "Free Edition");

		Xlsx_Reader reader = new Xlsx_Reader(
				"C:\\eclipse\\Sathish\\src\\main\\java\\com\\crm\\qa\\testdata\\Crmpro data.xlsx");
		int rowCount = reader.getRowCount("SignUp");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String firstname = reader.getCellData("SignUp", "firstname", rowNum);
			String lastname = reader.getCellData("SignUp", "lastname", rowNum);
			String email = reader.getCellData("SignUp", "email", 2);
			String confirmemail = reader.getCellData("SignUp", "confirmemail", rowNum);
			String username = reader.getCellData("SignUp", "username", rowNum);
			String password = reader.getCellData("SignUp", "password", rowNum);
			String confirmpassword = reader.getCellData("SignUp", "confirmpassword", rowNum);

			fname.clear();
			fname.sendKeys(firstname);
			lname.clear();
			lname.sendKeys(lastname);
			mail.clear();
			mail.sendKeys(email);
			confirmmailid.clear();
			confirmmailid.sendKeys(confirmemail);
			uname.clear();
			uname.sendKeys(username);
			pass.clear();
			pass.sendKeys(password);
			confirmpass.clear();
			confirmpass.sendKeys(confirmpassword);
			checkbox.clear();
			checkbox.click();
			submit.click();

		}
	}


}
