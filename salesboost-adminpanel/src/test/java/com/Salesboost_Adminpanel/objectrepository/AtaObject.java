package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AtaObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//textarea[@id='Course_AudioTest_IntroHtml']") public WebElement introText;
	@FindBy(xpath ="//tbody/tr[2]/td[2]/input[1]") public WebElement audioSnippet;
	@FindBy(xpath ="//input[@id='Course_AudioTest_IdealTestId']") public WebElement testId;
	@FindBy(xpath ="//a[contains(text(),'Add Audio Snippet')]") public WebElement addButton;
	@FindBy(xpath ="//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]") public WebElement updateButton;
	@FindBy(xpath ="//h2[contains(text(),'Audio Test Administration')]") public WebElement confText;
	
	public AtaObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void ataObject(String text, String id) {
		try {
		log.info("ata page");
		waitForElementToLoad(this.confText);
		this.introText.sendKeys(text);
		this.testId.sendKeys(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
