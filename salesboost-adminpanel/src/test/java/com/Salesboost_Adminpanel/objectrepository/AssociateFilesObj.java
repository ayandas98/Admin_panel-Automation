package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AssociateFilesObj extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//h2[contains(text(),'Associated Files')]") public WebElement confText;
	@FindBy(xpath ="//a[contains(text(),'Add File')]") public WebElement addButton;
	@FindBy(xpath ="//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]") public WebElement updateButton;
	
	public AssociateFilesObj (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
}
