package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddQuickSalesTips extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//h1[contains(text(),'Add New Sales Tip')]") public WebElement confText;
	@FindBy(xpath ="//input[@id='QuickSalesTip_Title']") public WebElement tipTitle;
	@FindBy(xpath ="//input[@id='QuickSalesTip_Slug']") public WebElement urlSlug;
	@FindBy(xpath ="//input[@id='QuickSalesTip_SEOPageTitle']") public WebElement seoTitle;
	@FindBy(xpath ="//input[@id='QuickSalesTip_SEOMetaDescription']") public WebElement seoDescription;
	@FindBy(xpath ="//input[@id='QuickSalesTip_SEOMetaKeywords']") public WebElement seoKeyboard;
	@FindBy(xpath ="//input[@id='QuickSalesTip_IsActive']") public WebElement postActive;
	@FindBy(css ="html") public WebElement postContent;
	@FindBy(xpath ="//body/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]") public WebElement addButton;
	
	public AddQuickSalesTips (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addQuickTips(String title, String slug, String seoTitle, String des, String key, String content) {
		try {
			log.info("add quick tips");
			waitForElementToLoad(this.confText);
			this.tipTitle.clear();
			this.tipTitle.sendKeys(title);
			this.urlSlug.clear();
			this.urlSlug.sendKeys(slug);
			this.seoTitle.sendKeys(seoTitle);
			this.seoDescription.sendKeys(des);
			this.seoKeyboard.sendKeys(key);
			this.postContent.clear();
			this.postContent.sendKeys(content);
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
