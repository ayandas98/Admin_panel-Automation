package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditWhitelabelAccountObject extends BaseClass {

	WebDriver driver;
	AccountHoldersObject accountHoldersObject;
	
	@FindBy(xpath ="//input[@id='Account_Name']") public WebElement  accountName ;
	@FindBy(xpath ="//select[@id='SelectedLevel']") public WebElement level ;
	@FindBy(xpath ="//select[@id='SelectedType']") public WebElement accountType  ;
	@FindBy(xpath ="//input[@id='Account_IsActive']") public WebElement active ;
	@FindBy(xpath ="//input[@id='IsWhiteLabel']") public WebElement whitelabel ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_DisplayName']") public WebElement displayName ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_HostName']") public WebElement hostName ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_NavigationBackgroundColor']") public WebElement brandColor ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_NavigationForegroundColor']") public WebElement secondaryBrandColor ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_NavigationTrimColor']") public WebElement accentColor ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_CourseCertificateColor']") public WebElement certificateColor;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_CourseCertificateScoreColor']") public WebElement scoreColor ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_TrackCertificateColor']") public WebElement headerColor ;
	@FindBy(xpath ="//input[@id='Account_WhiteLabel_TrackCertificateScoreColor']") public WebElement layoutColor;
	@FindBy(xpath ="//input[@id='file']") public WebElement logo ;
	
	@FindBy(xpath ="//input[@id='txtEmail']") public WebElement ownerEmail  ;
	@FindBy(xpath ="//input[@id='btnSubmit']") public WebElement update;
	
	public EditWhitelabelAccountObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editWhitelabelAccount (String name, String list, String org , String displayname, String hostname, String brandcolor, String secondarybrandcolor, String accentcolor, String certificatecolor, String scorecolor , String headercolor,String layoutcolor  , String email ) {
		try {
			log.info("update whitelabel account");
			this.accountName.clear();
			this.accountName.sendKeys(name);
			this.level.click();
			this.level.sendKeys(list);
			this.accountType.click();
			this.accountType.sendKeys(org);
			this.active.click();
			//this.whitelabel.click();
			this.displayName.clear();
			this.displayName.sendKeys(displayname);
			this.hostName.clear();
			this.hostName.sendKeys(hostname);
			this.brandColor.clear();
			this.brandColor.sendKeys(brandcolor);
			this.secondaryBrandColor.clear();
			this.secondaryBrandColor.sendKeys(secondarybrandcolor);
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
			this.logo.click();
			wait(5000);
			this.ownerEmail.clear();
			this.ownerEmail.sendKeys(email);
			Thread.sleep(1000);
			this.update.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
