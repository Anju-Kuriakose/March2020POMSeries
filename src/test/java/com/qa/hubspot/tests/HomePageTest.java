package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest{
	
WebDriver driver;
Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void SetUp() { 
		
	basePage=new BasePage();
prop=basePage.init_prop();
	//driver=basePage.init_driver("chrome");
driver=basePage.init_driver(prop);
	loginPage=new LoginPage(driver);
	//homePage=loginPage.doLogin("qatester2505@gmail.com","Test@1981");
		
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void verifyHomePageTitle() {
		String title=homePage.getHomePageTitle();
		System.out.println("the title of the home page is : " +title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE,"home page title is not matched..");
		
	}
	@Test(priority=1)
	public void verifyHomePageHeader() {
		String header=homePage.getHomePageHeaderText();
		System.out.println("Home page page header is:" +header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER,"home page header is  not present");
	}
	@Test(priority=2)
	public void verifyLoggedInUserTest() {
		String loggedInUser=homePage.getLoggedInUser();
		System.out.println("Logged In User is:" +loggedInUser);
		//Assert.assertEquals(loggedInUser, "student","logged in user is not matched");
		Assert.assertEquals(loggedInUser, prop.getProperty("accountName"),"logged in user is not matched");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
