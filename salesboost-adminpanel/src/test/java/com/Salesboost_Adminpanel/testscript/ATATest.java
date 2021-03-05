package com.Salesboost_Adminpanel.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.ATAPage;
import com.Salesboost_Adminpanel.objectrepository.ATASnippetPage;
import com.Salesboost_Adminpanel.objectrepository.CoursesPage;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.CoursesDataImport;
import com.Salesboost_Adminpanel.testdata.TestDataImport;

public class ATATest extends BaseClass {
	SignInObject signInObject;
	DashboardObject dashboardObj;
	CoursesPage coursesObj;
	static CoursesDataImport TestDataObj;
	static TestDataImport excelImportObj;
	static ATAPage ATAobj;
	static ATASnippetPage snippetObj;
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
			ATAobj = new ATAPage(driver);
			snippetObj = new ATASnippetPage(driver);
			/*
			 * chromeDriver(); driver.get("https://qa.salesboost.com/");
			 */
			TestDataObj = new CoursesDataImport();
			tdImport = new TestDataImport();
			tdImport.readExcel("ATA");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test(priority = 1)
	public void addATADataTest() {
		try {
			eTest = eReports.createTest("Add ATA");
			eTest.assignCategory("Courses");
			log.info("Entered Add ATA test");
			testData = TestDataObj.ATAData(tdImport);

			Thread.sleep(1000);
			dashboardObj.contentTab.click();
			Thread.sleep(1000);
			dashboardObj.courses.click();
			Thread.sleep(1000);
			coursesObj.searchCourses(testData[6]);
			ATAobj.editATAPage(testData[0], testData[1], testData[2]);
			ATAobj.updateATA();
			Thread.sleep(1000);
			log.info("Entered verification method");
			actualstring = ATAobj.ATAIntroText.getText();
			expectedstring = testData[0];
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");

	}

	@Test(priority = 2)
	public void addSnippetPageTest() {
		try {
			eTest = eReports.createTest("Add ATA snippet");
			eTest.assignCategory("Courses");
			log.info("Entered add snippet test");
			testData = TestDataObj.ATAData(tdImport);
			// obj.login();
			Thread.sleep(1000);
			dashboardObj.contentTab.click();
			Thread.sleep(1000);
			dashboardObj.courses.click();
			Thread.sleep(1000);
			coursesObj.searchCourses(testData[6]);
			Thread.sleep(1000);
			ATAobj.ATATabBtn.click();
			snippetObj.addSnippet(testData[3], testData[4]);
			Thread.sleep(1000);
			log.info("Entered verification method");

			actualstring = snippetObj.snippetDescription.getText();
			expectedstring = testData[4];
			log.info("Verification complete");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));

	}
	//@Test(priority = 3)
	public void editSnippetTest() {
		try {
			eTest = eReports.createTest("Add ATA snippet");
			eTest.assignCategory("Courses");
			log.info("Entered add snippet test");
			testData = TestDataObj.ATAData(tdImport);
			// obj.login();
			Thread.sleep(1000);
			dashboardObj.contentTab.click();
			Thread.sleep(1000);
			dashboardObj.courses.click();
			Thread.sleep(1000);
			coursesObj.searchCourses(testData[6]);
			Thread.sleep(1000);
			ATAobj.ATATabBtn.click();
			snippetObj.editSnippet(testData[3], testData[5]);
			Thread.sleep(1000);
			log.info("Entered verification method");

			actualstring = snippetObj.snippetDescription.getText();
			expectedstring = testData[5];
			log.info("Verification complete");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		
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