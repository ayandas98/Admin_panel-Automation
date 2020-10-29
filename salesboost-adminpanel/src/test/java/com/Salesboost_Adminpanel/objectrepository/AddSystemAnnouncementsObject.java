package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddSystemAnnouncementsObject extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy(xpath = "//input[@id='BlogPost_Title']") public WebElement postTitle;
	@FindBy(xpath = "//input[@id='BlogPost_SubTitle']") public WebElement postSubTitle ;
	@FindBy(xpath = "//input[@id='BlogPost_Slug']") public WebElement postSlug;
	@FindBy(xpath = "//input[@id='BlogPost_SEOPageTitle']") public WebElement seoTitle;
	@FindBy(xpath = "//input[@id='BlogPost_SEOPageTitle']") public WebElement seoDescription;
	@FindBy(xpath = "//input[@id='BlogPost_SEOMetaKeywords']") public WebElement seoKeyword;
	@FindBy(xpath = "//select[@id='author-id']") public WebElement postAuthor;
	@FindBy(xpath = "//input[@id='BlogPost_IsActive']") public WebElement postActive ;
	@FindBy(xpath = "//iframe[@id='BlogPost_Content_ifr']") public WebElement postContent ;
	@FindBy(xpath = "//body/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]") public WebElement addButton ;
	@FindBy(xpath = "//h1[contains(text(),'Add New System Announcement')]") public WebElement confText;
	
	public AddSystemAnnouncementsObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void AddSystemAnnouncements (String posttitle, String postsubtitle, String postslug, String seotitle, String seodescription, String seokeyword,String postauthor, String postcontent ) {
		try {
			log.info("add system announcement");
			waitForElementToLoad(this.confText);
			this.postTitle.clear();
			this.postTitle.sendKeys(posttitle);
			this.postSubTitle.clear();
			this.postSubTitle.sendKeys(postsubtitle);
			this.postSlug.clear();
			this.postSlug.sendKeys(postslug);
			this.seoTitle.clear();
			this.seoTitle.sendKeys(seotitle);
			this.seoDescription.clear();
			this.seoDescription.sendKeys(seodescription);
			this.seoKeyword.clear();
			this.seoKeyword.sendKeys(seokeyword);
			this.postAuthor.clear();
			this.postAuthor.sendKeys(postauthor);
			this.postContent.clear();
			this.postContent.sendKeys(postcontent);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
