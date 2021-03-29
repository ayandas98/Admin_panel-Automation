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
	@FindBy(xpath ="//h1[contains(text(),'Edit User')]") public WebElement valid;
	@FindBy(xpath ="//span[@id='spanEmail']") public WebElement conf1;
	@FindBy(xpath ="//p[contains(text(),'Account already exists having email aytesting0+451')]") public WebElement conf2;
	
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
			this.addUser.click();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addUserWithoutData () {
		try {
			log.info("add user without mandatory fields ");
			this.firstName.sendKeys("first");
			this.accessLevel.click();
			this.accessLevel.sendKeys("s");
			waitForElementToLoad(addUser);
			this.addUser.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void userInvalidMail () {
	try {
		log.info("add user with invalid email id");
		this.Email.sendKeys("abc12");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void addUserExistingMail () {
		try {
			log.info("add user with existing email id");
			this.Email.sendKeys("aytesting0+450@gmail.com");
			this.firstName.sendKeys("firstname");
			this.lastName.sendKeys("lastname");
			this.accessLevel.sendKeys("A");
			waitForElementToLoad(addUser);
			this.addUser.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
}
