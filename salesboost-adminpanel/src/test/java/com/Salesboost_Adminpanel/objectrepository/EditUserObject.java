package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditUserObject extends BaseClass {

	AdministratorsObject administratorsObject;
	WebDriver driver;
	
	@FindBy (xpath ="//h2[contains(text(),'User Detail')]") public WebElement header ;
	@FindBy (xpath ="//input[@id='txtEmail']") public WebElement userEmail ;
	@FindBy (xpath ="//input[@id='User_FirstName']") public WebElement firstName ;
	@FindBy (xpath ="//input[@id='User_LastName']") public WebElement lastName ;
	@FindBy (xpath ="//select[@id='SelectedRole']") public WebElement  role;
	@FindBy (xpath ="//input[@id='btnSubmit']") public WebElement updateUser;
	//@FindBy (xpath ="//input[@id='deleteButton']") public WebElement deleteUser ;
	
	public EditUserObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editUser (String email, String firstname, String lastname, String pro) {
		try {
		log.info("edit user");
		Thread.sleep(2000);
		this.userEmail.clear();
		this.userEmail.sendKeys(email);
		this.firstName.clear();
		this.firstName.sendKeys(firstname);
		this.lastName.clear();
		this.lastName.sendKeys(lastname);
		waitForElementToLoad(role);	
		this.role.click();
		this.role.sendKeys(pro);
		this.role.click();

		waitForElementToLoad(role);	
		this.updateUser.click();
		Thread.sleep(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
