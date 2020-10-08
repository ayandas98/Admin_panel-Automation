package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddNewUserObject extends BaseClass {
	
	AdministratorsObject administratorsObject;
	WebDriver driver;
	
	@FindBy(xpath ="//h1[contains(text(),'Add User')]") public WebElement header;
	@FindBy(xpath ="//input[@id='txtEmail']") public WebElement Email;
	@FindBy(xpath ="//input[@id='User_FirstName']") public WebElement firstName;
	@FindBy(xpath ="//input[@id='User_LastName']") public WebElement lastName;
	@FindBy(xpath ="//select[@id='SelectedRole']") public WebElement accessLevel;
	@FindBy(xpath ="//input[@id='btnSubmit']") public WebElement addUser;
	
	public AddNewUserObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addNewUser (String email, String firstname, String lastname, String role ) {
		try {
			log.info("add new user");
			
			this.Email.clear();
			this.Email.sendKeys(email);
			this.firstName.clear();
			this.firstName.sendKeys(firstname);
			this.lastName.clear();
			this.lastName.sendKeys(lastname);
			waitForElementToLoad(accessLevel);
			this.accessLevel.click();
			this.accessLevel.sendKeys(role);
			waitForElementToLoad(addUser);
			addUser.click();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
