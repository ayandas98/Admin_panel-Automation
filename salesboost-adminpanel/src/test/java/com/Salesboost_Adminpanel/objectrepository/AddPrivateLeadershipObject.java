package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddPrivateLeadershipObject extends BaseClass {
	
	WebDriver driver;
	@FindBy(xpath = "//h2[contains(text(),'Basic Tool Kit Details')]") public WebElement confText;
	@FindBy(xpath = "//input[@id='Name']") public WebElement kitName;
	@FindBy(xpath = "//input[@id='ShortName']") public WebElement kitSname;
	@FindBy(xpath = "//input[@id='Status']") public WebElement kitStatus;
	@FindBy(xpath = "//textarea[@id='Description']") public WebElement kitDescription;
	@FindBy(xpath = "//button[contains(text(),'Add New Leadership Tool Kit')]") public WebElement addButton;
	@FindBy(xpath ="//input[@id='toolkitPrivate']") public WebElement kitPrivate;
	@FindBy(xpath ="//select[@id='SelectedWhiteLabelAccountId']") public WebElement kitList;
	@FindBy(xpath = "//h1[contains(text(),'Edit Leadership Tool Kit:')]") public WebElement actualVerificationText;
	
	public AddPrivateLeadershipObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addLeadershipTool (String name,String sname,String list,String desc) {
		try {
			log.info("add leadership tool object");
			waitForElementToLoad(this.confText);
			this.kitName.click();
			this.kitName.sendKeys(name);
			this.kitSname.sendKeys(sname);
			this.kitPrivate.click();
			this.kitList.click();
			this.kitList.sendKeys(list);
			this.kitDescription.click();
			this.kitDescription.sendKeys(desc);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
