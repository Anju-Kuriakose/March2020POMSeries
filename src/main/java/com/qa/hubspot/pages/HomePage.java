package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;
	
	//By header=By.xpath("i18n-string[text()='Thanks for choosing HubSpot']");
	By header=By.cssSelector("h1.private-header__heading"); 
	By accountName=By.cssSelector("span.account-name");
	
	//designing contacts page,primary contacts click and clicking on secondary contacts
	//By primaryContactLink=By.id("nav-primary-contacts-branch");
	//By secondaryContactLink=By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		//elementUtil = new ElementUtil(this.driver);
		
	}
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	public String getHomePageHeaderText() {
		if(driver.findElement(header).isDisplayed()) {
		return driver.findElement(header).getText();
	}
		return null;
	}
	
	public String getLoggedInUser() {
		if(driver.findElement(accountName).isDisplayed()) {
		return driver.findElement(accountName).getText();
	}
		return null;
	}
	/*public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	private void clickOnContacts() {
		elementUtil.waitForElementToBeVisible(primaryContactLink, 10);
		elementUtil.doClick(primaryContactLink);
		elementUtil.waitForElementToBeVisible(secondaryContactLink, 5);
		elementUtil.doClick(secondaryContactLink);
	}
		*/
	
}