package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddPrivateTracksObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditPrivateTracksObject;
import com.Salesboost_Adminpanel.objectrepository.PrivateTrackDelete;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.objectrepository.TracksObject;
import com.Salesboost_Adminpanel.testdata.PrivateTracksData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class PrivateTracksPage extends BaseClass {

	SignInObject signInObject;
	DashboardObject dashboardObj;
	TracksObject tracksObj;
	AddPrivateTracksObject addPrivateTracksObj;
	EditPrivateTracksObject editPrivateTracksObj;
	PrivateTracksData tracksData;
	TestDataImport tdImport;
	PrivateTrackDelete deleteTrack;
	
	String getTextboxData="";
	String[] testdata;
	
	@Test(priority = 0)
	public void validaddtracks () {
		try {
				log.info("Tracks -add new private track");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid add private track");
				eTest.assignCategory("add tracks");
				
				PrivateTracksData tracksData = new PrivateTracksData();
				testdata = tracksData.getAddPrivateTrackData(tdImport);
				
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.addTrackButton.click();
				waitForElementToLoad(addPrivateTracksObj.confText);
				
				addPrivateTracksObj.addPrivateTracks(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addPrivateTracksObj.addTrackButton);
				addPrivateTracksObj.addTrackButton.click();	
				Thread.sleep(1000);
				actualstring = addPrivateTracksObj.actualVerificationText.getText();
				expectedstring = testdata[0];

		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid account adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 1)
	public void validtracksselection () {
		try {
				log.info("valid tracks selection");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify tracks listing");
				eTest.assignCategory("tracks listing");

				// valid tracks selection for display based on active/inactive
				
				PrivateTracksData tracksData = new PrivateTracksData();
				testdata = tracksData.getPrivateTracksData(tdImport);
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
	public void validtrackdelete () {
		try {
				log.info("valid tracks delete");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify delete private track");
				eTest.assignCategory("delete track");
				/*
				//add track
				PrivateTracksData tracksData = new PrivateTracksData();
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
				*/
				// valid tracks selection then once selected delete			
				PrivateTracksData tracksData1 = new PrivateTracksData();
				testdata = tracksData1.getPrivateTracksData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.tracks(testdata[0], testdata[1]);
				Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				PrivateTracksData tracksData2 = new PrivateTracksData();
				testdata = tracksData2.getDeletePrivateTrackData(tdImport);
				deleteTrack.delTracks(testdata[0]);
				deleteTrack.trackDelete.click();
				driver.switchTo().alert().accept(); 
				Thread.sleep(2000);
				expectedstring = "Track Name";
				actualstring = tracksObj.valid.getAttribute("value");
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
	public void validEditTrack () {
		try {
				log.info("valid edit private track");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update private track");
				eTest.assignCategory("update track");
				/*
				// add track	
				PrivateTracksData tracksData = new PrivateTracksData();
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
				*/	
				//search track from tracks list as there is no specified search button this step integrated with edit
				PrivateTracksData tracksData1 = new PrivateTracksData();
				testdata = tracksData1.getPrivateTracksData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.tracks(testdata[0], testdata[1]);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the track if user found
				PrivateTracksData tracksData2 = new PrivateTracksData();
				testdata = tracksData2.getEditPrivateTrackData(tdImport);
				
				editPrivateTracksObj.editPrivateTrack(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5], testdata[6]);
				Thread.sleep(2000);
				actualstring = editPrivateTracksObj.actualTextVerification.getText();
				expectedstring = testdata[0];
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
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
			tracksObj = new TracksObject(driver);
			addPrivateTracksObj = new AddPrivateTracksObject(driver);
			editPrivateTracksObj = new EditPrivateTracksObject(driver);
			tdImport.readExcel("PrivateTracksData");
			deleteTrack = new PrivateTrackDelete(driver);	
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
