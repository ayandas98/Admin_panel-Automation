package com.Salesboost_Adminpanel.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddCoursePage;
import com.Salesboost_Adminpanel.objectrepository.CoursesPage;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.LATPage;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.CoursesDataImport;
import com.Salesboost_Adminpanel.testdata.TestDataImport;



public class LATTest extends BaseClass {
	SignInObject signInObject;
	DashboardObject dashboardObj;
	CoursesPage coursesObj;
	static CoursesDataImport TestDataObj;
	static TestDataImport excelImportObj;
	//static CourseFilterData filterDataObj;
	static AddCoursePage addCoursesPageObj;
	static LATPage LATobj;
	static String[] testData;
	TestDataImport tdImport;
	String getTextboxData="";

	@BeforeClass
	public void initialize() {
		try {
			signInObject = new SignInObject(driver);
			waitForElementToLoad(signInObject.Email);
			signInObject.signIn("balu.kr@experionglobal.com", "qI85Jx$3");
			dashboardObj = new DashboardObject(driver);
			coursesObj = new CoursesPage(driver);
			addCoursesPageObj = new AddCoursePage(driver);
			LATobj = new LATPage(driver);
			tdImport = new TestDataImport();
			tdImport.readExcel("LAT");
			TestDataObj = new CoursesDataImport();
	

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test(priority = 1)
	public void addLATTest() {
		try {
			eTest = eReports.createTest("Add LAT");
			eTest.assignCategory("Courses");
			log.info("Entered add lat test");
			System.out.println("Entered add lat test");
			testData = TestDataObj.LATData(tdImport);

			waitForElementToLoad(dashboardObj.contentTab);
			dashboardObj.contentTab.click();
			waitForElementToLoad(dashboardObj.courses);
			dashboardObj.courses.click();
			Thread.sleep(500);
			coursesObj.searchCourses(testData[3]);
			LATobj.editLATPage(testData[0], testData[1], testData[2]);
			LATobj.AddUpdateLATBtn.click();
			Thread.sleep(1000);
			log.info("Entered verification method");
			actualstring = LATobj.LATVideoName.getAttribute("value");
			
			expectedstring = testData[1];
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
	}

	@Test(priority = 2)
	public void addLATIncorrectDetails() {
		try {
			eTest = eReports.createTest("Add LAT incomplete");
			eTest.assignCategory("Courses");
			log.info("Entered add lat incorrect details test");
			testData = TestDataObj.LATData(tdImport);

			Thread.sleep(1000);
			dashboardObj.contentTab.click();
			Thread.sleep(1000);
			dashboardObj.courses.click();
			Thread.sleep(1000);
			coursesObj.searchCourses(testData[3]);
			LATobj.editLATError(testData[0], testData[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void deleteLAT() {
		try {
			eTest = eReports.createTest("Delete LAT");
			eTest.assignCategory("Courses");
			log.info("Entered delete lat test");
			// obj.login();
			Thread.sleep(1000);
			dashboardObj.contentTab.click();
			Thread.sleep(1000);
			dashboardObj.courses.click();
			Thread.sleep(1000);
			coursesObj.searchCourses(testData[3]);
			Thread.sleep(1000);
			LATobj.deleteLAT();
		} catch (Exception e) {
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