package com.Salesboost_Adminpanel.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AssociatedFilesPage;
import com.Salesboost_Adminpanel.objectrepository.CoursesPage;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.CoursesDataImport;
import com.Salesboost_Adminpanel.testdata.TestDataImport;

public class AssociatedFilesTest extends BaseClass{
	SignInObject signInObject;
	DashboardObject dashboardObj;
	CoursesPage coursesObj;
	static CoursesDataImport TestDataObj;
	static AssociatedFilesPage AFobj;
	static String[] testData;
	TestDataImport tdImport;
	
	@BeforeClass
	public void initialize() {
			try {
				signInObject = new SignInObject(driver);
				waitForElementToLoad(signInObject.Email);
				signInObject.signIn("balu.kr@experionglobal.com", "qI85Jx$3");
				dashboardObj = new DashboardObject(driver);
				coursesObj = new CoursesPage(driver);
				AFobj = new AssociatedFilesPage(driver);
				//chromeDriver();
				//driver.get("https://qa.salesboost.com/");
				TestDataObj = new CoursesDataImport();
				tdImport = new TestDataImport();
				tdImport.readExcel("AssociatedFiles");
			

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test(priority = 1)
	public void AssociatedPageAddFileDataTest() {
		try {
			eTest = eReports.createTest("Add Associated files details");
			eTest.assignCategory("Courses");
			log.info("Entered add associated files test");
		testData = TestDataObj.AssociatedFilesData(tdImport);
		
		waitForElementToLoad(dashboardObj.contentTab);
		dashboardObj.contentTab.click();
		//waitForElementToLoad(dashboardObj.courses);
		dashboardObj.courses.click();
		Thread.sleep(500);
		coursesObj.searchCourses(testData[3]);
		AFobj.addFileButtonTest();
		AFobj.editAssociatedFilesTest(testData[0], testData[1]);
		Thread.sleep(1000);
		AFobj.AssociatedFileTabBtn.click();
		log.info("Entered verification method");
		actualstring = AFobj.linkTextVerification.getText();
		expectedstring = testData[1];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
	}
	
	@Test(priority = 2)
	public void AssociatedPageAddIncompleteFileDataTest() {
		try {
		eTest = eReports.createTest("Add Associated files incomplete");
		eTest.assignCategory("Courses");
		log.info("Entered add incomplete associated files test");
		testData = TestDataObj.AssociatedFilesData(tdImport);
		Thread.sleep(1000);
		dashboardObj.contentTab.click();
		Thread.sleep(1000);
		dashboardObj.courses.click();
		Thread.sleep(1000);
		coursesObj.searchCourses(testData[3]);
		AFobj.addFileButtonTest();
		AFobj.associatedFileIncompleteDetailsTest(testData[0]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void AssociatedPageEditFileDataTest() {
		try {
		eTest = eReports.createTest("Add Associated files incomplete");
		eTest.assignCategory("Courses");
		log.info("Entered add incomplete associated files test");
		testData = TestDataObj.AssociatedFilesData(tdImport);
		Thread.sleep(1000);
		dashboardObj.contentTab.click();
		Thread.sleep(1000);
		dashboardObj.courses.click();
		Thread.sleep(1000);
		coursesObj.searchCourses(testData[3]);
		AFobj.editAssociatedFiles(testData[0],testData[2]);
		Thread.sleep(1000);
		AFobj.AssociatedFileTabBtn.click();
		log.info("Entered verification method");
		actualstring = AFobj.linkTextVerification.getText();
		expectedstring = testData[2];
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
	}
	
	
	public void deleteAssociatedFilesTest() {
		try {
			eTest = eReports.createTest("Add Associated files incomplete");
			eTest.assignCategory("Courses");
			log.info("Entered add incomplete associated files test");
			testData = TestDataObj.AssociatedFilesData(tdImport);
			Thread.sleep(1000);
			dashboardObj.contentTab.click();
			Thread.sleep(1000);
			dashboardObj.courses.click();
			Thread.sleep(1000);
			coursesObj.searchCourses(testData[3]);
			AFobj.deleteAssociatedFiles();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	@AfterClass
	public void logout() {
		try {
			log.info("Sign In: logout");
			waitForElementToLoad(dashboardObj.Admin);
			waitIfElementClickIsIntercepted(dashboardObj.logOut, "click", "");
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
