package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;



public class AwardPage extends BaseClass{
	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Award')]") public WebElement AwardsPageTab;
	@FindBy(xpath = "//select[@id='selectwhitelabel']") public WebElement AwardsPageDropDown;
	@FindBy(xpath = "//input[@id='certificatesignatoryName']") public WebElement CertificateSignName;	
	@FindBy(xpath = "//input[@id='certificateSignatoryTitle']") public WebElement CertificateSignTitle;
	@FindBy(xpath = "//input[@id='certificateSignature']") public WebElement CertificateSignUpload;
	@FindBy(xpath = "//input[@id='certificateFooterLogo']") public WebElement CertificateLogoUpload;
	@FindBy(xpath = "//input[@id='clearallBtn']") public WebElement ClearAllBtn;
	@FindBy(xpath = "//input[@id='settingsBtn']") public WebElement UpdateBtn;
	@FindBy(xpath = "//input[@id='viewbtn']") public WebElement ViewAllBtn;
		
	public AwardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editAwardsPage(String dropDownOption, String certificateSign,String certitiateTitle,String certificateSignURL, String certificateLogoURL) {
		this.AwardsPageTab.click();
		waitForElementToLoad(this.CertificateSignName);
		this.AwardsPageDropDown.sendKeys(dropDownOption);
		this.CertificateSignName.clear();
		this.CertificateSignTitle.clear();
		this.CertificateSignName.sendKeys(certificateSign);
		this.CertificateSignTitle.sendKeys(certitiateTitle);
		this.CertificateSignUpload.sendKeys(certificateSignURL);
		this.CertificateLogoUpload.sendKeys(certificateLogoURL);
		
		}
	
	public void addUpdateAwards() {
		this.UpdateBtn.click();
	}
	
	public void clearAwards() {
		this.ClearAllBtn.click();
	}
	
}