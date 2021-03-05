package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddLeadershipToolObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.DuplicateLeadershipObject;
import com.Salesboost_Adminpanel.objectrepository.EditLeadershipToolObject;
import com.Salesboost_Adminpanel.objectrepository.LeadershipToolObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.LeadershipToolData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class LeadershipObjectPage extends BaseClass{

	SignInObject signInObject;
	DashboardObject dashboardObj;
	LeadershipToolObject leadershipObj;
	AddLeadershipToolObject addToolObj;
	EditLeadershipToolObject editToolObj;
	DuplicateLeadershipObject duplicateObj;
	LeadershipToolData leadershipData;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] testdata;
	/*
	@Test(priority = 0)
	public void validAddTools () {
		try {
				log.info("add new tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid add new tools");
				eTest.assignCategory("leadership tools");
				
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getAddLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addToolObj.confText);
				
				addToolObj.addLeadershipTool(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addToolObj.addButton);
				addToolObj.addButton.click();	
				Thread.sleep(2000);
				actualstring =addToolObj.actualVerificationText.getText();
				expectedstring = testdata[0];
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid leadership tool adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	*/
	@Test(priority = 1)
	public void validActiveStatusAddTools () {
		try {
				log.info("Tracks - active status add new tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid add new tools");
				eTest.assignCategory("leadership tools");
				
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getAddLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addToolObj.confText);
				
				addToolObj.addLeadershipTool(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addToolObj.kitStatus);
				waitForElementToLoad (addToolObj.addButton);
				addToolObj.kitStatus.click();
				addToolObj.addButton.click();	
				Thread.sleep(2000);
				actualstring =addToolObj.actualVerificationText.getText();
				expectedstring = testdata[0];
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid active status leadership tool adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 2)
	public void validtoolsselection () {
		try {
				log.info("valid tools selection");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid  search tool");
				eTest.assignCategory("leadership tools");
		/*		
				// add tool
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getAddLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addToolObj.confText);
				
				addToolObj.addLeadershipTool(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addToolObj.addButton);
				addToolObj.addButton.click();	
				Thread.sleep(2000);
			*/	
				// valid tools selection
				LeadershipToolData leadershipData1 = new LeadershipToolData();
				testdata = leadershipData1.getLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.leadershipTools(testdata[0], testdata[1]);
				Thread.sleep(500);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid selection failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}

	@Test(priority = 3)
	public void validToolDelete () {
		try {
				log.info("valid tools delete");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid delete tool");
				eTest.assignCategory("leadership tools");
				/*
				// add tool
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getAddLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addToolObj.confText);
				
				addToolObj.addLeadershipTool(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addToolObj.addButton);
				addToolObj.addButton.click();	
				Thread.sleep(2000);
				*/
				// search tool
				LeadershipToolData leadershipData1 = new LeadershipToolData();
				testdata = leadershipData1.getLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.leadershipTools(testdata[0], testdata[1]);

				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				// valid tracks selection then once selected delete
				Thread.sleep(1000);
				System.out.println(testdata[1]);
				waitForElementToLoad(editToolObj.deleteButton);
				editToolObj.deleteButton.click();
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
				expectedstring = "Tool Kit Name";
				actualstring = leadershipObj.valid.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}
	
	@Test(priority = 4)
	public void validEditTools () {
		try {
				log.info("valid edit tools");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid update tool");
				eTest.assignCategory("leadership tools");
				
				// add track	
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getAddLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.addButton.click();
				waitForElementToLoad(addToolObj.confText);
				
				addToolObj.addLeadershipTool(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addToolObj.addButton);
				addToolObj.addButton.click();	
				Thread.sleep(2000);			
					
				//search tool
				LeadershipToolData leadershipData1 = new LeadershipToolData();
				testdata = leadershipData1.getLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.leadershipTools(testdata[0], testdata[1]);

				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the tool if found
				LeadershipToolData leadershipData2 = new LeadershipToolData();
				testdata = leadershipData2.getEditLeadershipToolsData(tdImport);
				expectedArray.add(testdata[0]);
				expectedArray.add(testdata[1]);
				
				editToolObj.editleadershipTool(testdata[0], testdata[1], testdata[2]);
				Thread.sleep(2000);
				waitForElementToLoad (editToolObj.updateButton);
				editToolObj.updateButton.click();
				Thread.sleep(1000);
				expectedstring = testdata[0];
				actualstring =editToolObj.actualVerificationText.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	} 
	

		
	@Test(priority = 5)
	public void validAddDuplicateTools () {
		try {
				log.info("new duplicate tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add duplicate tool");
				eTest.assignCategory("leadership tools");
				
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getDuplicateLeadershipToolData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.duplicateButton.click();
				waitForElementToLoad(duplicateObj.confText);
				
				duplicateObj.duplicateLeadership(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (duplicateObj.dupButton);
				duplicateObj.dupButton.click();	
				Thread.sleep(2000);
				actualstring = kitNameText(testdata[0]).getText();
				expectedstring = testdata[0];				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid duplicate leadership tool adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 6)
	public void validCancelAddDuplicateTools () {
		try {
				log.info("Tools -cancel add new duplicate tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("cancel adding duplicate tools");
				eTest.assignCategory("duplicate tools");
				
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getAddLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.duplicateButton.click();
				waitForElementToLoad(duplicateObj.confText);
				
				duplicateObj.duplicateLeadership(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (duplicateObj.closeButton);
				Thread.sleep(2000);
				duplicateObj.closeButton.click();	
				
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid cancel duplicate leadership tool adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}
	
	public static WebElement kitNameText(String kitName)
	{
	    WebElement kitVerificationText =  driver.findElement(By.xpath("//a[contains(text(),'"+kitName+"')]"));
	    return kitVerificationText;
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
			addToolObj = new AddLeadershipToolObject(driver);
			editToolObj = new EditLeadershipToolObject(driver);
			duplicateObj = new DuplicateLeadershipObject(driver);
			tdImport.readExcel("LeadershipToolData");
				
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
