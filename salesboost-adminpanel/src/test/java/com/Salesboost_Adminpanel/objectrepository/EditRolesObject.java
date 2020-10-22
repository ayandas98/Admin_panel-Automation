package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditRolesObject extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy (xpath = "//input[@id='name']") public WebElement roleName ;
	@FindBy (xpath = "//textarea[@id='description']") public WebElement roleDescription ;
	@FindBy (xpath = "//input[@id='imageUpload']") public WebElement imageUpload ;
	@FindBy (xpath = "//input[@id='trackList_input']") public WebElement roleList ;
	@FindBy (xpath = "//button[@id='addRole_Btn']") public WebElement updateRoleButton;
	@FindBy (xpath = "//a[@id='modalCancel']") public WebElement cancelButton;
	
	public EditRolesObject (WebDriver driver) {	 
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editRoles (String name, String description, String list) {
		try {
			log.info("edit roles: role management screen");
			waitForElementToLoad(this.roleName);
			this.roleName.clear();
			this.roleName.sendKeys(name);
			this.roleDescription.clear();
			this.roleDescription.sendKeys(description);
			this.imageUpload.click();
			wait(1000);
			this.roleList.clear();
			this.roleList.sendKeys(list);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
