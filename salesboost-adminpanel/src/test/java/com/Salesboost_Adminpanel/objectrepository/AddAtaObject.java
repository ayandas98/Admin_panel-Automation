package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddAtaObject extends BaseClass{

	WebDriver driver;
	AtaObject ataObject;
	@FindBy(xpath ="//h2[contains(text(),'Audio Test Snippet Administration')]") public WebElement confText;
	@FindBy(xpath ="//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]") public WebElement addButton;
	@FindBy(xpath ="//tbody/tr[1]/td[2]/input[1]") public WebElement fileUpload;
	@FindBy(xpath ="//textarea[@id='Snippet_ScriptSnippet']") public WebElement scriptSnippet;
	
	public AddAtaObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addFile	(String text) {
		try {
			log.info("add ata snippets files");
			waitForElementToLoad(this.confText);
			this.scriptSnippet.sendKeys(text);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
