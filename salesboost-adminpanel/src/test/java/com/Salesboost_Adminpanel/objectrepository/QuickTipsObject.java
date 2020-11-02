package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class QuickTipsObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//th[contains(text(),'Sales Tip Title')]") public WebElement confText;
	@FindBy(xpath ="//select[@id='filterList']") public WebElement tipsList;
	@FindBy(xpath ="//a[contains(text(),'Add New Sales Tip')]") public WebElement addButton;
	
	public QuickTipsObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void quickTipsobject (String sel, String name) {
		try {
			log.info("quick sales tips");
			waitForElementToLoad(this.confText);
			this.tipsList.click();
			this.tipsList.sendKeys(sel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
