package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class PvoObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//h2[contains(text(),'Presentation with Voice Over Video (PVO)')]") public WebElement confText;
	@FindBy(xpath ="//tbody/tr[1]/td[2]/input[1]") public WebElement urlUpload;
	@FindBy(xpath ="pvoPoster") public WebElement pvoPoster;
	@FindBy(xpath ="//input[@id='Course_PVO_Name']") public WebElement pvoName;
	@FindBy(xpath ="//textarea[@id='Course_PVO_Description']") public WebElement pvoDesc;
	@FindBy(xpath ="//span[contains(text(),'Add Question')]") public WebElement addQue;
	@FindBy(xpath ="//tbody/tr[2]/th[2]/label[2]/span[1]") public WebElement quizButton;
	@FindBy(xpath ="//tbody/tr[3]/th[2]/label[1]/span[1]") public WebElement equalButton;
	@FindBy(xpath ="//input[@id='Course_PVO_MinimumMark']") public WebElement minMark;
	@FindBy(xpath ="//input[@id='updatePvo']") public WebElement updateButton;
	
	public PvoObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void latObjects(String name,String desc, String min) {
		try {
			log.info("latObjects");
			waitForElementToLoad(this.confText);
			this.pvoName.sendKeys(name);
			this.pvoDesc.sendKeys(desc);
			this.urlUpload.click();
			wait(300);
			this.pvoPoster.click();
			wait(300);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
