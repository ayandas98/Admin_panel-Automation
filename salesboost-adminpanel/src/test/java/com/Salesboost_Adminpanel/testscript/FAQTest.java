package com.Salesboost_Adminpanel.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.CoursesPage;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.FAQPage;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.CoursesDataImport;
import com.Salesboost_Adminpanel.testdata.TestDataImport;


public class FAQTest extends BaseClass{
	SignInObject signInObject;
	DashboardObject dashboardObj;
	static CoursesPage coursesObj;
	static CoursesDataImport TestDataObj;
	static FAQPage FAQobj;
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
				FAQobj = new FAQPage(driver);
				/*chromeDriver();
				driver.get("https://qa.salesboost.com/");*/
				TestDataObj = new CoursesDataImport();
				tdImport = new TestDataImport();
				tdImport.readExcel("FAQ");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test(priority =1)
	public void FAQUpdateTest() {
		try {
			eTest = eReports.createTest("Add FAQ");
			eTest.assignCategory("Courses");
			log.info("Entered Add FAQ test");
			System.out.println("Entered Add FAQ test");
		testData = TestDataObj.FAQData(tdImport);
		waitForElementToLoad(dashboardObj.contentTab);
		dashboardObj.contentTab.click();
		waitForElementToLoad(dashboardObj.courses);
		dashboardObj.courses.click();
		Thread.sleep(500);
		coursesObj.searchCourses(testData[2]);
		System.out.println(testData[0]+"||||"+testData[1]);
		FAQobj.addQuestionAnswerDetails(testData[0], testData[1]);
		FAQobj.updateFAQ();
		Thread.sleep(1000);
		log.info("Entered verification method");
		System.out.println("Entered verification method");
		actualstring = FAQobj.FAQQuestion.getText();
		expectedstring = testData[0];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
		
	}
	
	
	@Test(priority = 2)
	public void FAQDeleteTest() {
		try {
			eTest = eReports.createTest("Delete FAQ");
			eTest.assignCategory("Courses");
			log.info("Entered FAQ delete test");
		testData = TestDataObj.FAQData(tdImport);
		//obj.login();
		Thread.sleep(1000);
		dashboardObj.contentTab.click();
		Thread.sleep(1000);
		dashboardObj.courses.click();
		Thread.sleep(1000);
		coursesObj.searchCourses(testData[2]);
		FAQobj.FAQTabBtn.click();
		FAQobj.deleteFAQ();
		Thread.sleep(1000);
		log.info("Entered verification method");
		actualstring = FAQobj.deleteFAQVerification.getText();
		expectedstring = "Please note that if you have unsaved changes you will need to save them before adding a new FAQ.";
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
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
