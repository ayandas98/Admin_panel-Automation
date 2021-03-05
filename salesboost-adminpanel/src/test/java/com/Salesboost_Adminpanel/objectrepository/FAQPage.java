package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class FAQPage extends BaseClass{
	
	WebDriver driver;
	
	//FAQ
		@FindBy(xpath = "//a[contains(text(),'Course FAQ')]") public WebElement FAQTabBtn;
		@FindBy(xpath = "//a[contains(text(),'Course FAQ')]//following::input[1]") public WebElement FAQAddUpdateBtn;
		@FindBy(xpath = "//textarea[@id='Course_FAQs_0__Question']") public WebElement FAQQuestion;
		@FindBy(xpath = "//th[contains(text(),'Answer')]//following::iframe") public WebElement FAQAnswer;				
		@FindBy(xpath = "//input[@class = 'delete-faq-button button red']") public WebElement FAQDeleteBtn;
		@FindBy(xpath = "//input[@id='add-faq']") public WebElement FAQAddFAQBtn;
		@FindBy(xpath = "//p[contains(text(),'Please note that if you have unsaved changes you w')]") public WebElement deleteFAQVerification;
		
		public void addQuestionAnswerDetails(String question, String answer) throws InterruptedException {
			this.FAQTabBtn.click();
			this.FAQAddFAQBtn.click();
			this.FAQQuestion.clear();
			this.FAQQuestion.sendKeys(question);
			this.FAQAnswer.clear();
		
		WebElement faqAnswer = driver.findElement(By.name("Course_FAQs_0__Answer_ifr"));
		driver.switchTo().frame("Course_FAQs_0__Answer_ifr");
		faqAnswer.sendKeys(answer);
			
			//this.FAQAnswer.sendKeys(answer);
			
		}
		public void updateFAQ() {
			this.FAQAddUpdateBtn.click();
		}
		public void deleteFAQ() {
			this.FAQDeleteBtn.click();
		}
		
		public FAQPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(this.driver, this);
		}
		
		
}