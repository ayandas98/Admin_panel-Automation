package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditAccount extends BaseClass {

	WebDriver driver;
	AccountHoldersObject accountHoldersObject;
	
	@FindBy(xpath ="//input[@id='Account_Name']") public WebElement  accountName ;
	@FindBy(xpath ="//select[@id='SelectedLevel']") public WebElement level ;
	@FindBy(xpath ="//select[@id='SelectedType']") public WebElement accountType  ;
	@FindBy(xpath ="//input[@id='Account_IsActive']") public WebElement active ;
	@FindBy(xpath ="//input[@id='IsWhiteLabel']") public WebElement whitelabel ;
	@FindBy(xpath ="//input[@id='txtEmail']") public WebElement ownerEmail  ;
	@FindBy(xpath ="//input[@id='btnSubmit']") public WebElement update;
	@FindBy(xpath ="//h1[contains(text(),'Edit:')]")public WebElement valid;
	
	public EditAccount (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editAccount (String name, String list, String org ,String email ) {
		try {
			log.info("update account");
			this.accountName.clear();
			this.accountName.sendKeys(name);
			this.level.click();
			this.level.sendKeys(list);
			this.accountType.click();
			this.accountType.sendKeys(org);
			this.active.click();
			//this.whitelabel.click();
			this.ownerEmail.clear();
			this.ownerEmail.sendKeys(email);
			Thread.sleep(1000);
			this.update.click();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
