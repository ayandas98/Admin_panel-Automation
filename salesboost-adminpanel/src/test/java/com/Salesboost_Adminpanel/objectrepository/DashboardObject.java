package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class DashboardObject extends BaseClass {
	
	WebDriver driver;
	
	@FindBy (xpath ="//a[contains(text(),'Users')]") public WebElement usersTab; 
	@FindBy (xpath ="//a[@class='tab-link logoff-trigger']") public WebElement logOut;
	@FindBy (xpath ="//a[contains(text(),'Plans')]") public WebElement plansTab;
	@FindBy (xpath ="//a[contains(text(),'Content')]") public WebElement contentTab;
	@FindBy (xpath ="//strong[contains(text(),'SuperAdmin')]") public WebElement Admin;
	@FindBy (xpath ="//a[contains(text(),'Administrators')]") public WebElement administrator;
	@FindBy (xpath ="//a[contains(text(),'Account Holders')]") public WebElement accountHolders;
	@FindBy (xpath ="//a[contains(text(),'Manage Password')]") public WebElement managePassword;
	@FindBy (xpath ="//a[contains(text(),'Tracks')]") public WebElement tracks;
	@FindBy (xpath = "//a[contains(text(),'Role Management')]") public WebElement roleManagement;
	@FindBy (xpath ="//a[contains(text(),'System Announcements')]") public WebElement systemAnnouncement;
	@FindBy (xpath ="//a[contains(text(),'Leadership Tips')]") public WebElement leadershipTips;
	@FindBy (xpath ="//a[contains(text(),'Quick Sales Tips')]") public WebElement salesTips;
	@FindBy (xpath ="//a[contains(text(),'Leadership Tool Kits')]") public WebElement leadershipTools;
	@FindBy (xpath ="//a[contains(text(),'Courses')]") public WebElement courses;
	
	public DashboardObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	/*public DashboardObject () {
		PageFactory.initElements(driver, this);
	}*/
	
	public void userClick() {
		try {
		waitForElementToLoad(usersTab);
		this.usersTab.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
