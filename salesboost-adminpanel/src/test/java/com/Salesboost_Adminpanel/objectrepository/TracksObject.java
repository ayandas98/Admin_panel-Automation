package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class TracksObject  extends BaseClass{

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy (xpath ="//select[@id='filterList']") public WebElement select ;
	@FindBy (xpath ="//th[contains(text(),'Track Name')]") public WebElement page ;
	@FindBy (xpath ="//a[contains(text(),'Add New Track')]") public WebElement addTrackButton ;
	
	public TracksObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void tracks (String sel) {
		try {
		log.info("tracks page");	
		waitForElementToLoad(this.page);
		this.select.click();
		this.select.sendKeys(sel);
		this.addTrackButton.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

