package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddCourseObject extends BaseClass{

	WebDriver driver;
	@FindBy (xpath ="//h2[contains(text(),'Basic Course Detail')]") public WebElement confText;
	@FindBy (xpath ="//input[@id='txtCourseName']") public WebElement courseName;
	@FindBy (xpath ="//input[@id='txtCourseShortName']") public WebElement shortName;
	@FindBy (xpath ="//tbody/tr[3]/td[2]") public WebElement courseSlug;
	@FindBy (xpath ="//input[@id='Course_Active']") public WebElement courseActive;
	@FindBy (xpath ="//textarea[@id='Course_Description']") public WebElement courseDesc;
	@FindBy (xpath ="//tbody/tr[9]/td[2]/input[1]") public WebElement courseUrl;
	@FindBy (xpath ="//body/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]") public WebElement addButton;
	
	public AddCourseObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addCourse(String name,String sName,String slug,String desc) {
		try {
			log.info("add basic course details");
			waitForElementToLoad(this.confText);
			this.courseName.sendKeys(name);
			this.shortName.sendKeys(sName);
			this.courseSlug.sendKeys(slug);
			this.courseActive.click();
			this.courseDesc.sendKeys(desc);
			this.courseUrl.click();
			wait(600);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
