package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class ManagePassword extends BaseClass{

	DashboardObject dashboardObj;
	WebDriver driver;
	@FindBy (xpath ="//h1[contains(text(),'Generate Password')]") public WebElement text;
	@FindBy (xpath ="//input[@id='UserEmail']") public WebElement Email;
	@FindBy (xpath ="//button[@class='button action submit-form submit-password']") public WebElement button;
	@FindBy (xpath ="//h1[contains(text(),'Generate Password')]") public WebElement valid;
	
	public ManagePassword(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void managePassword (String email) {
	
		try {
		
		this.Email.clear();
		this.Email.sendKeys(email);
		waitForElementToLoad(button);
		button.click();
		Thread.sleep(500);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
} 
