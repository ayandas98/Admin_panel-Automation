package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class LatObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//h2[contains(text(),'Live Action Training Video (LAT)')]") public WebElement confText;
	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]") public WebElement uploadButton;
	@FindBy(xpath ="//input[@id='LatAndFileList_0__LAT_Name']") public WebElement latName;
	@FindBy(xpath ="//textarea[@id='LatAndFileList_0__LAT_Description']") public WebElement latDesc;
	@FindBy(xpath ="//tbody/tr[3]/td[3]/input[1]") public WebElement deleteButton;
	@FindBy(xpath ="//input[@id='add-lat']") public WebElement addButton;
	
	public LatObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void latObjects(String name,String desc) {
		try {
			log.info("latObjects");
			waitForElementToLoad(this.confText);
			this.latName.sendKeys(name);
			this.latDesc.sendKeys(desc);
			this.uploadButton.click();
			wait(300);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
