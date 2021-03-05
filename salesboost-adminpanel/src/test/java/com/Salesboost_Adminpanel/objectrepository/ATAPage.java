package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;



public class ATAPage extends BaseClass{
	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Audio Test Administration')]") public WebElement ATATabBtn;
	@FindBy(xpath = "//input[@name = 'submit']") public WebElement ATAAddTestBtn;
	@FindBy(xpath = "//h2[contains(text(),'Audio Test Administration')]//following::img[1]") public WebElement ATAImgSelect;
	@FindBy(id = "imageFile") public WebElement ATAImgUploadBrowse;
	@FindBy(xpath = "//textarea[@id='Course_AudioTest_IntroHtml']") public WebElement ATAIntroText;
	@FindBy(xpath = "//input[@name='introFile']") public WebElement ATAIntroFileUpload;
	@FindBy(xpath = "//input[@id='Course_AudioTest_IdealTestId']") public WebElement ATATestID;
	@FindBy(xpath = "//p[contains(text(),'Ideal Test ID')]//following::a[1]") public WebElement ATAEditEntry;
	@FindBy(xpath = "//a[contains(text(),'Add Audio Snippet')]") public WebElement ATAAddSnippet;
	@FindBy(xpath = "//a[contains(text(),'Audio Test Administration')]//following::input[1]") public WebElement ATAAddUpdateBtn;

	//add snippet
	@FindBy(xpath = "//input[@name = 'submit']") public WebElement ATAAddSnippetButton;
	@FindBy(xpath = "//input[@name = 'submit']//following::input[1]") public WebElement snippetUpload;
	@FindBy(xpath = "//textarea[@id='Snippet_ScriptSnippet']") public WebElement snippetDescription;	
	
	public ATAPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editATAPage(String introTextText, String introFileURL, String testID){
		this.ATATabBtn.click();
		waitForElementToLoad(this.ATAImgSelect);
		this.ATAImgSelect.click();
		this.ATAIntroText.sendKeys(introTextText);
		this.ATAIntroFileUpload.sendKeys(introFileURL);
		this.ATATestID.sendKeys(testID);		
	}
	public void updateATA() {
		this.ATAAddUpdateBtn.click();
	}	
}
