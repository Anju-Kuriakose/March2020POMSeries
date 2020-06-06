package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPageTest extends BaseTest{
WebDriver driver;
	
	BasePage basePage;//BasePage class reference 
	LoginPage loginPage;
	
	Properties prop;
	
	@BeforeTest
	public void setUp() { //To call the methods in the BasePage class in this LoginPageTest class we need to create the object of that class
		
		basePage=new BasePage();
		prop=basePage.init_prop();
		//driver=basePage.init_driver("chrome");
		driver=basePage.init_driver(prop);
		loginPage=new LoginPage(driver);
	}
	
	

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched...");
	}

	@Test(priority = 1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sing up link is not displayed....");
	}

	@Test(priority = 3)
	public void loginTest() {
		//loginPage.doLogin("qatester2505@gmail.com", "Test@1981");
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterTest
		public void tearDown() {
			driver.quit();
		}
}
	
	/*
	WebDriver driver;
	
	BasePage basePage;//BasePage class reference 
	LoginPage loginPage;
	
	Properties prop;
	
	@BeforeTest
	public void setUp() { //To call the methods in the BasePage class in this LoginPageTest class we need to create the object of that class
		
		basePage=new BasePage();
		prop=basePage.init_prop();
		driver=basePage.init_driver(prop);
		loginPage=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title=loginPage.getLoginPageTitle();
		System.out.println("login page title is :" +title);
		//To verify the title,use assert
		//Assert.assertEquals(title,"HubSpot Login");//this hard code value "HubSpot Login"  is moved to constants.java 
		
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE,"login page title is not matched..");
	}
	@Test(priority=3)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(),"sign up link is not displayed...");
	}
	
	@Test(priority=2)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	*/
	
	//@AfterTest
	//public void tearDown() {
		//driver.quit();
	//}
	//}

