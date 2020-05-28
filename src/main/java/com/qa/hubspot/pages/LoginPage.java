package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver; //for every webpage we maintain a private driver,only accessible in this particular class
	//1. Maintain By locators---> Object Repository -with the help of By Locators to be maintained on the particular page.
	By username=By.id("username");
	By password=By.id("password");
	By loginButton=By.id("loginBtn");
	By signUpLink=By.linkText("Sign up");
	
	//2.Create constructor of page class
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Create page actions ;
	//these are not test cases;these are page methods to be verified in the TestNG class
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username,String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();
	return new HomePage(driver);
	}
	
	
	
}
