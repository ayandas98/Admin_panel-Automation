package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class SystemAnnouncementsObject extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy(xpath = "//th[contains(text(),'Post Title')]") public WebElement confText;
	@FindBy(xpath = "//select[@id='filterList']") public WebElement postSelect;
	@FindBy(xpath = "//a[contains(text(),'Add New System Announcement Post')]") public WebElement addPost;
	
	public SystemAnnouncementsObject (WebDriver driver) {
		this.driver= driver ;
		PageFactory.initElements(this.driver, this);
	}
	
	public void systemAnnouncements (String post, String name) {
		try {
			log.info("system announcements page");
			waitForElementToLoad(this.addPost);
			waitForElementToLoad(this.confText);
			this.postSelect.click();
			this.postSelect.sendKeys(post);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
