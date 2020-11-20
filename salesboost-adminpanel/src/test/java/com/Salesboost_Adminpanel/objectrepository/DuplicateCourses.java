package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class DuplicateCourses extends BaseClass{

	WebDriver driver;
	@FindBy (xpath ="//h1[contains(text(),'Duplicate Course')]") public WebElement confText;
	@FindBy (xpath ="//input[@id='courseName']") public WebElement courseName;
	@FindBy (xpath ="//input[@id='courseSlug']") public WebElement courseSlug;
	@FindBy (xpath ="//select[@id='courseToDuplicate']") public WebElement list;
	@FindBy (xpath ="//button[@id='submitDuplicate']") public WebElement dupButton;
	@FindBy (xpath ="//body/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]") public WebElement cancelButton;
	
	public DuplicateCourses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void duplicateCourse(String name,String slug,String list) {
		try {
			log.info("duplicate course");
			waitForElementToLoad(this.confText);
			this.courseName.sendKeys(name);
			this.courseSlug.sendKeys(slug);
			this.list.click();
			this.list.sendKeys(list);
			wait(100);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
