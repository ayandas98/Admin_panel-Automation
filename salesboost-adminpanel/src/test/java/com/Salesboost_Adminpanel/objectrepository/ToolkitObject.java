package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class ToolkitObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath = "//h2[contains(text(),'Tool Kit Files')]") public WebElement confText;
	@FindBy(xpath = "//a[contains(text(),'Add Tool Kit Files')]") public WebElement addKit;
	@FindBy(xpath = "//select[@id='documentType']") public WebElement docType;
	@FindBy(xpath = "//input[@id='fileImageUpload']") public WebElement imgUpload;
	@FindBy(xpath = "//button[contains(text(),'Add Tool Kit Files')]") public WebElement addTool;
	@FindBy(xpath = "//button[contains(text(),'Update Tool Kit Files')]") public WebElement updateKit;
	@FindBy(xpath = "//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/input[1]") public WebElement deleteKit;
	@FindBy(xpath = "//a[contains(text(),'Edit File')]") public WebElement editFile;
	
	public ToolkitObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addToolKit (String list, String img ) {
		try {
			log.info("add supp toolkit");
			waitForElementToLoad(confText);
			this.addKit.click();
			Thread.sleep(3000);
			waitForElementToLoad(addTool);
			this.docType.click();
			this.docType.sendKeys(list);
			this.imgUpload.sendKeys(img);
			this.addTool.click();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteKit() {
		try {
		log.info("delete asso kit");
		this.deleteKit.click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editKit(String list, String img) {
		try {
		log.info("edit asso kit");	
		this.editFile.click();
		this.docType.sendKeys(list);
		this.imgUpload.sendKeys(img);
		this.updateKit.click();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
