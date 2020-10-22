package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AccountHoldersObject;
import com.Salesboost_Adminpanel.objectrepository.AddNewWhitelabelAccountObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditWhitelabelAccountObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.AccountHoldersData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class WhitelabelAccountHoldersPage extends BaseClass {

	SignInObject signInObject;
	DashboardObject dashboardObj;
	AccountHoldersObject accountHoldersObj;
	AddNewWhitelabelAccountObject addNewWhitelabelAccountObj;
	EditWhitelabelAccountObject editWhitelabelAccountObj;
	AccountHoldersData accountHoldersDataObj;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] testdata;
	
	@Test(priority = 0)
	public void validaddwhitlabelaccount () {
		try {
				log.info("Account holders page-add new whitelabel account");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
				AccountHoldersData accountHoldersDataObj = new AccountHoldersData();
				testdata = accountHoldersDataObj.getAddWhitelabelAccountData(tdImport);
				
				dashboardObj.usersTab.click();
				dashboardObj.accountHolders.click();
				
				waitForElementToLoad(accountHoldersObj.addNewAccount);
				accountHoldersObj.addNewAccount.click();
				waitForElementToLoad(addNewWhitelabelAccountObj.header);
				
				addNewWhitelabelAccountObj.addNewWhitelabelAccount(testdata[0], testdata[1] , testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7], testdata[8], testdata[9], testdata[10], testdata[11], testdata[12], testdata[13], testdata[14]);
				waitForElementToLoad (addNewWhitelabelAccountObj.addAccount);
				addNewWhitelabelAccountObj.addAccount.click();	
				Thread.sleep(2000);
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid new whitelabel account add failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	} 
	
	@Test(priority = 1)
	public void validsearch () {
		try {
				log.info("valid search user");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify search");
				eTest.assignCategory("search user");

				
				// add user
				AccountHoldersData accountHoldersDataObj = new AccountHoldersData();
				testdata = accountHoldersDataObj.getAddWhitelabelAccountData(tdImport);
				
				dashboardObj.usersTab.click();
				dashboardObj.accountHolders.click();
				
				waitForElementToLoad(accountHoldersObj.addNewAccount);
				accountHoldersObj.addNewAccount.click();
				waitForElementToLoad(addNewWhitelabelAccountObj.header);
				
				addNewWhitelabelAccountObj.addNewWhitelabelAccount(testdata[0], testdata[1] , testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7], testdata[8], testdata[9], testdata[10], testdata[11], testdata[12], testdata[13], testdata[14]);
				waitForElementToLoad (addNewWhitelabelAccountObj.addAccount);
				addNewWhitelabelAccountObj.addAccount.click();	
				Thread.sleep(2000);
				
				
				// validate search by searching for added user
				
				AccountHoldersData accountHoldersDataObj1 = new AccountHoldersData();
				testdata = accountHoldersDataObj1.getAccountHoldersData(tdImport);
				dashboardObj.usersTab.click();
				dashboardObj.accountHolders.click();
				waitForElementToLoad(accountHoldersObj.accountSearch);
				waitForElementToLoad(accountHoldersObj.searchButton);
				accountHoldersObj.accountHolders(testdata[0], testdata[1]);
				System.out.println(testdata);
				accountHoldersObj.searchButton.click();
				Thread.sleep(1000);
				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid search failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	
	@Test(priority = 0)
	public void validUserUpdate () {
		try {
				log.info("valid edit/update user");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update user");
				eTest.assignCategory("update user");
				
				// add user
				AccountHoldersData accountHoldersDataObj = new AccountHoldersData();
				testdata = accountHoldersDataObj.getAddWhitelabelAccountData(tdImport);
				
				dashboardObj.usersTab.click();
				dashboardObj.accountHolders.click();
				
				waitForElementToLoad(accountHoldersObj.addNewAccount);
				accountHoldersObj.addNewAccount.click();
				waitForElementToLoad(addNewWhitelabelAccountObj.header);
				
				addNewWhitelabelAccountObj.addNewWhitelabelAccount(testdata[0], testdata[1] , testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7], testdata[8], testdata[9], testdata[10], testdata[11], testdata[12], testdata[13], testdata[14]);
				waitForElementToLoad (addNewWhitelabelAccountObj.addAccount);
				addNewWhitelabelAccountObj.addAccount.click();	
				Thread.sleep(2000);
				
				//search user
				AccountHoldersData accountHoldersDataObj1 = new AccountHoldersData();
				testdata = accountHoldersDataObj1.getAccountHoldersData(tdImport);
				dashboardObj.usersTab.click();
				dashboardObj.accountHolders.click();
				waitForElementToLoad(accountHoldersObj.accountSearch);
				waitForElementToLoad(accountHoldersObj.searchButton);
				accountHoldersObj.accountHolders(testdata[0], testdata[1]);
				accountHoldersObj.searchButton.click();
				
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the user if user found
				AccountHoldersData accountHoldersDataObj2 = new AccountHoldersData();
				testdata = accountHoldersDataObj2.getEditWhitelabelAccountData(tdImport);
				
				editWhitelabelAccountObj.editWhitelabelAccount(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7], testdata[8], testdata[9], testdata[10], testdata[11], testdata[12]);
				Thread.sleep(2000);
				waitForElementToLoad (editWhitelabelAccountObj.update);
				editWhitelabelAccountObj.update.click();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid search failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
	} 
	
	@BeforeClass
	public void initialize() {
		try {
			log.info("Entered initialize method");
			tdImport = new TestDataImport();
			signInObject = new SignInObject(driver);
			waitForElementToLoad(signInObject.Email);
			signInObject.signIn("balu.kr@experionglobal.com", "qI85Jx$3");
			dashboardObj = new DashboardObject(driver);
			accountHoldersObj = new AccountHoldersObject(driver);
			addNewWhitelabelAccountObj = new AddNewWhitelabelAccountObject(driver);
			editWhitelabelAccountObj = new EditWhitelabelAccountObject(driver);
			tdImport.readExcel("LoginData");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	@AfterClass
	public void logout() {
		try {
			log.info("Sign In: logout");
			//waitForElementToLoad(dashboardObj.Admin);
			waitIfElementClickIsIntercepted(dashboardObj.logOut, "click", "");
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
