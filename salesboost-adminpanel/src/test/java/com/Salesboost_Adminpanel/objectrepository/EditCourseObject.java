package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditCourseObject extends BaseClass{

	WebDriver driver;
	@FindBy (xpath ="//h2[contains(text(),'Basic Course Detail')]") public WebElement confText;
	@FindBy (xpath ="//body/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]") public WebElement updateButton;
	@FindBy (xpath ="//input[@id='deleteButtonCourse']") public WebElement deleteButton;
	@FindBy (xpath ="//input[@id='btnUpdateUsersToNewVersion']") public WebElement updateAll;
	@FindBy (xpath ="//input[@id='btnAddNewVersion']") public WebElement addVersion;
	@FindBy (xpath ="//input[@id='btnDiscontinueCourse']") public WebElement discontinueCourse;
	@FindBy (xpath ="//tbody/tr[10]/td[2]/ul[1]/li[1]") public WebElement courseTag;
	@FindBy (xpath ="//input[@id='txtCourseName']") public WebElement courseName;
	@FindBy (xpath ="//input[@id='txtCourseShortName']") public WebElement courseShortName;
	@FindBy (xpath ="//input[@id='txtSlugName']") public WebElement courseSlug;
	@FindBy (xpath ="//textarea[@id='Course_Description']") public WebElement courseDesc;
	
	public EditCourseObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editCourse(String name,String sName,String slug,String desc,String tags) {
		try {
			log.info("edit course");
			waitForElementToLoad(this.confText);
			this.courseName.sendKeys(name);
			this.courseShortName.sendKeys(sName);
			this.courseSlug.sendKeys(slug);
			this.courseDesc.sendKeys(desc);
			this.courseTag.sendKeys(tags);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
