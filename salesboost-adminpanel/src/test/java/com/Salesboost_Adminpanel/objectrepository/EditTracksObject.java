package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditTracksObject extends BaseClass {

	WebDriver driver;
	DashboardObject dashboardObj;
	
	@FindBy (xpath = "//h1[contains(text(),'Edit Track: AGM')] ") public WebElement confText;
	@FindBy (xpath = "//input[@id='Track_Name'] ") public WebElement trackName ;
	@FindBy (xpath = "//input[@id='Track_Slug'] ") public WebElement trackSlug ;
	@FindBy (xpath = "//input[@id='Track_IsFocus']") public WebElement trackFocus;
	@FindBy (xpath = "//textarea[@id='Track_Description']  ") public WebElement trackDescription ;
	@FindBy (xpath = "//tbody/tr[8]/td[2]/ul[1]/li[1]/input[1]") public WebElement trackTags ;
	@FindBy (xpath = "//tbody/tr[9]/td[2]/ul[1]/li[1]/input[1] ") public WebElement trackCourses ;
	@FindBy (xpath = "//input[@id='CertifiedTrack'] ") public WebElement trackCertified;
	@FindBy (xpath = "//body/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1] ") public WebElement trackUpdateButton ;
	@FindBy (xpath = "//input[@id='deleteButton']") public WebElement trackDelete;
	@FindBy (xpath ="//tbody/tr[10]/td[2]/input[1]") public WebElement trackPost;
	
	public EditTracksObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editTrack (String name, String slug, String description, String tag, String course) {
		try {
			log.info("edit track");
			//waitForElementToLoad(this.confText);
			this.trackName.clear();
			this.trackName.sendKeys(name);
			this.trackSlug.clear();
			this.trackSlug.sendKeys(slug);
			//this.trackFocus.click();
			this.trackDescription.clear();
			this.trackDescription.sendKeys(description);
			this.trackTags.click();
			this.trackTags.sendKeys(tag);
			waitForElementToLoad(this.trackCourses);
			this.trackCourses.sendKeys(course);
			this.trackCourses.sendKeys(Keys.RETURN);
			this.trackPost.sendKeys("D:/salesboost admin/role management/add role/download.png");
			this.trackCertified.click();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
