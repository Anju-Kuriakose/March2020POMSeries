package com.qa.hubspot.pages;

import java.util.Collection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;


public class ContactsPage extends BasePage {
	
	private WebDriver driver;
	public ElementUtil elementUtil;
	
	//By header = By.cssSelector("h1.private-header__heading");
	By header=By.xpath("i18n-string[text()='Contacts']");
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[last()]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	}

	public String getContactsPageHeader() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	}

	public void createContact(String email, String firstName, String lastName, String jobTitle) {
		//ElementUtil elementUtil = null;
		elementUtil.clickWhenReady(createContactPrimary, 10);

		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);

		elementUtil.doSendKeys(this.jobTitle, jobTitle);

		elementUtil.doActionsClick(createContactSecondary);

	}

}
