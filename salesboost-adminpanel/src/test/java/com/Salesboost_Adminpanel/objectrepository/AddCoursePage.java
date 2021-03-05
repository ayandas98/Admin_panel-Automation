package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AddCoursePage extends BaseClass{
	WebDriver driver;
		
	@FindBy(xpath = "//a[contains(text(),'Basic Course Details')]//following::input[1]") public WebElement addCourseBtn;
	@FindBy(xpath = "//input[@id='txtCourseName']") public WebElement courseNameField;
	@FindBy(xpath = "//input[@id='txtCourseShortName']") public WebElement shortCourseNameField;
	@FindBy(xpath = "//input[@id='txtSlugName']") public WebElement slugNameField;
	@FindBy(xpath = "//input[@id='Course_IsPrivate']") public WebElement privacyCheckbox;
	@FindBy(xpath = "//select[@id='SelectedWhiteLabelAccountId']") public WebElement whiteLabelSelector;
	@FindBy(xpath = "//input[@id='Course_Active']") public WebElement courseStatusCheckbox;
	@FindBy(xpath = "//textarea[@id='Course_Description']") public WebElement descriptionField;
	@FindBy(xpath = "//input[@id='0']") public WebElement basicSubscriptionRadioBtn;
	@FindBy(xpath = "//input[@id='1']") public WebElement basicPremiumRadioBtn;
	@FindBy(xpath = "//input[@name = 'previewVideoFile']") public WebElement fileUploadBtn;
	@FindBy(xpath = "//p[contains(text(),'Current File: ')]") public WebElement fileUploadVerification;
	@FindBy(xpath = "//input[@id='CertifiedCourse']") public WebElement certificationCheckbox;
	@FindBy(xpath = "//a[contains(text(),'Content')]//following::h1") public WebElement actualVerificationText;
	
	//IMAGE SELECTOR
	@FindBy(xpath = "//td[contains(text(),'Certified Course')]//following::img[1]")
	public WebElement Img1;
	@FindBy(xpath = "//label[@class = 'custom-file-input file-blue']")
	
	//verification
	//Another course already has this name. Please choose a unique course name.
	
	
	public WebElement imgFileUploadBtn;
	
	
	//CONSTRUCTOR 
	public AddCoursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
		public void addCourseCompleteDetails(String courseName, String courseShortName, String courseSlug, boolean privacyCheck, boolean courseStatusCheck, String courseDescription, String coursePreviewURL, boolean certifiedCheck) {
		
		waitForElementToLoad(this.courseNameField);
		this.courseNameField.sendKeys(courseName);
		this.shortCourseNameField.sendKeys(courseShortName);
		this.slugNameField.sendKeys(courseSlug);
		
		if(privacyCheck)
		{
			this.privacyCheckbox.click();
		}
		else
		{
			System.out.println("User has not checked the checkbox");
		}

		if(courseStatusCheck)
		{
			this.courseStatusCheckbox.click();
		}
		else
		{
			System.out.println("User has not checked the checkbox");
		}
		descriptionField.sendKeys(courseDescription);
		fileUploadBtn.sendKeys(coursePreviewURL);
		waitForElementToLoad(certificationCheckbox);
		
		if(certifiedCheck)
		{
			System.out.println("User has not checked the checkbox");
		}
		else
		{
			
			this.certificationCheckbox.click();
		}
		this.Img1.click();
		//imgFileUploadBtn.sendKeys("");
		this.addCourseBtn.click();
		
	}
		
		public void addCourseIncompleteDetails(String courseName, String courseShortName, String courseSlug, boolean privacyCheck, boolean courseStatusCheck, String courseDescription, String coursePreviewURL, boolean certifiedCheck) {
			
			waitForElementToLoad(this.courseNameField);
			this.courseNameField.sendKeys(courseName);
			this.shortCourseNameField.sendKeys("");
			this.slugNameField.sendKeys(courseSlug);
			
			if(courseStatusCheck)
			{
				this.privacyCheckbox.click();
			}
			else
			{
				System.out.println("User has not checked the checkbox");
			}

			if(privacyCheck)
			{
				this.courseStatusCheckbox.click();
			}
			else
			{
				System.out.println("User has not checked the checkbox");
			}
			this.descriptionField.sendKeys(courseDescription);
			this.fileUploadBtn.sendKeys(coursePreviewURL);
			
			if(certifiedCheck)
			{
				System.out.println("User has not checked the checkbox");
			}
			else
			{
				
				this.certificationCheckbox.click();
			}
			this.Img1.click();
			//imgFileUploadBtn.sendKeys("");
			this.addCourseBtn.click();
			
		}
		
		public void addCourseWithExistingName(String courseName, String courseShortName, String courseSlug, boolean privacyCheck, boolean courseStatusCheck, String courseDescription, String coursePreviewURL, boolean certifiedCheck) {
			waitForElementToLoad(this.courseNameField);
			this.courseNameField.sendKeys(courseName);
			this.shortCourseNameField.sendKeys(courseShortName);
			this.slugNameField.sendKeys(courseSlug);
			
			if(privacyCheck)
			{
				this.privacyCheckbox.click();
			}
			else
			{
				System.out.println("User has not checked the checkbox");
			}

			if(courseStatusCheck)
			{
				this.courseStatusCheckbox.click();
			}
			else
			{
				System.out.println("User has not checked the checkbox");
			}
			descriptionField.sendKeys(courseDescription);
			fileUploadBtn.sendKeys(coursePreviewURL);
			waitForElementToLoad(certificationCheckbox);
			
			if(certifiedCheck)
			{
				System.out.println("User has not checked the checkbox");
			}
			else
			{
				
				this.certificationCheckbox.click();
			}
			this.Img1.click();
			//imgFileUploadBtn.sendKeys("");
			this.addCourseBtn.click();
			
		}
		
		public void addCourseWithoutCertificateImg(String courseName, String courseShortName, String courseSlug, boolean privacyCheck, boolean courseStatusCheck, String courseDescription, String coursePreviewURL, boolean certifiedCheck) {
			waitForElementToLoad(this.courseNameField);
			this.courseNameField.sendKeys(courseName);
			this.shortCourseNameField.sendKeys(courseShortName);
			this.slugNameField.sendKeys(courseSlug);
			
			if(privacyCheck)
			{
				this.privacyCheckbox.click();
			}
			else
			{
				System.out.println("User has not checked the checkbox");
			}

			if(courseStatusCheck)
			{
				this.courseStatusCheckbox.click();
			}
			else
			{
				System.out.println("User has not checked the checkbox");
			}
			descriptionField.sendKeys(courseDescription);
			fileUploadBtn.sendKeys(coursePreviewURL);
			waitForElementToLoad(certificationCheckbox);
			
			if(certifiedCheck)
			{
				System.out.println("User has not checked the checkbox");
			}
			else
			{
				
				this.certificationCheckbox.click();
			}
			
		
			this.addCourseBtn.click();
			
		}
	
	
}