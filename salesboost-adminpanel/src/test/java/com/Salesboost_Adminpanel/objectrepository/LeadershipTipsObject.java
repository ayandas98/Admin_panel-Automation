package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class LeadershipTipsObject extends BaseClass{

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy(xpath = "//th[contains(text(),'Leadership Tips Title')]") public WebElement confText;
	@FindBy(xpath = "//select[@id='filterList']") public WebElement leadershipList;
	@FindBy(xpath = "//a[contains(text(),'Add New Leadership Tips')]") public WebElement addTips;
	@FindBy(xpath = "//th[contains(text(),'Leadership Tips Title')]") public WebElement valid;
	
	public LeadershipTipsObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void leadershipObject (String sel, String name) {
		try {
			log.info("leadership tools");
			waitForElementToLoad(this.confText);
			this.leadershipList.click();
			this.leadershipList.sendKeys(sel);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
