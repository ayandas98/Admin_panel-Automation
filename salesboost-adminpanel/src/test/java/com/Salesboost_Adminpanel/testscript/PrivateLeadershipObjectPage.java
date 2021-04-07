package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddPrivateLeadershipObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditPrivateLeadershipObject;
import com.Salesboost_Adminpanel.objectrepository.LeadershipToolObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.PrivateLeadershipToolData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class PrivateLeadershipObjectPage extends BaseClass{

	SignInObject signInObject;
	DashboardObject dashboardObj;
	LeadershipToolObject leadershipObj;
	AddPrivateLeadershipObject addPrivateObj;
	EditPrivateLeadershipObject editPrivateObj;
	PrivateLeadershipToolData leadershipData;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] testdata;
	
	@Test(priority = 0)
	public void validAddTools () {
		try {
				log.info("Tracks -add new tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid add private tools");
				eTest.assignCategory("pvt leadership tool tips");
				
				PrivateLeadershipToolData leadershipData = new PrivateLeadershipToolData();
				testdata = leadershipData.getAddPrivateLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addPrivateObj.confText);
				
				addPrivateObj.addLeadershipTool(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addPrivateObj.addButton);
				addPrivateObj.addButton.click();	
				Thread.sleep(2000);
				actualstring = addPrivateObj.actualVerificationText.getText();
				expectedstring = testdata[0];				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid  private leadership tool adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
		
	@Test(priority = 1)
	public void validToolsListing () {
		try {
				log.info("valid tools listing");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid tools listing");
				eTest.assignCategory("pvt leadership tools tip");
				/*
				// add tool	
				PrivateLeadershipToolData leadershipData = new PrivateLeadershipToolData();
				testdata = leadershipData.getAddPrivateLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addPrivateObj.confText);
				addPrivateObj.addLeadershipTool(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addPrivateObj.kitStatus);
				waitForElementToLoad (addPrivateObj.addButton);
				addPrivateObj.kitStatus.click();
				addPrivateObj.addButton.click();	
				Thread.sleep(2000);
				*/
				// valid tools selection
				PrivateLeadershipToolData leadershipData1 = new PrivateLeadershipToolData();
				testdata = leadershipData1.getPrivateLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.leadershipTools(testdata[0], testdata[1]);
				Thread.sleep(500);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid listing failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	@Test(priority = 3)
	public void validToolDelete () {
		try {
				log.info("valid tools delete");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid delete private tools");
				eTest.assignCategory("pvt leadership tool tip");
		/*		
				// add tool
				PrivateLeadershipToolData leadershipData = new PrivateLeadershipToolData();
				testdata = leadershipData.getAddPrivateLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addPrivateObj.confText);
				
				addPrivateObj.addLeadershipTool(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addPrivateObj.kitStatus);
				waitForElementToLoad (addPrivateObj.addButton);
				addPrivateObj.kitStatus.click();
				addPrivateObj.addButton.click();	
				Thread.sleep(2000);   
			*/
				// search tool
				PrivateLeadershipToolData leadershipData1 = new PrivateLeadershipToolData();
				testdata = leadershipData1.getPrivateLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.leadershipTools(testdata[0], testdata[1]);
				Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				
				// valid tracks selection then once selected delete
				Thread.sleep(1000);
				waitForElementToLoad(editPrivateObj.deleteButton);
				editPrivateObj.deleteButton.click();
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
				expectedstring = "Add New Leadership Tool Kit";
				actualstring = leadershipObj.addButton.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}
	
	@Test(priority = 4)
	public void validEditTools () {
		try {
				log.info("valid edit tools");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid update private tools");
				eTest.assignCategory("pvt leadership tool tip");
				
				// add tool	

				PrivateLeadershipToolData leadershipData = new PrivateLeadershipToolData();
				testdata = leadershipData.getAddPrivateLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addPrivateObj.confText);
				
				addPrivateObj.addLeadershipTool(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addPrivateObj.kitStatus);
				waitForElementToLoad (addPrivateObj.addButton);
				addPrivateObj.kitStatus.click();
				addPrivateObj.addButton.click();	
				Thread.sleep(2000);
								
				//search tool
				PrivateLeadershipToolData leadershipData1 = new PrivateLeadershipToolData();
				testdata = leadershipData1.getPrivateLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.leadershipTools(testdata[0], testdata[1]);
				
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the tool if found
				PrivateLeadershipToolData leadershipData2 = new PrivateLeadershipToolData();
				testdata = leadershipData2.getEditPrivateLeadershipToolsData(tdImport);
				
				editPrivateObj.editleadershipTool(testdata[0], testdata[1], testdata[2], testdata[3]);
				Thread.sleep(2000);
				waitForElementToLoad (editPrivateObj.updateButton);
				editPrivateObj.updateButton.click();
				Thread.sleep(2000);
				expectedstring = testdata[0];
				actualstring =editPrivateObj.actualVerificationText.getText();
				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
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
			leadershipObj = new LeadershipToolObject(driver);
			addPrivateObj = new AddPrivateLeadershipObject(driver);
			editPrivateObj = new EditPrivateLeadershipObject(driver);
			tdImport.readExcel("PrivateLeadershipToolData");
				
		} 
		catch (Exception e) {
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
