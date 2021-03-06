package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddTracksObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.DeleteTrack;
import com.Salesboost_Adminpanel.objectrepository.EditTracksObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.objectrepository.TracksObject;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.Salesboost_Adminpanel.testdata.TracksData;
import com.aventstack.extentreports.Status;

public class TracksPage extends BaseClass{

	SignInObject signInObject;
	DashboardObject dashboardObj;
	TracksObject tracksObj;
	AddTracksObject addTracksObj;
	EditTracksObject editTracksObj;
	TracksData tracksData;
	TestDataImport tdImport;
	DeleteTrack deleteTrack;
	
	String getTextboxData="";
	String[] testdata;
	
	@Test(priority = 0)
	public void validaddtracks () {
		try {
				log.info("Tracks -add new track");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify add track");
				eTest.assignCategory("tracks");
				
				TracksData tracksData = new TracksData();
				testdata = tracksData.getAddTrackData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();

				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.addTrackButton.click();
				waitForElementToLoad(addTracksObj.confText);

				addTracksObj.addTrack(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad(addTracksObj.addTrackButton);
				//addTracksObj.addTrackButton.click();
				Thread.sleep(2000);
				actualstring = addTracksObj.actualTextVerification.getText();
				expectedstring = testdata[0];
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid track adding failed");
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
				eTest = eReports.createTest("valid tracks listings");
				eTest.assignCategory("tracks");

				// valid tracks selection
				
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
			System.out.println("valid selection failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	@Test(priority = 2)
	public void validtrackdelete () {
		try {
				log.info("valid tracks delete");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify delete track");
				eTest.assignCategory("tracks");
			/*	
				//add track
				TracksData tracksData = new TracksData();
				testdata = tracksData.getAddTrackData(tdImport);				
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.addTrackButton.click();
				waitForElementToLoad(addTracksObj.confText);
				
				addTracksObj.addTrack(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addTracksObj.addTrackButton);
				addTracksObj.addTrackButton.click();	
				Thread.sleep(2000);
			*/	
				// valid tracks selection then once selected delete			
				TracksData tracksData1 = new TracksData();
				testdata = tracksData1.getTracksData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.tracks(testdata[0], testdata[1]);
				Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				TracksData tracksData2 = new TracksData();
				testdata = tracksData2.getDeleteTrackData(tdImport);
				deleteTrack.delTracks(testdata[0]);
				waitForElementToLoad(deleteTrack.trackDelete);
				deleteTrack.trackDelete.click();
				driver.switchTo().alert().accept(); 
				Thread.sleep(1000);				
				expectedstring = "Track Name";
				actualstring = tracksObj.valid.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 2)
	public void validEditTrack () {
		try {
				log.info("valid edit track");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update track");
				eTest.assignCategory("tracks");
			/*
				  // add track 
				TracksData tracksData = new TracksData(); 
				testdata =tracksData.getAddTrackData(tdImport); 
				dashboardObj.contentTab.click();
				  dashboardObj.tracks.click(); 
				  waitForElementToLoad(tracksObj.addTrackButton);
				  tracksObj.addTrackButton.click();
				  waitForElementToLoad(addTracksObj.confText);
				  
				  addTracksObj.addTrack(testdata[0], testdata[1], testdata[2]);
				  Thread.sleep(2000);
			*/	 
				//search track from tracks list as there is no specified search button this step integrated with edit
				TracksData tracksData1 = new TracksData();
				testdata = tracksData1.getTracksData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.tracks.click();
				waitForElementToLoad(tracksObj.addTrackButton);
				tracksObj.tracks(testdata[0], testdata[1]);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				Thread.sleep(1000);
				//update the track if found
				TracksData tracksData2 = new TracksData();
				testdata = tracksData2.getEditTrackData(tdImport);
				editTracksObj.editTrack(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5]);
				Thread.sleep(1000);
				expectedstring = testdata[0];
				actualstring = editTracksObj.actualTextVerification.getText();
				
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
			addTracksObj = new AddTracksObject(driver);
			editTracksObj = new EditTracksObject(driver);
			deleteTrack = new DeleteTrack(driver);
			tdImport.readExcel("TracksData");
				
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
