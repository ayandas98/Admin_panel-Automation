package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class SignInObject extends BaseClass {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='Email']") public WebElement Email;
	@FindBy(xpath = "//input[@id='Password']") public WebElement Password;
	@FindBy(xpath="//input[@class='button action']") public WebElement buttonaction;
	@FindBy(tagName = "img") public WebElement logo;
	

 
	
	public SignInObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	/*public SignInObject() {
		PageFactory.initElements(driver, this);

	}*/
	
	public void signIn(String email, String password) {
		try {
			log.info("Entered signIn method");
			

			
			
			System.out.println(email + password);
			//this.Email.clear();
			this.Email.sendKeys(email);
			this.Password.clear();
			

			this.Password.sendKeys(password);
			waitForElementToLoad(buttonaction);
			buttonaction.click();
			Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
			
		}		
	}

}
