package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditSystemAnnouncements extends BaseClass{

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy(xpath = "//h1[contains(text(),\"Edit: You're Invited!\")]") public WebElement confText;
	@FindBy(xpath = "//input[@id='BlogPost_Title']") public WebElement postTitle ;
	@FindBy(xpath = "//input[@id='BlogPost_SubTitle']") public WebElement subTitle;
	@FindBy(xpath = "//input[@id='BlogPost_Slug']") public WebElement postSlug;
	@FindBy(xpath = "//input[@id='BlogPost_SEOPageTitle']") public WebElement seoTitle;
	@FindBy(xpath = "//input[@id='BlogPost_SEOMetaDescription']") public WebElement seoDescription;
	@FindBy(xpath = "//input[@id='BlogPost_SEOMetaKeywords']") public WebElement seoKeywords;
	@FindBy(xpath = "//select[@id='author-id']") public WebElement postAuthor;
	@FindBy(xpath = "//input[@id='BlogPost_IsActive']") public WebElement postActive;
	@FindBy(xpath = "//td[contains(text(),'Tags')]/following::td//input") public WebElement postTags;
	@FindBy(xpath = "//tbody/tr[12]/td[2]/ul[1]/li[1]/input[1]") public WebElement postRelated;
	@FindBy(xpath = "//tbody/tr[13]/td[2]/ul[1]/li[1]") public WebElement postCourses;
	@FindBy(xpath = "//div[@id='mceu_41-0']") public WebElement postContent;
	@FindBy(xpath = "//body/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]") public WebElement updateButton;
	@FindBy(xpath = "//input[@id='deleteButton']") public WebElement deleteButton;
	@FindBy(xpath = "//h1[contains(text(),'Edit: ')]") public WebElement actualVerificationText;
	
	public EditSystemAnnouncements (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void EditAnnouncements(String posttitle, String subtitle,String slug,String seotitle,String desc,String key, String author ,String tags,String rel,String course, String content) {
		try {
			log.info("Edit system announcements");
			waitForElementToLoad(this.confText);
			this.postTitle.click();
			this.postTitle.sendKeys(posttitle);
			this.subTitle.clear();
			this.subTitle.sendKeys(subtitle);
			this.postSlug.clear();
			this.postSlug.sendKeys(slug);
			this.seoTitle.clear();
			this.seoTitle.sendKeys(seotitle);
			this.seoDescription.clear();
			this.seoDescription.sendKeys(desc);
			this.seoKeywords.clear();
			this.seoKeywords.sendKeys(key);
			this.postAuthor.clear();
			this.postAuthor.sendKeys(author);
			this.postTags.sendKeys(tags);
			this.postTags.sendKeys(Keys.RETURN);
			this.postRelated.sendKeys(rel);
			this.postRelated.sendKeys(Keys.RETURN);
			this.postCourses.sendKeys(course);
			this.postCourses.sendKeys(Keys.RETURN);
			this.postContent.clear();
			this.postContent.sendKeys(content);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
