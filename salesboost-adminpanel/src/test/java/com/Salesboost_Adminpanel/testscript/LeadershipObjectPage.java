package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
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
import com.Salesboost_Adminpanel.testdata.TracksData;
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
	
	@Test(priority = 0)
	public void validAddTools () {
		try {
				log.info("Tracks -add new tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
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
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid leadership tool adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}
	
	@Test(priority = 1)
	public void validActiveStatusAddTools () {
		try {
				log.info("Tracks - active status add new tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
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
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid active status leadership tool adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}
	
	@Test(priority = 2)
	public void validtoolsselection () {
		try {
				log.info("valid tools selection");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify search");
				eTest.assignCategory("search user");

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
	public void validEditTools () {
		try {
				log.info("valid edit tools");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update user");
				eTest.assignCategory("update user");
				
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
				wait(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the tool if found
				TracksData tracksData2 = new TracksData();
				testdata = tracksData2.getTracksData(tdImport);
				expectedArray.add(testdata[0]);
				expectedArray.add(testdata[1]);
				expectedArray.add(testdata[2]);
				
				editToolObj.editleadershipTool(testdata[0], testdata[1], testdata[2]);
				Thread.sleep(2000);
				waitForElementToLoad (editToolObj.updateButton);
				editToolObj.updateButton.click();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
	} 
	
	@Test(priority = 4)
	public void validToolDelete () {
		try {
				log.info("valid tools delete");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify search");
				eTest.assignCategory("search user");

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
				// search tool
				LeadershipToolData leadershipData1 = new LeadershipToolData();
				testdata = leadershipData1.getLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.leadershipTools(testdata[0], testdata[1]);
				wait(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				// valid tracks selection then once selected delete
				Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				waitForElementToLoad(editToolObj.deleteButton);
				editToolObj.deleteButton.click();
				Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	@Test(priority = 5)
	public void validAddDuplicateTools () {
		try {
				log.info("Tracks -add new duplicate tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getAddLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.duplicateButton.click();
				waitForElementToLoad(duplicateObj.confText);
				
				duplicateObj.duplicateLeadership(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (duplicateObj.dupButton);
				duplicateObj.dupButton.click();	
				Thread.sleep(2000);
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid duplicate leadership tool adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}
	
	@Test(priority = 6)
	public void validCancelAddDuplicateTools () {
		try {
				log.info("Tracks -cancel add new duplicate tools");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
				LeadershipToolData leadershipData = new LeadershipToolData();
				testdata = leadershipData.getAddLeadershipToolsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTools.click();
				
				waitForElementToLoad(leadershipObj.addButton);
				leadershipObj.duplicateButton.click();
				waitForElementToLoad(duplicateObj.confText);
				
				duplicateObj.duplicateLeadership(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (duplicateObj.closeButton);
				duplicateObj.closeButton.click();	
				Thread.sleep(2000);
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid cancel duplicate leadership tool adding failed");
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
			leadershipObj = new LeadershipToolObject(driver);
			addToolObj = new AddLeadershipToolObject(driver);
			editToolObj = new EditLeadershipToolObject(driver);
			duplicateObj = new DuplicateLeadershipObject(driver);
			tdImport.readExcel("LoginData");
				
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