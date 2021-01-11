package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
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
	/*
	@Test(priority = 0)
	public void validActivePostAddLeadershipTips () {
		try {
				log.info("leadership tips active posts add new tips");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add tips");
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
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid leadership tips: active post adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}
	*/
	/*
	@Test(priority = 1)
	public void validInActivePostAddLeadershipTips () {
		try {
				log.info("leadership tips In-active posts add new tips");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add tips");
				eTest.assignCategory("leadership tips");
				
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
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid leadership tips: active post adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}
	*/
	/*
	@Test(priority = 2)
	public void validLeadershipTipsSelection () {
		try {
				log.info("valid leadership tips selection");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify search");
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
			System.out.println("valid system announcements selection failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	*/
	
	@Test(priority = 3)
	public void validActivePostEditLeadershipTip () {
		try {
				log.info("valid active edit leadership tip");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update tips");
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
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid active edit leadership tip failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
	}
	
	/*
	@Test(priority = 4)
	public void validInActivePostEditLeadershipTip () {
		try {
				log.info("valid In-active edit leadership tip");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update tip");
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
				testdata = leadershipTipsData2.getLeadershipTipsData(tdImport);
			
				editLeadershipTips.editTips(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7], testdata[8]);
				Thread.sleep(2000);
				waitForElementToLoad (editLeadershipTips.updateButton);
				editLeadershipTips.updateButton.click();		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid In-active edit leadership tip failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
	}
	*/
	/*
	@Test(priority = 5)
	public void validDeleteLeadershipTip () {
		try {
				log.info("valid delete leadership tip");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify delete tips");
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
				
				//delete the user if user found
				Thread.sleep(1000);
				waitForElementToLoad (editLeadershipTips.deleteButton);
				editLeadershipTips.deleteButton.click();	
				driver.switchTo().alert().accept();	
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete leadership tip failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
	}
	*/
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

