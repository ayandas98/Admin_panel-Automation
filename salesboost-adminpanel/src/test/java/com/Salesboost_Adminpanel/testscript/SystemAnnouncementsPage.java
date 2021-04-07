package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddSystemAnnouncementsObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditSystemAnnouncements;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.objectrepository.SystemAnnouncementsObject;
import com.Salesboost_Adminpanel.testdata.SystemAnnouncementData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class SystemAnnouncementsPage extends BaseClass{

	SignInObject signInObject;
	DashboardObject dashboardObj;
	SystemAnnouncementsObject systemAnnouncementsObj;
	EditSystemAnnouncements editSystemAnnouncementsObj;
	AddSystemAnnouncementsObject addSystemAnnouncementObj;
	SystemAnnouncementData systemAnnouncementData;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] testdata;
	
	@Test(priority = 0)
	public void validAddSystemAnnouncements () {
		try {
				log.info("system announcements add new system announcements");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid add active announcement");
				eTest.assignCategory("system announcement");
				
				SystemAnnouncementData systemAnnouncementData = new SystemAnnouncementData();
				testdata = systemAnnouncementData.getAddSystemAnnouncementData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.systemAnnouncement.click();
				
				waitForElementToLoad(systemAnnouncementsObj.addPost);
				systemAnnouncementsObj.addPost.click();
				waitForElementToLoad(addSystemAnnouncementObj.confText);
				
				addSystemAnnouncementObj.AddSystemAnnouncements(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7]);
				waitForElementToLoad (addSystemAnnouncementObj.postActive);
				waitForElementToLoad (addSystemAnnouncementObj.addButton);
				addSystemAnnouncementObj.postActive.click();
				addSystemAnnouncementObj.addButton.click();	
				Thread.sleep(2000);
				actualstring = addSystemAnnouncementObj.actualVerificationText.getText() ;
				expectedstring = testdata[0];				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid system announcement: post adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 1)
	public void validSystemAnnouncementListing () {
		try {
				log.info("valid System announcements listing");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid announcement listing");
				eTest.assignCategory("system announcement");

				// valid posts selection
				SystemAnnouncementData systemAnnouncementData = new SystemAnnouncementData();
				testdata = systemAnnouncementData.getSystemAnnouncementData(tdImport);
				
				dashboardObj.contentTab.click();
				dashboardObj.systemAnnouncement.click();
				waitForElementToLoad(systemAnnouncementsObj.addPost);
				systemAnnouncementsObj.systemAnnouncements(testdata[0], testdata[1]);
				Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid system announcements listing failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}

	@Test(priority = 2)
	public void validDeleteAnnouncement () {
		try {
				log.info("valid Delete announcement");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify delete announcement");
				eTest.assignCategory("system announcement");
				/*
				// add user	
				SystemAnnouncementData systemAnnouncementData = new SystemAnnouncementData();
				testdata = systemAnnouncementData.getAddSystemAnnouncementData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.systemAnnouncement.click();
				
				waitForElementToLoad(systemAnnouncementsObj.addPost);
				systemAnnouncementsObj.addPost.click();
				waitForElementToLoad(addSystemAnnouncementObj.confText);
				
				addSystemAnnouncementObj.AddSystemAnnouncements(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7]);
				waitForElementToLoad (addSystemAnnouncementObj.postActive);
				waitForElementToLoad (addSystemAnnouncementObj.addButton);
				addSystemAnnouncementObj.addButton.click();	
				Thread.sleep(2000);
				*/	
				//search track from tracks list as there is no specified search button this step integrated with edit
				SystemAnnouncementData systemAnnouncementData1 = new SystemAnnouncementData();
				testdata = systemAnnouncementData1.getSystemAnnouncementData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.systemAnnouncement.click();
				waitForElementToLoad(systemAnnouncementsObj.addPost);
				systemAnnouncementsObj.systemAnnouncements(testdata[0], testdata[1]);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//delete the user if user found
				
				Thread.sleep(1000);
				waitForElementToLoad (editSystemAnnouncementsObj.deleteButton);
				editSystemAnnouncementsObj.deleteButton.click();
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
				expectedstring = "Post Title";
				actualstring = systemAnnouncementsObj.valid.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}
	
	@Test(priority = 3)
	public void validEditAnnouncement () {
		try {
				log.info("valid edit system announcement post");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update announcement");
				eTest.assignCategory("system announcement");
							
				// add post	
				SystemAnnouncementData systemAnnouncementData = new SystemAnnouncementData();
				testdata = systemAnnouncementData.getAddSystemAnnouncementData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.systemAnnouncement.click();
				
				waitForElementToLoad(systemAnnouncementsObj.addPost);
				systemAnnouncementsObj.addPost.click();
				waitForElementToLoad(addSystemAnnouncementObj.confText);
				
				addSystemAnnouncementObj.AddSystemAnnouncements(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7]);
				waitForElementToLoad (addSystemAnnouncementObj.postActive);
				waitForElementToLoad (addSystemAnnouncementObj.addButton);
				addSystemAnnouncementObj.addButton.click();	
				Thread.sleep(2000);
					
				//search post from list as there is no specified search button this step integrated with edit
				SystemAnnouncementData systemAnnouncementData1 = new SystemAnnouncementData();
				testdata = systemAnnouncementData1.getSystemAnnouncementData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.systemAnnouncement.click();
				waitForElementToLoad(systemAnnouncementsObj.addPost);
				systemAnnouncementsObj.systemAnnouncements(testdata[0], testdata[1]);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the post if user found
				SystemAnnouncementData systemAnnouncementData2 = new SystemAnnouncementData();
				testdata = systemAnnouncementData2.getEditSystemAnnouncementData(tdImport);
			
				editSystemAnnouncementsObj.EditAnnouncements(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6], testdata[7], testdata[8], testdata[9], testdata[10]);
				Thread.sleep(2000);
				waitForElementToLoad (editSystemAnnouncementsObj.postActive);
				waitForElementToLoad (editSystemAnnouncementsObj.updateButton);
				editSystemAnnouncementsObj.postActive.click();
				editSystemAnnouncementsObj.updateButton.click();
				Thread.sleep(1000);
				actualstring = editSystemAnnouncementsObj.actualVerificationText.getText() ;
				expectedstring = testdata[0];
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit system announcement failed");
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
			systemAnnouncementsObj = new SystemAnnouncementsObject(driver);
			editSystemAnnouncementsObj = new EditSystemAnnouncements(driver);
			addSystemAnnouncementObj = new AddSystemAnnouncementsObject(driver);
			tdImport.readExcel("SystemAnnouncementData");
				
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
