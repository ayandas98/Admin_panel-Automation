package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class PrivateToolObject extends BaseClass{

	WebDriver driver;
	@FindBy(xpath ="//th[contains(text(),'Tool Kit Name')]") public WebElement confText;
	@FindBy(xpath ="//select[@id='filterList']") public WebElement listSelect;
	@FindBy(xpath ="//body/div[1]/div[1]/div[1]/form[2]/input[1]") public WebElement searchBar;
	@FindBy(xpath ="//body/div[1]/div[1]/div[1]/form[2]/input[2]") public WebElement searchButton;
	@FindBy(xpath ="//a[contains(text(),'Add New Leadership Tool Kit')]") public WebElement addButton;
	@FindBy(xpath ="//a[@id='duplicateKit']") public WebElement duplicateButton;
	
	public PrivateToolObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void leadershipTools (String sel, String name) {
		try {
			log.info("leadership tools");
			waitForElementToLoad(this.confText);
			this.listSelect.click();
			this.listSelect.sendKeys(sel);
			this.searchBar.clear();
			this.searchBar.sendKeys(name);
			this.searchButton.click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
