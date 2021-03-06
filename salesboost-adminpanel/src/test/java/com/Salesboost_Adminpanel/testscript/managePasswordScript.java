package com.Salesboost_Adminpanel.testscript;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.ManagePassword;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;
import com.Salesboost_Adminpanel.testdata.ManagePasswordData;

public class managePasswordScript extends BaseClass{

	ManagePassword managePassword;
	DashboardObject dashboardObj;
	TestDataImport tdImport;
	ManagePasswordData managePasswordData;
	SignInObject signInObject;
	
	String getTextboxData="";
	String[] fullName = new String[2];
	String[] testData;
	
	@Test(priority = 0)
	public void validEmailGeneratePassword () {
		try {
			log.info("USERS->MANAGE PASSWORD: validEmailGeneratePassword");
			actualstring = " "; expectedstring = "";
			eTest = eReports.createTest("validEmailGeneratePassword");
			eTest.assignCategory("GeneratePassword");
			
			dashboardObj.usersTab.click();
			dashboardObj.managePassword.click();
			ManagePasswordData managePasswordData = new ManagePasswordData();
			
			testData = managePasswordData.getEmail(this.tdImport);
			
			waitForElementToLoad(managePassword.Email);
			managePassword.managePassword(testData[0]);			
			waitForElementToLoad(managePassword.text);

			waitForElementToLoad(managePassword.button);
			managePassword.button.click();
			expectedstring = "Generate Password";
			actualstring = managePassword.valid.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("validEmailGeneratePassword Failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
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
			managePassword = new ManagePassword(driver);
			tdImport.readExcel("ManagePasswords");
				
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
