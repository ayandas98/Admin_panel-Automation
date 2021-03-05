package com.Salesboost_Adminpanel.testscript;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AwardPage;
import com.Salesboost_Adminpanel.objectrepository.CoursesPage;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.CoursesDataImport;
import com.Salesboost_Adminpanel.testdata.TestDataImport;


public class AwardsTest extends BaseClass{
	SignInObject signInObject;
	DashboardObject dashboardObj;
	CoursesPage coursesObj;
	static CoursesDataImport TestDataObj;
	static AwardPage awardsObj;
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
				awardsObj = new AwardPage(driver);
				//chromeDriver();
				//driver.get("https://qa.salesboost.com/");
				TestDataObj = new CoursesDataImport();
				tdImport = new TestDataImport();
				tdImport.readExcel("Awards");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test(priority = 1)
	public void addAwardDataTest() {
		try {
			eTest = eReports.createTest("Add Awards");
			eTest.assignCategory("Courses");
			log.info("Entered add awards test");
		testData = TestDataObj.AwardData(tdImport);
		//String verification = "";
	
		waitForElementToLoad(dashboardObj.contentTab);
		dashboardObj.contentTab.click();
		waitForElementToLoad(dashboardObj.courses);
		dashboardObj.courses.click();
		Thread.sleep(500);
		coursesObj.searchCourses(testData[5]);
		awardsObj.editAwardsPage(testData[0], testData[1],testData[2] ,testData[3], testData[4]);
		Thread.sleep(1000);
		awardsObj.addUpdateAwards();
		Thread.sleep(2000);
		log.info("Entered verification method");
		actualstring = awardsObj.CertificateSignName.getAttribute("value");
		System.out.println("Text verification: "+actualstring);
		expectedstring = testData[1];
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(actualstring, expectedstring);
		log.info("Verification complete");
	}
	
	//@Test(priority = 2)
	public void awardsClearAllTest() {
		try {
		eTest = eReports.createTest("Clear awards");
		eTest.assignCategory("Courses");
		log.info("Entered clear all awards test");
		testData = TestDataObj.AwardData(tdImport);

		Thread.sleep(1000);
		dashboardObj.contentTab.click();
		Thread.sleep(1000);
		dashboardObj.courses.click();
		Thread.sleep(1000);
		coursesObj.searchCourses(testData[5]);
		awardsObj.editAwardsPage(testData[0], testData[1],testData[2] ,testData[3], testData[4]);
		awardsObj.clearAwards();
		log.info("Entered verification method");
		actualstring = awardsObj.CertificateSignName.getText();
		expectedstring = "";
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(actualstring, expectedstring);
		log.info("Verification complete");
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