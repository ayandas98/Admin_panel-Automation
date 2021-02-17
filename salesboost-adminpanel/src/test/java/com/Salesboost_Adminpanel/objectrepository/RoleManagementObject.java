package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class RoleManagementObject extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy (xpath = "//select[@id='filterList']") public WebElement filterList ;
	@FindBy (xpath = "//th[contains(text(),'Role Name')] ") public WebElement confText ;
	@FindBy (xpath = "//body/div[1]/div[1]/div[1]/div[1]/input[1] ") public WebElement addButton ;
	@FindBy (xpath = "//th[contains(text(),'Role Name')]") public WebElement valid;
	
	public RoleManagementObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void roleManagement (String sel, String search) {
		try {
			log.info("rolemanagement filtered selection");
			waitForElementToLoad(this.confText);
			this.filterList.click();
			this.filterList.sendKeys(sel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
