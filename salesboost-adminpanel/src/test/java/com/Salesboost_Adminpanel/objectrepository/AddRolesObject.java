package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddRolesObject extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy (xpath = "//input[@id='name']") public WebElement roleName ;
	@FindBy (xpath = "//input[@id='TrackRole_IsActive']") public WebElement roleActive;
	@FindBy (xpath = "//textarea[@id='description']") public WebElement roleDescription;
	@FindBy (xpath = "//input[@id='imageUpload']") public WebElement imageUpload ;
	@FindBy (xpath = "//input[@id='trackList_input']") public WebElement roleList ;
	@FindBy (xpath = "//button[@id='addRole_Btn']") public WebElement addRoleButton ;
	@FindBy (xpath = "//a[@id='modalCancel']") public WebElement cancelButton;
	
	public AddRolesObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addRoles (String name, String description) {
		try {
			log.info("add role : roles management screen");
			waitForElementToLoad(this.roleName);
			this.roleName.clear();
			this.roleName.sendKeys(name);
			this.roleActive.click();
			this.roleDescription.clear();
			this.roleDescription.sendKeys(description);
			this.imageUpload.sendKeys("D:/salesboost admin/role management/add role/download.png");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
