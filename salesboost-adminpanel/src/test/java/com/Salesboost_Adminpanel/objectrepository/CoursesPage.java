package com.Salesboost_Adminpanel.objectrepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;





public class CoursesPage extends BaseClass{
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Content')]")
	public WebElement ContentBtn;
	@FindBy(xpath = "//a[contains(text(),'Content')]//following::a[1]")
	public WebElement CoursesBtn;
	@FindBy(xpath = "//a[contains(text(),'Add New Course')]")
	public WebElement addNewCoursesBtn;
	@FindBy(xpath = "//a[@id='duplicate']")
	public WebElement duplicateCoursesBtn;
	@FindBy(xpath = "//select[@id='filterList']")
	public WebElement courseFilterList;
	
	
	public CoursesPage(WebDriver driver)   {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void searchCourses(String courseName) {
		
		courseNameText(courseName).click();
	}
	
	
	public WebElement courseNameText(String courseText)
	{
	    WebElement cCheckBox =  driver.findElement(By.xpath("//a[contains(text(),'"+courseText+"')]"));
	    return cCheckBox;
	}
}
