package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class ATASnippetPage extends BaseClass{
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name = 'submit']") public WebElement ATAAddSnippetButton;
	@FindBy(xpath = "//input[@name = 'submit']//following::input[1]") public WebElement snippetUpload;
	@FindBy(xpath = "//textarea[@id='Snippet_ScriptSnippet']") public WebElement snippetDescription;
	@FindBy(xpath = "//a[contains(text(),'Add Audio Snippet')]") public WebElement ATAAddSnippet;
	@FindBy(xpath = "//h2[contains(text(),'Audio Test Administration')]//following::a[1]") public WebElement ATAEditSnippet;
	
	
	public void addSnippet(String snippedURL, String snippetDesc) {
		this.ATAAddSnippet.click();
		waitForElementToLoad(this.snippetUpload);
		this.snippetUpload.sendKeys(snippedURL);
		this.snippetDescription.sendKeys(snippetDesc);
		this.ATAAddSnippetButton.click();
	}
	
	public void editSnippet(String snippedURL, String snippetDesc) {
		this.ATAEditSnippet.click();
		waitForElementToLoad(this.snippetUpload);
		this.snippetUpload.sendKeys(snippedURL);
		this.snippetDescription.sendKeys(snippetDesc);
		this.ATAAddSnippetButton.click();
	}
	
	public ATASnippetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
}