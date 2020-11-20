package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class FaqObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//h2[contains(text(),'Course FAQ')]") public WebElement confText;
	@FindBy(xpath ="//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]") public WebElement uploadButton;
	@FindBy(xpath ="//textarea[@id='Course_FAQs_0__Question']") public WebElement faqName;
	@FindBy(xpath ="//iframe[@id='Course_FAQs_0__Answer_ifr']") public WebElement faqDesc;
	@FindBy(xpath ="//body[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/section[2]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/input[1]") public WebElement deleteButton;
	@FindBy(xpath ="//input[@id='add-faq']") public WebElement addButton;
	
	public FaqObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void latObjects(String name,String desc) {
		try {
			log.info("latObjects");
			waitForElementToLoad(this.confText);
			this.faqName.sendKeys(name);
			this.faqDesc.sendKeys(desc);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
