package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddNewWhitelabelAccountObject extends BaseClass {

	WebDriver driver;
	AccountHoldersObject accountHoldersObject;
	DashboardObject dashboardObj;
	
	@FindBy(xpath ="//h1[contains(text(),'Add Account')]") public WebElement header;
	@FindBy(xpath ="//input[@id='Account_Name']") public WebElement name ;
	@FindBy(xpath ="//select[@id='SelectedLevel']") public WebElement levelSelect ;
	@FindBy(xpath ="//select[@id='SelectedType']") public WebElement typeSelect ;
	@FindBy(xpath ="//input[@id='Account_IsActive']") public WebElement activeAccount ;
	@FindBy(xpath ="//input[@id='IsWhiteLabel']") public WebElement whiteLabel;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_DisplayName']") public WebElement displayName ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_HostName']") public WebElement hostName ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_NavigationBackgroundColor']") public WebElement brandColor ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_NavigationForegroundColor']") public WebElement secondaryBrandColor;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_NavigationTrimColor']") public WebElement accentColor;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_CourseCertificateColor']") public WebElement certificateColor ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_CourseCertificateScoreColor']") public WebElement scoreColor ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_TrackCertificateColor']") public WebElement headerColor;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_TrackCertificateScoreColor']") public WebElement layoutColor;
	@FindBy(xpath ="//input[@id='file']") public WebElement logoUploadButton ;
	
	@FindBy(xpath ="//body/div[@class='content-wrapper']/div[@class='tab-content']/div[@class='tab-sub-content']/div[@class='nolink-content-1']/form[@id='accountDetailsForm']/table/tbody/tr[8]/td[2]/input[1]") public WebElement ownerFirstName;
	@FindBy(xpath ="//td[4]//input[1]") public WebElement ownerLastName ;
	@FindBy(xpath ="//input[@id='txtEmail']") public WebElement ownerEmail;
	@FindBy(xpath ="//input[@id='btnSubmit']") public WebElement addAccount ;
	
	public AddNewWhitelabelAccountObject (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addNewWhitelabelAccount (String name,String list,String choice , String displayname, String hostname, String brandcolor, String seccolor, String accentcolor, String certificatecolor, String scorecolor, String headercolor, String layoutcolor , String firstname, String lastname, String email ) {
	
		try {
			log.info("add new account");
			this.name.clear();
			this.name.sendKeys(name);
			this.levelSelect.click();
			this.levelSelect.sendKeys(list);
			this.typeSelect.click();
			waitForElementToLoad(typeSelect);
			this.typeSelect.sendKeys(choice);
			waitForElementToLoad(activeAccount);
			this.activeAccount.click();
			this.whiteLabel.click();
			this.displayName.clear();
			this.displayName.sendKeys(displayname);
			this.hostName.clear();
			this.hostName.sendKeys(hostname);
			this.brandColor.clear();
			this.brandColor.sendKeys(brandcolor);
			this.secondaryBrandColor.clear();
			this.secondaryBrandColor.sendKeys(seccolor);
			this.accentColor.clear();
			this.accentColor.sendKeys(accentcolor);
			this.certificateColor.clear();
			this.certificateColor.sendKeys(certificatecolor);
			this.scoreColor.clear();
			this.scoreColor.sendKeys(scorecolor);
			this.headerColor.clear();
			this.headerColor.sendKeys(headercolor);
			this.layoutColor.clear();
			this.layoutColor.sendKeys(layoutcolor);
			//this.logoUploadButton.click();
			wait(500);
			this.ownerFirstName.clear();
			this.ownerFirstName.sendKeys(firstname);
			this.ownerLastName.clear();
			this.ownerLastName.sendKeys(lastname);
			this.ownerEmail.clear();
			this.ownerEmail.sendKeys(email);
			waitForElementToLoad(addAccount);
			this.addAccount.click();
		}
		catch (Exception e) {
		e.printStackTrace();
		}	
	}
}
