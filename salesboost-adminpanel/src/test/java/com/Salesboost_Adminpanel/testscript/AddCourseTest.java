package com.Salesboost_Adminpanel.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddCoursePage;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.CoursesDataImport;
import com.Salesboost_Adminpanel.testdata.TestDataImport;

public class AddCourseTest extends BaseClass{

	SignInObject signInObject;
	DashboardObject dashboardObj;
	CoursesDataImport TestDataObj;
	TestDataImport tdImport;
	AddCoursePage addCoursesPageObj;
	String[] testData;
	String getTextboxData="";
	
	@BeforeClass
	public void initialize() {
		try {
			tdImport = new TestDataImport();
			signInObject = new SignInObject(driver);
			waitForElementToLoad(signInObject.Email);
			signInObject.signIn("balu.kr@experionglobal.com", "qI85Jx$3");
			dashboardObj = new DashboardObject(driver);
			addCoursesPageObj = new AddCoursePage(driver);
			TestDataObj = new CoursesDataImport();
			tdImport.readExcel("AddCourse");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test(priority = 1)
	public void addCourseTestIncompleteDetails() {
		try {
			eTest = eReports.createTest("Add courses incomplete");
			eTest.assignCategory("Courses");
			log.info("Entered add course incomplete method");
			testData = TestDataObj.AddCourseData(tdImport);
			
			waitForElementToLoad(dashboardObj.contentTab);
			dashboardObj.contentTab.click();
			waitForElementToLoad(dashboardObj.courses);
			dashboardObj.courses.click();
			waitForElementToLoad(dashboardObj.addCourseBtn);
			dashboardObj.addCourseBtn.click();
			addCoursesPageObj.addCourseIncompleteDetails(testData[0], testData[1], testData[2],
					Boolean.parseBoolean(testData[3]), Boolean.parseBoolean(testData[4]), testData[5], testData[6],
					Boolean.parseBoolean(testData[7]));
			log.info("Entered verification method");
			actualstring = addCoursesPageObj.actualVerificationText.getText();
			expectedstring = "Add Course:";
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
	}

	
	@Test(priority = 2)
	public void addCourseTest() {

		try {
			eTest = eReports.createTest("Add courses");
			eTest.assignCategory("Courses");
			log.info("Entered add course test");
			
			CoursesDataImport TestDataObj = new CoursesDataImport();
			testData = TestDataObj.AddCourseData(tdImport);			
			
			dashboardObj.contentTab.click();
			dashboardObj.courses.click();
			dashboardObj.addCourseBtn.click();
			addCoursesPageObj.addCourseCompleteDetails(testData[0], testData[1], testData[2],
					Boolean.parseBoolean(testData[3]), Boolean.parseBoolean(testData[4]), testData[5], testData[6],
					Boolean.parseBoolean(testData[7]));

			Thread.sleep(1000);
			log.info("Entered verification method");
			actualstring = addCoursesPageObj.actualVerificationText.getText();
			expectedstring = testData[0];

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
	}
	
	public void addCourseWithExistsingCourseNameTest() {

		try {
			eTest = eReports.createTest("Add courses");
			eTest.assignCategory("Courses");
			log.info("Entered add course test");
			
			CoursesDataImport TestDataObj = new CoursesDataImport();
			testData = TestDataObj.AddCourseData(tdImport);			
			
			dashboardObj.contentTab.click();
			dashboardObj.courses.click();
			dashboardObj.addCourseBtn.click();
			addCoursesPageObj.addCourseWithExistingName(testData[0], testData[1], testData[2],
					Boolean.parseBoolean(testData[3]), Boolean.parseBoolean(testData[4]), testData[5], testData[6],
					Boolean.parseBoolean(testData[7]));

			Thread.sleep(1000);
			log.info("Entered verification method");
			actualstring = driver.switchTo().alert().getText();
			expectedstring = testData[0];

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
	}
	
	public void addCourseWithoutCertificateImageTest() {

		try {
			eTest = eReports.createTest("Add courses");
			eTest.assignCategory("Courses");
			log.info("Entered add course test");
			
			CoursesDataImport TestDataObj = new CoursesDataImport();
			testData = TestDataObj.AddCourseData(tdImport);			
			
			dashboardObj.contentTab.click();
			dashboardObj.courses.click();
			dashboardObj.addCourseBtn.click();
			addCoursesPageObj.addCourseWithoutCertificateImg(testData[0], testData[1], testData[2],
					Boolean.parseBoolean(testData[3]), Boolean.parseBoolean(testData[4]), testData[5], testData[6],
					Boolean.parseBoolean(testData[7]));

			Thread.sleep(1000);
			log.info("Entered verification method");
			actualstring = driver.switchTo().alert().getText();
			expectedstring = testData[0];

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
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
