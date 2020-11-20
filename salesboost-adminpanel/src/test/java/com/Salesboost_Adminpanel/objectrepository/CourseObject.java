package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class CourseObject extends BaseClass{

	WebDriver driver;
	DashboardObject dashboardObject;
	@FindBy (xpath ="//th[contains(text(),'Course Name')]") public WebElement confText;
	@FindBy (xpath ="//a[contains(text(),'Add New Course')]") public WebElement addButton;
	@FindBy (xpath ="//a[@id='duplicate']") public WebElement dupButton;
	@FindBy (xpath ="//select[@id='filterList']") public WebElement list;
	
	public CourseObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, driver);
	}
	
	public void courseTools(String list,String name) {
		try {
			log.info("courses page");
			waitForElementToLoad(this.confText);
			this.list.click();
			this.list.sendKeys(list);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
