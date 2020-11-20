package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class PvoQuestion extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//h2[contains(text(),'PVO Question')]") public WebElement confText;
	@FindBy(xpath ="//textarea[@id='Question_Question']") public WebElement qQue;
	@FindBy(xpath ="//textarea[@id='Question_WrongAnswerText']") public WebElement qAns;
	@FindBy(xpath ="//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]") public WebElement addButton;
	
	public PvoQuestion (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void latObjects(String name,String desc) {
		try {
			log.info("latObjects");
			waitForElementToLoad(this.confText);
			this.qQue.sendKeys(name);
			this.qAns.sendKeys(desc);
			this.addButton.click();
			wait(100);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
