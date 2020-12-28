package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditLeadershipTips extends BaseClass{

	WebDriver driver;
	@FindBy(xpath = "//input[@id='LeadershipTip_Title']") public WebElement leadershipTitle;
	@FindBy(xpath = "//input[@id='LeadershipTip_TipNumber']") public WebElement tipNumber;
	@FindBy(xpath = "//input[@id='LeadershipTip_Slug']") public WebElement urlSlug;
	@FindBy(xpath = "//input[@id='LeadershipTip_SEOPageTitle']") public WebElement seoTitle;
	@FindBy(xpath = "//input[@id='LeadershipTip_SEOMetaDescription']") public WebElement seoDescription;
	@FindBy(xpath = "//input[@id='LeadershipTip_SEOMetaKeywords']") public WebElement seoKeys;
	@FindBy(xpath = "//input[@id='LeadershipTip_IsActive']") public WebElement tipActive;
	@FindBy(xpath = "//td[contains(text(),'Tags')]/following::td//input") public WebElement tipTags;
	@FindBy(xpath = "//tbody/tr[10]/td[2]/ul[1]/li[1]/input[1]") public WebElement tipPosts;
	@FindBy(xpath = "//div[@id='mceu_41-0']") public WebElement tipContent;
	@FindBy(xpath = "//body/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]") public WebElement updateButton;
	@FindBy(xpath = "//input[@id='deleteButton']") public WebElement deleteButton;
	
	public EditLeadershipTips (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editTips (String title, String num, String slug, String seotitle, String des, String key, String tag, String post, String cont) {
		try {
			log.info("edit leadership tips");
			waitForElementToLoad(this.updateButton);
			this.leadershipTitle.clear();
			this.leadershipTitle.sendKeys(title);
			this.tipNumber.clear();
			this.tipNumber.sendKeys(num);
			this.urlSlug.clear();
			this.urlSlug.sendKeys(slug);
			this.seoTitle.clear();
			this.seoTitle.sendKeys(seotitle);
			this.seoDescription.clear();
			this.seoDescription.sendKeys(des);
			this.seoKeys.clear();
			this.seoKeys.sendKeys(key);
			//waitForElementToLoad(tipTags);
			//this.tipTags.sendKeys(tag);
			//this.tipTags.sendKeys(Keys.RETURN);
			//this.tipPosts.click();
			this.tipPosts.sendKeys(post);
			this.tipContent.click();
			this.tipContent.sendKeys(cont);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
