package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AccountHoldersObject extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy(xpath ="//select[@id='filterList']") public WebElement accountSelect;
	@FindBy(xpath ="//input[@placeholder='Search by Account or Owner Name']") public WebElement accountSearch ;
	@FindBy(xpath ="//input[@class='button']") public WebElement searchButton ;
	@FindBy(xpath ="//span[contains(text(),'Add New Account')]") public WebElement addNewAccount ;
	@FindBy(xpath ="//strong[contains(text(),'SuperAdmin')]") public WebElement admin ;
	
	public AccountHoldersObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void accountHolders (String list , String name) {
		try {
			log.info("account holders");
			this.accountSelect.click();
			this.accountSelect.sendKeys(list);
			this.accountSearch.clear();
			this.accountSearch.sendKeys(name);
			waitForElementToLoad(accountSearch);
			this.searchButton.click();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
