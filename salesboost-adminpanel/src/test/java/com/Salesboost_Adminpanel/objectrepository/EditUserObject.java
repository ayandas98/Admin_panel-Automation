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
	@FindBy (xpath ="//h1[contains(text(),'Edit User:')]")public WebElement valid;
	@FindBy (xpath ="//span[@id='spanEmail']") public WebElement conf1;
	@FindBy (xpath ="//p[contains(text(),'Failed : -3')]") public WebElement conf2;
	
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
	
	public void editUserWithoutMandatoryData() {
		try {
			log.info("edit user without mandatory data");
			this.firstName.sendKeys("firstname");
			this.role.sendKeys("G");
			this.updateUser.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editUserInvalidMail () {
		try {
		log.info("edit user using invalid email id");
		this.userEmail.clear();
		this.userEmail.sendKeys("email");
		Thread.sleep(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editUserExistingMail () {
		try {
		log.info("edit user using an existing email id");
		this.userEmail.clear();
		this.userEmail.sendKeys("aytesting0+451@gmail.com");
		this.firstName.clear();
		this.firstName.sendKeys("firstname");
		this.lastName.clear();
		this.lastName.sendKeys("lastname");
		waitForElementToLoad(role);	
		this.role.click();
		this.role.sendKeys("A");
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
