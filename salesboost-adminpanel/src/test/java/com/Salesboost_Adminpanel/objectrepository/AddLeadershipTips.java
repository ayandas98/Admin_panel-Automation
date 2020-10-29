package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddLeadershipTips extends BaseClass{

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy(xpath ="//input[@id='LeadershipTip_Title']") public WebElement leadershipTipDetail;
	@FindBy(xpath ="//input[@id='LeadershipTip_TipNumber']") public WebElement tipNumber;
	@FindBy(xpath ="//input[@id='LeadershipTip_Slug']") public WebElement urlSlug;
	@FindBy(xpath ="//input[@id='LeadershipTip_SEOPageTitle']") public WebElement seoTitle;
	@FindBy(xpath ="//input[@id='LeadershipTip_SEOMetaDescription']") public WebElement seoDescription;
	@FindBy(xpath ="//input[@id='LeadershipTip_SEOMetaKeywords']") public WebElement seoKeywords;
	@FindBy(xpath ="//input[@id='LeadershipTip_IsActive']") public WebElement tipActive;
	@FindBy(xpath ="//iframe[@id='LeadershipTip_Content_ifr']") public WebElement tipContent;
	@FindBy(xpath ="//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]") public WebElement addButton;
	@FindBy(xpath = "//h1[contains(text(),'Add Leadership Tip')]") public WebElement confText;
	
	public AddLeadershipTips (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addTips (String detail, String number, String slug, String title, String desc,String key, String content) {
	try {
		log.info("add leadership tips");
		waitForElementToLoad(this.confText);
		this.leadershipTipDetail.clear();
		this.leadershipTipDetail.sendKeys(detail);
		this.tipNumber.click();
		this.tipNumber.sendKeys(number);
		this.urlSlug.clear();
		this.urlSlug.sendKeys(slug);
		this.seoTitle.clear();
		this.seoTitle.sendKeys(title);
		this.seoDescription.clear();
		this.seoDescription.sendKeys(desc);
		this.seoKeywords.clear();
		this.seoKeywords.sendKeys(key);
		this.tipContent.clear();
		this.tipContent.sendKeys(content);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
}
