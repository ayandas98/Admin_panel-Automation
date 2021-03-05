package com.Salesboost_Adminpanel.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesboost_Adminpanel.baseclass.BaseClass;



public class AssociatedFilesPage extends BaseClass{
	WebDriver driver;

	
	@FindBy(xpath = "//a[contains(text(),'Associated Files')]")
	public WebElement AssociatedFileTabBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Associated Files')]//following::input[1]")
	public WebElement AssociatedFileUpdateAddBtn;
	
	@FindBy(xpath = "//input[@name='file']")
	public WebElement AssociatedFileUploadFile;
	
	@FindBy(xpath = "//input[@id='File_LinkText']")
	public WebElement AssociatedFileLinkText;
	
	@FindBy(xpath = "//a[contains(text(),'Add File')]")
	public WebElement addFileBigBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Associated Files')]//following::input[1]")
	public WebElement addFileSmallBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Associated Files')]//following::input[2]")
	public WebElement fileUploadBtn;
	
	@FindBy(xpath = "//input[@id='File_LinkText']")
	public WebElement linkText;
	@FindBy(xpath = "//th[contains(text(),'Link Text')]//following::td[2]")
	public WebElement linkTextVerification;
	@FindBy(xpath = "//a[contains(text(),'Edit File')]")
	public WebElement editFileBtn;
	@FindBy(xpath = "//th[contains(text(),'Link Text')]//following::input[1]")
	public WebElement deleteFileBtn;
	
	
	
	
	public AssociatedFilesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void addFileButtonTest() {
		this.AssociatedFileTabBtn.click();
		waitForElementToLoad(addFileBigBtn);
		this.addFileBigBtn.click();
	}
	
	public void editAssociatedFilesTest(String fileURL, String linktext) {
	System.out.println("edit files test start");
		this.fileUploadBtn.sendKeys(fileURL);
		this.linkText.clear();
		this.linkText.sendKeys(linktext);
		this.addFileSmallBtn.click();
		
		
	}
	public void associatedFileIncompleteDetailsTest(String fileURL) {
		System.out.println("incompkete test start");
		this.fileUploadBtn.sendKeys(fileURL);
		this.linkText.sendKeys("");
		this.addFileSmallBtn.click();
	}
	public void editAssociatedFiles(String fileURL,String EditLinkString) {
		this.AssociatedFileTabBtn.click();
		this.editFileBtn.click();
		waitForElementToLoad(linkText);
		this.linkText.sendKeys(EditLinkString);
		this.fileUploadBtn.sendKeys(fileURL);
		this.addFileSmallBtn.click();
		
	}
	public void deleteAssociatedFiles() {
		this.AssociatedFileTabBtn.click();
		this.deleteFileBtn.click();
		
	}
	
}