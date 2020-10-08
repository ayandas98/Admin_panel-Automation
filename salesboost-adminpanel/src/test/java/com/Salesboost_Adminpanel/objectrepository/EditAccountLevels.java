/*
package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditAccountLevels extends BaseClass {
	
	WebDriver driver;
	EditAccount editAccount;
	
	@FindBy (xpath ="//h2[contains(text(),'Account Levels')]") public WebElement header;
	@FindBy (xpath ="//input[@id='btnAddLevel']") public WebElement addLevels;
	
	@FindBy (xpath ="//select[@id='dirSelectedLevel']") public WebElement accountLevel;
	@FindBy (xpath ="//select[@id='ddlParentUserEmails']") public WebElement  parentUser ;
	@FindBy (xpath ="//select[@id='ddlFocustracks']") public WebElement focusTracks ;
	@FindBy (xpath ="//input[@id='DirectorLevelAccount_Owner_FirstName']") public WebElement firstName ;
	@FindBy (xpath ="//input[@id='DirectorLevelAccount_Owner_LastName']") public WebElement lastName;
	@FindBy (xpath ="//input[@id='DirectorLevelAccount_Owner_Email']") public WebElement Email;
	@FindBy (xpath ="//input[@id='btnAddLevels']") public WebElement addButton;
	
	public EditAccountLevels (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editAccountLevels (String levelopt, String useropt, String focusopt, String firstname, String lastname, String email) {
	
		try {
			log.info("edit account levels");
			editAccount.levels.click();
			this.addLevels.click();
			this.accountLevel.click();
			this.accountLevel.sendKeys(levelopt);
			this.parentUser.click();
			this.parentUser.sendKeys(useropt);
			this.focusTracks.click();
			this.focusTracks.sendKeys(focusopt);
			this.firstName.clear();
			this.firstName.sendKeys(firstname);
			this.lastName.clear();
			this.lastName.sendKeys(lastname);
			this.Email.clear();
			this.Email.sendKeys(email);
			this.addButton.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/
