package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddPrivateTracksObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditPrivateTracksObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.objectrepository.TracksObject;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.Salesboost_Adminpanel.testdata.TracksData;
import com.aventstack.extentreports.Status;

public class PrivateTracksPage extends BaseClass {

	SignInObject signInObject;
	DashboardObject dashboardObj;
	TracksObject tracksObj;
	AddPrivateTracksObject addPrivateTracksObj;
	EditPrivateTracksObject editPrivateTracksObj;
	TracksData tracksData;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] testdata;
	
	@Test(priority = 0)
	public void validaddtracks () {
		try {
				log.info("Tracks -add new private track");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
				TracksData tracksData = new TracksData();
				testdata = tracksData.getAddPrivateTrackData(tdImport);
				expectedArray.add(testdata[0]); //name
				expectedArray.add(testdata[1]); //slug 
				expectedArray.add(testdata[2]); //list
				expectedArray.add(testdata[2]); //description
				
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.addTrackButton.click();
				waitForElementToLoad(addPrivateTracksObj.confText);
				
				addPrivateTracksObj.addPrivateTracks(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addPrivateTracksObj.addTrackButton);
				addPrivateTracksObj.addTrackButton.click();	
				Thread.sleep(2000);
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid account adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}
	
	@Test(priority = 1)
	public void validtracksselection () {
		try {
				log.info("valid tracks selection");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify search");
				eTest.assignCategory("search user");

				// valid tracks selection for display based on active/inactive
				
				TracksData tracksData = new TracksData();
				testdata = tracksData.getTracksData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.tracks(testdata[0], testdata[1]);
				Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid tracks selection failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	@Test(priority = 2)
	public void validEditTrack () {
		try {
				log.info("valid edit private track");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update user");
				eTest.assignCategory("update user");
				
				// add track	
				TracksData tracksData = new TracksData();
				testdata = tracksData.getAddPrivateTrackData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.addTrackButton.click();
				waitForElementToLoad(addPrivateTracksObj.confText);
				
				addPrivateTracksObj.addPrivateTracks(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addPrivateTracksObj.addTrackButton);
				addPrivateTracksObj.addTrackButton.click();	
				Thread.sleep(2000);
					
				//search track from tracks list as there is no specified search button this step integrated with edit
				TracksData tracksData1 = new TracksData();
				testdata = tracksData1.getTracksData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.tracks(testdata[0], testdata[1]);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the track if user found
				TracksData tracksData2 = new TracksData();
				testdata = tracksData2.getEditPrivateTrackData(tdImport);
				expectedArray.add(testdata[0]); //name
				expectedArray.add(testdata[1]); //slug
				expectedArray.add(testdata[2]); //list
				expectedArray.add(testdata[3]); //description
				expectedArray.add(testdata[4]); //tag
				expectedArray.add(testdata[5]); //course
				
				editPrivateTracksObj.editPrivateTrack(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5]);
				Thread.sleep(2000);
				waitForElementToLoad (editPrivateTracksObj.trackUpdateButton);
				editPrivateTracksObj.trackUpdateButton.click();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
	}
	
	@Test(priority = 3)
	public void validtrackdelete () {
		try {
				log.info("valid tracks selection");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify search");
				eTest.assignCategory("search user");

				// valid tracks selection then once selected delete
				
				TracksData tracksData = new TracksData();
				testdata = tracksData.getTracksData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.tracks(testdata[0], testdata[1]);
				Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				waitForElementToLoad(editPrivateTracksObj.trackDelete);
				editPrivateTracksObj.trackDelete.click();
				Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete failed");
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
			tracksObj = new TracksObject(driver);
			addPrivateTracksObj = new AddPrivateTracksObject(driver);
			editPrivateTracksObj = new EditPrivateTracksObject(driver);
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
