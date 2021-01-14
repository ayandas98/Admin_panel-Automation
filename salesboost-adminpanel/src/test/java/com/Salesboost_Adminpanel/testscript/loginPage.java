package com.Salesboost_Adminpanel.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.testdata.LoginData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;


public class loginPage extends BaseClass {
	
	SignInObject signInObject;
	DashboardObject dashboardObj;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] fullName = new String[2];
	String[] testdata;
	
	@Test(priority = 0)
	public void validEmailValidPassword() {
		try {
			log.info("Sign In: validEmailValidPassword");
			
			actualstring=""; expectedstring="";
			eTest = eReports.createTest("validEmailValidPassword Login");
			eTest.assignCategory("SignIn");
			LoginData loginData = new LoginData();
			testdata = loginData.getSignInData(this.tdImport);
			 
			signInObject.signIn(testdata[0], testdata[1]);
			waitForElementToLoad(dashboardObj.Admin);
			expectedstring = "SuperAdmin";
			actualstring = dashboardObj.Admin.getText();
			
		}
			catch (Exception e) {
			System.out.println("validEmailValidPassword Failed");
			e.printStackTrace();
			//log.info(e);
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
	dashboardObj = new DashboardObject(driver);
	tdImport.readExcel("LoginData");
	
	
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	
	@AfterClass
	public void logout() {
		try {
			log.info("Sign In: logout");
			waitIfElementClickIsIntercepted(dashboardObj.logOut, "click", "");
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	}
	
	

