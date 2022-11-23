package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public Base() {
		try {
			prop = new Properties();
			String propath = System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
			FileInputStream ip = new FileInputStream(propath);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver initialization() {
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	

	}

	public static void mouseclick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.click().build().perform();
	}

	public static void select(WebElement ele, String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

	public static void alertaccept() {
		boolean flag = false;
		try {

			Alert alert = driver.switchTo().alert();
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			Thread.sleep(5000);
			alert.accept();
			flag = true;
		} catch (Exception e) {
			System.out.println("Having issue in find the element");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Alert Message Received Succesfully");
			} else {
				System.out.println("Alert Message Not Received Succesfully");
			}
		}
	}

	public static void alertdismiss() {
		boolean flag = false;
		try {

			Alert alert = driver.switchTo().alert();
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			Thread.sleep(5000);
			alert.dismiss();
			flag = true;
		} catch (Exception e) {
			System.out.println("Having issue in find the element");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Alert Message Received Succesfully");
			} else {
				System.out.println("Alert Message Not Received Succesfully");
			}
		}
	}

	public static void switchtoframe(String name, WebDriver driver) {
		boolean flag = false;
		try {
			WebDriver iframe = driver.switchTo().frame(name);
			flag = true;
		} catch (Exception e) {
			System.out.println("Switching is not performed propelry");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Switching between the frame is runned succesfully");
			}
			System.out.println("Switching between the frame is failed");

		}
	}

	public static void switchtowindowhandles(WebElement ele, WebDriver driver) {
		ele.click();
		String mainwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				WebElement text = ele;
				System.out.println("Heading of child window is " + text.getText());
				driver.close();
				System.out.println("Child window closed");
			}
		}

		// Switch back to the main window which is the parent window.
		driver.switchTo().window(mainwindow);
		driver.quit();
	}

	public static void failedscreenshot(String testmethodname) {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile,
					new File("C:\\eclipse\\Sathish\\Screenshots\\" + testmethodname +  ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
