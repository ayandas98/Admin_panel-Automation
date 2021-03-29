package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddNewUserObject;
import com.Salesboost_Adminpanel.objectrepository.AdministratorsObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditUserObject;

import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.AdministratorsData;
import com.Salesboost_Adminpanel.testdata.SearchData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;
//import org.openqa.selenium.interactions.Actions;

public class administratorsPage extends BaseClass{

	AdministratorsObject administratorsObject;
	AddNewUserObject addNewUserObject;
	EditUserObject editUserObject;
	DashboardObject dashboardObj;
	SignInObject signInObject;
	AdministratorsData administratorsData;
	SearchData searchData;
	TestDataImport tdImport;
	String getTextboxData="";
	String[] fullName = new String[2];
	String[] testdata;
	String[] testdata1;
	
	@Test(priority = 0)
	public void validadduser () {
		try {
				log.info("Administrator page-add new user");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify add user");
				eTest.assignCategory("add user");
				AdministratorsData administratorsData = new AdministratorsData();
				testdata = administratorsData.getAddUserData(tdImport);
				
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				waitForElementToLoad(administratorsObject.addNewUserButton);
				administratorsObject.addNewUserButton.click();
				waitForElementToLoad(addNewUserObject.header);
				
				addNewUserObject.addNewUser(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addNewUserObject.addUser);
				Thread.sleep(1000);
				addNewUserObject.addUser.click();
				expectedstring = testdata[1]+" "+testdata[2];
				actualstring =addNewUserObject.valid.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid account adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 1)
	public void validsearch () {
		try {
				log.info("valid search user");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid search");
				eTest.assignCategory("search user");
				
				// add user 
	/*
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				AdministratorsData administratorsData = new AdministratorsData();
				testdata = administratorsData.getAddUserData(this.tdImport);
				waitForElementToLoad(administratorsObject.addNewUserButton);
				administratorsObject.addNewUserButton.click();
				waitForElementToLoad(addNewUserObject.header);
				
				addNewUserObject.addNewUser(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addNewUserObject.addUser);
				addNewUserObject.addUser.click();	
	*/					
				// validate search by searching for added user
	
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				AdministratorsData administratorsData1 = new AdministratorsData();
				testdata = administratorsData1.getAdministratorPageData(this.tdImport);
				waitForElementToLoad(administratorsObject.Username);
				waitForElementToLoad(administratorsObject.searchButton);
				administratorsObject.administrators(testdata[0], testdata[1]);
				System.out.println(testdata[1]);
				administratorsObject.searchButton.click();
				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid search failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	@Test(priority = 2)
	public void validUserUpdate () {
		try {
				log.info("valid edit/update user");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid update user");
				eTest.assignCategory("update user");
				
		/*		// add user
				
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				AdministratorsData administratorsData2 = new AdministratorsData();
				testdata = administratorsData2.getAddUserData(this.tdImport);
				waitForElementToLoad(administratorsObject.addNewUserButton);
				administratorsObject.addNewUserButton.click();
				waitForElementToLoad(addNewUserObject.header);
				addNewUserObject.addNewUser(testdata[0], testdata[1], testdata[2], testdata[3]);
				waitForElementToLoad (addNewUserObject.addUser);
				addNewUserObject.addUser.click();	
			*/	
				//search user
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				AdministratorsData administratorsData = new AdministratorsData();
				testdata = administratorsData.getAdministratorPageData(this.tdImport);
				waitForElementToLoad(administratorsObject.Username);
				waitForElementToLoad(administratorsObject.searchButton);
				administratorsObject.administrators(testdata[0], testdata[1]);
				administratorsObject.searchButton.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				//update the user if user found
				
				AdministratorsData administratorsData1 = new AdministratorsData();
				testdata = administratorsData1.getEditUserData(tdImport);
				
				editUserObject.editUser(testdata[0], testdata[1], testdata[2], testdata[3]);		
				waitForElementToLoad (editUserObject.updateUser);
//				editUserObject.updateUser.click();
				Thread.sleep(2000);
				expectedstring = testdata[1];
				actualstring = editUserObject.valid.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid search failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	} 
	
	@Test(priority = 0)
	public void addUserInvalidEmail () {
		try {
				log.info("Administrator page-add new user");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify add user invalid email");
				eTest.assignCategory("add user");
							
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				waitForElementToLoad(administratorsObject.addNewUserButton);
				administratorsObject.addNewUserButton.click();
				waitForElementToLoad(addNewUserObject.header);
				
				addNewUserObject.userInvalidMail();
				expectedstring = "Invalid email";
				actualstring =addNewUserObject.conf1.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("invalid Email verification failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}
	
	@Test(priority = 0)
	public void addUserExistingEmail () {
		try {
				log.info("Administrator page-add new user");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify add user with Existing Email");
				eTest.assignCategory("add user");
							
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				waitForElementToLoad(administratorsObject.addNewUserButton);
				administratorsObject.addNewUserButton.click();
				waitForElementToLoad(addNewUserObject.header);
				
				addNewUserObject.addUserExistingMail();
				expectedstring = "Account already exists";
				actualstring =addNewUserObject.conf2.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Existing Email verification failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 0)
	public void addUserWithoutMandatoryData () {
		try {
				log.info("Administrator page-add new user");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify add user without mandatory data");
				eTest.assignCategory("add user");
							
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				waitForElementToLoad(administratorsObject.addNewUserButton);
				administratorsObject.addNewUserButton.click();
				waitForElementToLoad(addNewUserObject.header);
				
				addNewUserObject.addUserWithoutData();;
				expectedstring = "Invalid email";
				actualstring =addNewUserObject.conf1.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("add user without mandatory data verification failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}
	
	@Test(priority = 0)
	public void editUserInvalidEmail () {
		try {
			log.info("Administrator page-add edit user");
			actualstring ="";
			actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
			eTest = eReports.createTest("verify edit user invalid email");
			eTest.assignCategory("edit user");
			//search user
			dashboardObj.usersTab.click();
			dashboardObj.administrator.click();
			waitForElementToLoad(administratorsObject.Username);
			driver.findElement(By.xpath("//a[contains(text(),'exp')]")).click();
			Thread.sleep(1000);
			//update the user if user found
			editUserObject.editUserInvalidMail();		
			expectedstring = "Invalid email";
			actualstring =editUserObject.conf1.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("invalid Email verification failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}

	@Test(priority = 0)
	public void editUserExistingEmail () {
		try {
			log.info("Administrator page-edit user");
			actualstring ="";
			actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
			eTest = eReports.createTest("verify edit user with existing mail");
			eTest.assignCategory("edit user");
			//search user
			dashboardObj.usersTab.click();
			dashboardObj.administrator.click();
			waitForElementToLoad(administratorsObject.Username);
			driver.findElement(By.xpath("//a[contains(text(),'exp')]")).click();
			Thread.sleep(1000);
			//update the user if user found
			editUserObject.editUserExistingMail();		
			expectedstring = "Failed";
			actualstring =editUserObject.conf1.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("existing Email verification failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 0)
	public void editUserWithoutReqData () {
		try {
				log.info("Administrator page-edit user");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify edit user without mandatory data");
				eTest.assignCategory("edit user");
							
				dashboardObj.usersTab.click();
				dashboardObj.administrator.click();
				waitForElementToLoad(administratorsObject.addNewUserButton);
				waitForElementToLoad(administratorsObject.Username);
				driver.findElement(By.xpath("//a[contains(text(),'exp')]")).click();
				Thread.sleep(1000);
				editUserObject.editUserWithoutMandatoryData(); 
				expectedstring = "Invalid email";
				actualstring =editUserObject.conf1.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("invalid Edit without required data verification failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: "+actualstring+"\nExpcted: "+expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
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
			administratorsObject = new AdministratorsObject(driver);
			addNewUserObject = new AddNewUserObject(driver);
			editUserObject = new EditUserObject(driver);
			tdImport.readExcel("UsersData");
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

