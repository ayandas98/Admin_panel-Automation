package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditLeadershipToolObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//input[@id='Name']") public WebElement kitName;
	@FindBy(xpath ="//input[@id='ShortName']") public WebElement kitSname;
	@FindBy(xpath ="//input[@id='Status']") public WebElement kitStatus;
	@FindBy(xpath ="//textarea[@id='Description']") public WebElement kitDescription;
	@FindBy(xpath ="//button[contains(text(),'Update Leadership Tool Kit')]") public WebElement updateButton;
	@FindBy(xpath ="//input[@id='deleteKitButton']") public WebElement deleteButton;
	@FindBy(xpath = "//h1[contains(text(),'Edit Leadership Tool Kit:')]") public WebElement actualVerificationText;
	
	public EditLeadershipToolObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editleadershipTool(String name,String sname,String desc) {
		try {
			log.info("edit leadership tool");
			this.kitName.clear();
			this.kitName.sendKeys(name);
			this.kitSname.clear();
			this.kitSname.sendKeys(sname);
			this.kitDescription.clear();
			this.kitDescription.sendKeys(desc);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
