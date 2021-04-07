package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddLeadershipTips;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditLeadershipTips;
import com.Salesboost_Adminpanel.objectrepository.LeadershipTipsObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.LeadershipTipsData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class LeadershipTipsPage extends BaseClass{

	SignInObject signInObject;
	DashboardObject dashboardObj;
	LeadershipTipsObject leadershipTipsObj;
	AddLeadershipTips addLeadershipTips;
	EditLeadershipTips editLeadershipTips;
	LeadershipTipsData leadershipTipsData;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] testdata;
	
	@Test(priority = 0)
	public void validAddLeadershipTips () {
		try {
				log.info("leadership tips add new tips");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid add leadership tip");
				eTest.assignCategory("leadership tips");
				
				LeadershipTipsData leadershipTipsData = new LeadershipTipsData();
				testdata = leadershipTipsData.getAddLeadershipTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTips.click();
				
				waitForElementToLoad(leadershipTipsObj.addTips);
				leadershipTipsObj.addTips.click();
				waitForElementToLoad(addLeadershipTips.confText);
				
				addLeadershipTips.addTips(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6]);
				waitForElementToLoad (addLeadershipTips.tipActive);
				waitForElementToLoad (addLeadershipTips.addButton);
				addLeadershipTips.tipActive.click();
				addLeadershipTips.addButton.click();	
				Thread.sleep(2000);
				actualstring =addLeadershipTips.actualVerificationText.getText();
				expectedstring = testdata[0];
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid leadership tips: post adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 1)
	public void validLeadershipTipsListing () {
		try {
				log.info("valid leadership tips listing");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid leadership tip listing");
				eTest.assignCategory("leadership tips");

				// valid tracks selection
				LeadershipTipsData leadershipTipsData = new LeadershipTipsData();
				testdata = leadershipTipsData.getLeadershipTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTips.click();

				waitForElementToLoad(leadershipTipsObj.addTips);
				leadershipTipsObj.leadershipObject(testdata[0], testdata[1]);
				Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid system announcements listing failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	@Test(priority = 2)
	public void validDeleteLeadershipTip () {
		try {
				log.info("valid delete leadership tip");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid delete leadership tip");
				eTest.assignCategory("leadership tips");
		/*		
				// add user	
				LeadershipTipsData leadershipTipsData = new LeadershipTipsData();
				testdata = leadershipTipsData.getAddLeadershipTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTips.click();
				
				waitForElementToLoad(leadershipTipsObj.addTips);
				leadershipTipsObj.addTips.click();
				waitForElementToLoad(addLeadershipTips.confText);
				
				addLeadershipTips.addTips(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6]);
				waitForElementToLoad (addLeadershipTips.addButton);
				addLeadershipTips.addButton.click();	
				Thread.sleep(2000);
	*/								
				//search track from tracks list as there is no specified search button this step integrated with edit
				LeadershipTipsData leadershipTipsData1 = new LeadershipTipsData();
				testdata = leadershipTipsData1.getLeadershipTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTips.click();

				waitForElementToLoad(leadershipTipsObj.addTips);
				leadershipTipsObj.leadershipObject(testdata[0], testdata[1]);
				Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//delete the user if user found
				Thread.sleep(1000);
				waitForElementToLoad (editLeadershipTips.deleteButton);
				editLeadershipTips.deleteButton.click();	
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
				expectedstring = "Leadership Tips Title";
				actualstring = leadershipTipsObj.valid.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete leadership tip failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}

	@Test(priority = 4)
	public void validEditLeadershipTip () {
		try {
				log.info("valid edit leadership tip");				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid update leadership tip");
				eTest.assignCategory("leadership tips");
				
				// add user	
				LeadershipTipsData leadershipTipsData = new LeadershipTipsData();
				testdata = leadershipTipsData.getAddLeadershipTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTips.click();
				
				waitForElementToLoad(leadershipTipsObj.addTips);
				leadershipTipsObj.addTips.click();
				waitForElementToLoad(addLeadershipTips.confText);
				
				addLeadershipTips.addTips(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6]);
				waitForElementToLoad (addLeadershipTips.addButton);
				addLeadershipTips.addButton.click();	
				Thread.sleep(2000);
					
				//search track from tracks list as there is no specified search button this step integrated with edit
				LeadershipTipsData leadershipTipsData1 = new LeadershipTipsData();
				testdata = leadershipTipsData1.getLeadershipTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.leadershipTips.click();

				waitForElementToLoad(leadershipTipsObj.addTips);
				leadershipTipsObj.leadershipObject(testdata[0], testdata[1]);
				Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the user if user found
				LeadershipTipsData leadershipTipsData2 = new LeadershipTipsData();
				testdata = leadershipTipsData2.getEditLeadershipTipsData(tdImport);
			
				editLeadershipTips.editTips(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7], testdata[8]);
				waitForElementToLoad (editLeadershipTips.tipActive);
				waitForElementToLoad (editLeadershipTips.updateButton);
				editLeadershipTips.tipActive.click();
				editLeadershipTips.updateButton.click();
				Thread.sleep(1000);
				expectedstring = testdata[0];
				actualstring = editLeadershipTips.actualVerificationText.getText();				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit leadership tip failed");
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
			leadershipTipsObj = new LeadershipTipsObject(driver);
			editLeadershipTips = new EditLeadershipTips(driver);
			addLeadershipTips = new AddLeadershipTips(driver);
			tdImport.readExcel("LeadershipTipData");
				
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

