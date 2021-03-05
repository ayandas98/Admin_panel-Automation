package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;



public class PVOPage extends BaseClass {
	
	WebDriver driver;
	//PVO
		@FindBy(xpath = "//a[contains(text(),'Presentation with Voice Over Video (PVO)')]") public WebElement PVOTabBtn;
		@FindBy(xpath = "//a[contains(text(),'Presentation with Voice Over Video (PVO)')]//following::input[1]") public WebElement updatePVOBtn;
		@FindBy(xpath = "//input[@name = 'file']") public WebElement uploadVideoBtn;
		@FindBy(xpath = "//h2[contains(text(),'Presentation with Voice Over Video (PVO)')]//following::p[1]") public WebElement videoVerficationText;
		@FindBy(xpath = "//input[@name = 'poster']") public WebElement uploadPosterBtn;
		@FindBy(xpath = "//input[@name = 'poster']//following::p[1]") public WebElement posterVerificationText;
		@FindBy(xpath = "//input[@id='Course_PVO_Name']") public WebElement PVOVideoName;
		@FindBy(xpath = "//textarea[@id='Course_PVO_Description']") public WebElement PVOVideoDescription;
		@FindBy(xpath = "//input[@id='Course_PVO_MinimumMark']") public WebElement minimumPassField;
		@FindBy(xpath = "//h4[contains(text(),'Question')]//following::span[1]") public WebElement scoreQuizActivationSlider;
		@FindBy(xpath = "//input[@id='Course_PVO_EqualWeightage']") public WebElement equalWeightageCheckbox;
		@FindBy(xpath = "//input[@id='orderNumber_0']") public WebElement orderField1;
		@FindBy(xpath = "//input[@id='orderNumber_1']") public WebElement orderField2;
		@FindBy(xpath = "//input[@id='marks_0']") public WebElement markField1;
		@FindBy(xpath = "//input[@id='marks_1']") public WebElement markField2;	
		@FindBy(xpath = "//h4[contains(text(),'Question')]//following::a[1]") public WebElement Edit1;
		@FindBy(xpath = "//h4[contains(text(),'Question')]//following::a[2]") public WebElement Edit2;
		@FindBy(xpath = "//a[contains(text(),'Presentation with Voice Over Video (PVO)')]//following::a[5]") public WebElement addQuestionBtn;
	
		public void addPVOData(String videoURL, String posterURL, String videoName, String videoDescription) {
			this.PVOTabBtn.click();
			waitForElementToLoad(this.uploadVideoBtn);
			this.uploadVideoBtn.sendKeys(videoURL);
			this.uploadPosterBtn.sendKeys(posterURL);
			this.PVOVideoName.sendKeys(videoName);
			this.PVOVideoDescription.sendKeys(videoDescription);
			this.updatePVOBtn.click();			
		}
			
		public void addPVOScoreBasedCheck() {
				addQuestionBtn.click();
		}
		
		public void PVOScoreBasedPostQns(boolean equalWeightageCheck, String minimumPass) {
			sleep(2000);
			System.out.println("POST SCOREBASED START");
			sleep(2000);
			this.scoreQuizActivationSlider.click();
			
			sleep(2000);
			/*if(equalWeightageCheck)
			{
				equalWeightageCheckbox.click();
			}
			else
			{
				System.out.println("not equal weightage");	
			}*/
			sleep(2000);
			this.minimumPassField.clear();		
			sleep(2000);
			this.minimumPassField.sendKeys(minimumPass);
			this.equalWeightageCheckbox.click();
			sleep(2000);
		}
		
		public void editQns() {
			Edit1.click();
		}
		public void updatePVO() {
			this.updatePVOBtn.click();
		}

		public PVOPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(this.driver, this);
		}
		private static void sleep(long m) {
			try {
				Thread.sleep(m);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
