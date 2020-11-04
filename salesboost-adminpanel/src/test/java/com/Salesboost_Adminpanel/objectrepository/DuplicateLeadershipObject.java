package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class DuplicateLeadershipObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//h1[contains(text(),'Duplicate Leadership Tool Kit')]") public WebElement confText;
	@FindBy(xpath ="//div[@id='closePopup']") public WebElement closeButton;
	@FindBy(xpath ="//input[@id='kitsName']") public WebElement kitName;
	@FindBy(xpath ="//input[@id='kitShortName']") public WebElement kitShortName;
	@FindBy(xpath ="//select[@id='kitToDuplicate']") public WebElement dupList;
	@FindBy(xpath ="//input[@id='submitDuplicateKit']") public WebElement dupButton;
	
	public DuplicateLeadershipObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void duplicateLeadership (String name, String sname, String list) {
		try {
			log.info("dulpcate leadership tools");
			waitForElementToLoad(this.confText);
			this.kitName.click();
			this.kitName.sendKeys(name);
			this.kitShortName.click();
			this.kitShortName.sendKeys(sname);
			this.dupList.click();
			this.dupList.sendKeys(list);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
