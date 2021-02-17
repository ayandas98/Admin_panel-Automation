package com.Salesboost_Adminpanel.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
public class PrivateTrackDelete extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy(xpath = "//select[@id='selectwhitelabel'] ") public WebElement accSel;
	@FindBy (xpath = "//input[@id='deleteButton']") public WebElement trackDelete;
	
	public PrivateTrackDelete (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void delTracks (String sel) {
		try {
		log.info("delete tracks page");	
		waitForElementToLoad(this.accSel);
		this.accSel.click();
		this.accSel.sendKeys(sel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
}
