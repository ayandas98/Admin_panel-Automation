package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddAssociateObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//h2[contains(text(),'Associated File')]") public WebElement confText;
	@FindBy(xpath ="//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]") public WebElement addButton;
	@FindBy(xpath ="//tbody/tr[1]/td[2]/input[1]") public WebElement fileUpload;
	@FindBy(xpath ="//input[@id='File_LinkText']") public WebElement linkText;
	
	public AddAssociateObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addAssociateFiles(String text) {
		try {
			log.info("add associate files");
			waitForElementToLoad(this.confText);
			this.linkText.sendKeys(text);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
