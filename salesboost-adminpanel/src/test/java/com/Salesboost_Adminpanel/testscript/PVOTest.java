package com.Salesboost_Adminpanel.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddCoursePage;
import com.Salesboost_Adminpanel.objectrepository.CoursesPage;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.PVOAddQuestionsPage;
import com.Salesboost_Adminpanel.objectrepository.PVOPage;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.CoursesDataImport;
import com.Salesboost_Adminpanel.testdata.TestDataImport;



public class PVOTest extends BaseClass{
	SignInObject signInObject;
	DashboardObject dashboardObj;
	CoursesPage coursesObj;
	static CoursesDataImport TestDataObj;
	static AddCoursePage addCoursesPageObj;
	static PVOPage PVOobj;
	static PVOAddQuestionsPage PVOQnsobj;
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
				addCoursesPageObj = new AddCoursePage(driver);
				PVOQnsobj = new PVOAddQuestionsPage(driver);
				PVOobj = new PVOPage(driver);
				/*chromeDriver();
				driver.get("https://qa.salesboost.com/");*/
				TestDataObj = new CoursesDataImport();
				tdImport = new TestDataImport();
				tdImport.readExcel("PVO");
			

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	//@Test(priority =1)
	public void addPVODataTest() {
		try {
			eTest = eReports.createTest("Add PVO");
			eTest.assignCategory("Courses");
			log.info("Entered add PVO test");
			System.out.println("Entered add PVO test");
		testData = TestDataObj.PVOData(tdImport);
		
		Thread.sleep(1000);
		dashboardObj.contentTab.click();
		Thread.sleep(1000);
		dashboardObj.courses.click();
		Thread.sleep(1000);
		coursesObj.searchCourses(testData[11]);
		PVOobj.addPVOData(testData[0], testData[1], testData[2], testData[3]);
		PVOobj.updatePVO();
		Thread.sleep(1000);
		log.info("Entered verification method");
		actualstring = PVOobj.PVOVideoDescription.getText();
		System.out.println("Text verification: "+actualstring);
		expectedstring = testData[3];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
		
	}
	@Test(priority = 2)
	public void addPVOScoreBasedTest() {
		try {
			eTest = eReports.createTest("Add PVO scorebased");
			eTest.assignCategory("Courses");
			log.info("Entered PVO scorebased test");
		testData = TestDataObj.PVOData(tdImport);
		
		waitForElementToLoad(dashboardObj.contentTab);
		dashboardObj.contentTab.click();
		waitForElementToLoad(dashboardObj.courses);
		dashboardObj.courses.click();
		Thread.sleep(500);
		coursesObj.searchCourses(testData[11]);
		PVOobj.addPVOData(testData[0], testData[1], testData[2], testData[3]);
		PVOQnsobj.addQuestions(testData[7], testData[8], Boolean.parseBoolean(testData[9]), testData[10]);
		if(PVOobj.equalWeightageCheckbox.isEnabled()==false)
		{
			System.out.println("Slider works as intended");
		}
		PVOobj.PVOScoreBasedPostQns(Boolean.parseBoolean(testData[6]), testData[5]);
		PVOobj.updatePVO();
		Thread.sleep(2000);
		log.info("Entered verification method");
		actualstring = PVOobj.PVOVideoName.getAttribute("value");
		expectedstring = testData[2];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");
	}
	
	public void deleteQuestionTest() {
		try {
		eTest = eReports.createTest("Delete PVO Question");
		eTest.assignCategory("Courses");
		log.info("Entered PVO scorebased test");
	testData = TestDataObj.PVOData(tdImport);
	
	Thread.sleep(1000);
	dashboardObj.contentTab.click();
	Thread.sleep(1000);
	dashboardObj.courses.click();
	Thread.sleep(1000);
	coursesObj.searchCourses(testData[11]);
	PVOobj.PVOTabBtn.click();
	PVOobj.editQns();
	PVOQnsobj.deleteQuestion();
	actualstring = driver.switchTo().alert().getText();
	expectedstring = "Are you sure you want to delete?";
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
