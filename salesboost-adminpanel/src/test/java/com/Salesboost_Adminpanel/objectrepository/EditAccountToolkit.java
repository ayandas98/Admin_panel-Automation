/*
package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class EditAccountToolkit extends BaseClass {
	
	WebDriver driver;
	EditAccount editAccount;
	
	@FindBy (xpath ="//h2[contains(text(),'Edit Custom & Default Tool Kit')]") public WebElement header;
	@FindBy (xpath ="//input[@class='select-all-list kit']") public WebElement selectall;
	@FindBy (xpath ="//body//form[@id='salesBoostToolKitDiv']//li//li[2]//label[1]//input[1]") public WebElement closingTechniques;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//li[3]//label[1]//input[1]") public WebElement part1;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//li[4]//label[1]//input[1]") public WebElement part2;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//li[5]//label[1]//input[1]") public WebElement objections;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//li[6]//label[1]//input[1]") public WebElement goal;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//li[7]//label[1]//input[1]") public WebElement rapport;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//li[8]//label[1]//input[1]") public WebElement creative;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//li[9]//label[1]//input[1]") public WebElement upselling;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//li[10]//label[1]//input[1]") public WebElement qualifyingneeds;
	@FindBy (xpath ="//form[@id='salesBoostToolKitDiv']//input[@name='submit']") public WebElement save ;
	

	public EditAccountToolkit (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void editAccountToolkit( ) {
		
		try {
			log.info("edit account toolkit");
			editAccount.toolkit.click();
			waitForElementToLoad (header);
			this.selectall.click();
			this.closingTechniques.click();
			this.part1.click();
			this.part2.click();
			this.objections.click();
			this.goal.click();
			this.rapport.click();
			this.creative.click();
			this.upselling.click();
			this.qualifyingneeds.click();
			this.save.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/
