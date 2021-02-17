package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddPrivateTracksObject extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy (xpath = "//h1[contains(text(),'Add Track:')]") public WebElement confText ;
	@FindBy (xpath = "//input[@id='Track_Name']") public WebElement trackName ;
	@FindBy (xpath = "//input[@id='Track_Slug']") public WebElement trackSlug;
	@FindBy (xpath = "//input[@id='isPrivateTrack']") public WebElement trackPrivate;
	@FindBy (xpath ="//select[@id='SelectedWhiteLabelAccountId']") public WebElement trackAccountSelect;
	@FindBy (xpath = "//input[@id='Track_IsFocus']") public WebElement trackFocus ;
	@FindBy (xpath = "//input[@id='Track_Active']") public WebElement trackStatus ;
	@FindBy (xpath = "//textarea[@id='Track_Description']") public WebElement trackDescription ;
	@FindBy (xpath = "//tbody/tr[9]/td[1]/ul[1]/li[1]") public WebElement trackImage ;
	//@FindBy (xpath = "//tbody/tr[9]/td[2]/label[1]") public WebElement trackImageUpload ;
	@FindBy (xpath = "//body/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]") public WebElement addTrackButton ;
	@FindBy (xpath ="//h1[contains(text(),'Edit Track:')]") public WebElement actualVerificationText ;
	
	public AddPrivateTracksObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addPrivateTracks (String name, String slug ,String list , String description ) {
		try {
			log.info("add private tracks");
			waitForElementToLoad (this.confText);
			this.trackName.clear();
			this.trackName.sendKeys(name);
			this.trackSlug.clear();
			this.trackSlug.sendKeys(slug);
			this.trackPrivate.click();
			this.trackAccountSelect.click();
			this.trackAccountSelect.sendKeys(list);
			this.trackAccountSelect.click();
			//this.trackFocus.click();
			this.trackStatus.click();
			this.trackDescription.clear();
			this.trackDescription.sendKeys(description);
			this.trackImage.click();
			Thread.sleep(1000);
			//this.addTrackButton.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
