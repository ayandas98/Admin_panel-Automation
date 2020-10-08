package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AdministratorsObject extends BaseClass {

	DashboardObject dashboardObj;
	WebDriver driver;
	
	@FindBy(xpath ="//input[@placeholder='Search by User Name']") public WebElement Username;
	@FindBy(xpath ="//input[@class='button']") public WebElement searchButton;
	@FindBy(xpath = "//a[@class='button action']") public WebElement addNewUserButton;
	@FindBy(xpath ="//strong[contains(text(),'SuperAdmin')]") public WebElement admin;
	@FindBy(xpath ="//select[@id='filterList']") public WebElement userSelect;
	
	public AdministratorsObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void administrators(String list , String name ) {
		
		try {
			log.info("adinstrator");
			this.userSelect.click();
			this.userSelect.sendKeys(list);
			waitForElementToLoad(Username);
			this.Username.clear();
			this.Username.sendKeys(name);
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
