package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditQuickSalesTip extends BaseClass{

	WebDriver driver;
	@FindBy (xpath ="//input[@id='QuickSalesTip_Title']") public WebElement tipTitle;
	@FindBy (xpath ="//input[@id='QuickSalesTip_Slug']") public WebElement urlSlug;
	@FindBy (xpath ="//input[@id='QuickSalesTip_SEOPageTitle']") public WebElement seoTitle;
	@FindBy (xpath ="//input[@id='QuickSalesTip_SEOMetaDescription']") public WebElement seoDescription;
	@FindBy (xpath ="//input[@id='QuickSalesTip_SEOMetaKeywords']") public WebElement seoKeys;
	@FindBy (xpath ="//input[@id='QuickSalesTip_IsActive']") public WebElement tipActive;
	@FindBy (xpath ="//td[contains(text(),'Tags')]/following::td//input") public WebElement tipTags;
	@FindBy (xpath ="//div[@id='mceu_41-0']") public WebElement tipContent;
	@FindBy (xpath ="//body/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]") public WebElement updateButton;
	@FindBy (xpath ="//input[@id='deleteButton']") public WebElement deleteButton;
	@FindBy (xpath ="//div[@id='mceu_41-0']") public WebElement cont;
	@FindBy(xpath ="//h1[contains(text(),'Edit: ')]") public WebElement actualVerificationText;
	
	public EditQuickSalesTip (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editSalesTip (String title, String slug, String seoTitle, String des, String key, String tags , String content) {
		try {
			log.info("edit sales tip");
			this.tipTitle.clear();
			this.tipTitle.sendKeys(title);
			this.urlSlug.clear();
			this.urlSlug.sendKeys(slug);
			this.seoTitle.clear();
			this.seoTitle.sendKeys(seoTitle);
			this.seoDescription.clear();
			this.seoDescription.sendKeys(des);
			this.seoKeys.clear();
			this.seoKeys.sendKeys(key);
			waitForElementToLoad(this.tipTags);
			Thread.sleep(2000);
			this.tipTags.sendKeys(tags);
			this.tipTags.sendKeys(Keys.ENTER);
			this.tipContent.click();
			this.cont.sendKeys(content);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
