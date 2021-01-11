package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AccountHoldersObject;
import com.Salesboost_Adminpanel.objectrepository.AddNewAccountObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditAccount;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.AccountHoldersData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class accountHoldersPage extends BaseClass{

	SignInObject signInObject;
	DashboardObject dashboardObj;
	AccountHoldersObject accountHoldersObj;
	AddNewAccountObject addNewAccountObj;
	EditAccount editAccountObj;
	AccountHoldersData accountHoldersDataObj;
	TestDataImport tdImport;
	String getTextboxData="";
	String[] testdata;

	@Test(priority = 0)
	public void validaddaccount () {
		try {
				log.info("Account holders page-add new account");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
				AccountHoldersData accountHoldersDataObj = new AccountHoldersData();
				testdata = accountHoldersDataObj.getAddAccountData(tdImport);
				expectedArray.add(testdata[0]);//name
				expectedArray.add(testdata[1]);//list 
				expectedArray.add(testdata[2]);//choice
				expectedArray.add(testdata[3]);//f name
				expectedArray.add(testdata[4]);//l name
				expectedArray.add(testdata[5]);// email
				
				dashboardObj.usersTab.click();
				dashboardObj.accountHolders.click();
				
				waitForElementToLoad(accountHoldersObj.addNewAccount);
				accountHoldersObj.addNewAccount.click();
				waitForElementToLoad(addNewAccountObj.header);
				
				addNewAccountObj.addNewAccount(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5]);
				waitForElementToLoad (addNewAccountObj.addAccount);
				addNewAccountObj.addAccount.click();	
				Thread.sleep(2000);
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid account adding failed");
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
	/*
				// add user
				dashboardObj.usersTab.click();
				dashboardObj.accountHolders.click();
				waitForElementToLoad(accountHoldersObj.addNewAccount);
				accountHoldersObj.addNewAccount.click();
				waitForElementToLoad(addNewAccountObj.header);
				AccountHoldersData accountHoldersDataObj = new AccountHoldersData();
				testdata = accountHoldersDataObj.getAddAccountData(tdImport);
				addNewAccountObj.addNewAccount(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5]);
				waitForElementToLoad (addNewAccountObj.addAccount);
				addNewAccountObj.addAccount.click();	
	*/							
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
	
	@Test(priority = 2)
	public void validUserUpdate () {
		try {
				log.info("valid edit/update user");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update user");
				eTest.assignCategory("update user");
	/*
				// add user
				dashboardObj.usersTab.click();
				dashboardObj.accountHolders.click();
				waitForElementToLoad(accountHoldersObj.addNewAccount);
				accountHoldersObj.addNewAccount.click();
				waitForElementToLoad(addNewAccountObj.header);
				AccountHoldersData accountHoldersDataObj = new AccountHoldersData();
				testdata = accountHoldersDataObj.getAddAccountData(tdImport);
				addNewAccountObj.addNewAccount(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5]);
				waitForElementToLoad (addNewAccountObj.addAccount);
				addNewAccountObj.addAccount.click();
	*/	
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
				testdata = accountHoldersDataObj2.getEditAccountData(tdImport);
				expectedArray.add(testdata[0]);
				expectedArray.add(testdata[1]);
				expectedArray.add(testdata[2]);
				expectedArray.add(testdata[3]);
				
				editAccountObj.editAccount(testdata[0], testdata[1], testdata[2], testdata[3]);
				Thread.sleep(2000);
				waitForElementToLoad (editAccountObj.update);
				editAccountObj.update.click();
			
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
			addNewAccountObj = new AddNewAccountObject(driver);
			editAccountObj = new EditAccount(driver);
			tdImport.readExcel("AccountHoldersData");
				
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	@AfterClass
	public void logout() {
		try {
			log.info("Sign In: logout");
			waitForElementToLoad(dashboardObj.Admin);
			waitIfElementClickIsIntercepted(dashboardObj.logOut, "click", "");
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
