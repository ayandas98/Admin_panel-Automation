package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddRolesObject;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditRolesObject;
import com.Salesboost_Adminpanel.objectrepository.RoleManagementObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.RoleManagementData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class RoleManagementPage extends BaseClass {

	SignInObject signInObject;
	DashboardObject dashboardObj;
	RoleManagementObject roleManagementObj;
	AddRolesObject addRolesObj;
	EditRolesObject editRolesObj;
	RoleManagementData roleManagementDataObj;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] testdata;
	
	@Test(priority = 0)
	public void validaddroles () {
		try {
				log.info("Tracks -cancel add new role");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
				RoleManagementData roleManagementDataObj = new RoleManagementData();
				testdata = roleManagementDataObj.getAddRolesData(tdImport);
				expectedArray.add(testdata[0]); //name
				expectedArray.add(testdata[1]); //description 
				expectedArray.add(testdata[2]); //list
				
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.addButton.click();
				waitForElementToLoad(addRolesObj.roleName);
				
				addRolesObj.addRoles(testdata[0], testdata[1]);
				waitForElementToLoad (addRolesObj.addRoleButton);
				addRolesObj.addRoleButton.click();	
				Thread.sleep(2000);
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid role adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}

	@Test(priority = 1)
	public void validcanceladdroles () {
		try {
				log.info("Tracks - cancel add new role");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("add account");
				eTest.assignCategory("add account");
				
				RoleManagementData roleManagementDataObj = new RoleManagementData();
				testdata = roleManagementDataObj.getAddRolesData(tdImport);
				expectedArray.add(testdata[0]); //name
				expectedArray.add(testdata[1]); //description 
				expectedArray.add(testdata[2]); //list
				
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.addButton.click();
				waitForElementToLoad(addRolesObj.roleName);
				
				addRolesObj.addRoles(testdata[0], testdata[1]);
				waitForElementToLoad (addRolesObj.cancelButton);
				addRolesObj.cancelButton.click();	
				Thread.sleep(2000);
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid cancel role adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}
	
	@Test(priority = 2)
	public void validrolesselection () {
		try {
				log.info("valid roles selection");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify search");
				eTest.assignCategory("search user");

				// valid roles selection in display page based on active/inactive 
				RoleManagementData roleManagementDataObj = new RoleManagementData();
				testdata = roleManagementDataObj.getAddRolesData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.roleManagement(testdata[0], testdata[1]);
				Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid selection failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	@Test(priority = 3)
	public void validEditRoles () {
		try {
				log.info("valid edit role");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update user");
				eTest.assignCategory("update user");
				
				// add role
				RoleManagementData roleManagementDataObj = new RoleManagementData();
				testdata = roleManagementDataObj.getAddRolesData(tdImport);
				expectedArray.add(testdata[0]); //name
				expectedArray.add(testdata[1]); //description 
				expectedArray.add(testdata[2]); //list
				
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.addButton.click();
				waitForElementToLoad(addRolesObj.roleName);
				
				addRolesObj.addRoles(testdata[0], testdata[1]);
				waitForElementToLoad (addRolesObj.addRoleButton);
				addRolesObj.addRoleButton.click();	
				
					
				//search role from roles list as there is no specified search button this step integrated with edit
				RoleManagementData roleManagementDataObj1 = new RoleManagementData();
				testdata = roleManagementDataObj1.getAddRolesData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.roleManagement(testdata[0], testdata[1]);
				driver.findElement(By.xpath(" //td[contains(text(),'" + testdata[1] + "')]//following::td[contains(@value, 'Edit Role')]")).click();
				System.out.println(testdata[1]);
				
				//update the role if found
				RoleManagementData roleManagementDataObj2 = new RoleManagementData();
				testdata = roleManagementDataObj2.getAddRolesData(tdImport);
				expectedArray.add(testdata[0]);
				expectedArray.add(testdata[1]);
				expectedArray.add(testdata[2]);
			
				
				editRolesObj.editRoles(testdata[0], testdata[1], testdata[2]);
				Thread.sleep(2000);
				waitForElementToLoad (editRolesObj.updateRoleButton);
				editRolesObj.updateRoleButton.click();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
	} 
	
	@Test(priority = 4)
	public void validCancelEditRoles () {
		try {
				log.info("valid cancel edit role");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update user");
				eTest.assignCategory("update user");
				
				// add role
				RoleManagementData roleManagementDataObj = new RoleManagementData();
				testdata = roleManagementDataObj.getAddRolesData(tdImport);
				expectedArray.add(testdata[0]); //name
				expectedArray.add(testdata[1]); //description 
				expectedArray.add(testdata[2]); //list
				
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.addButton.click();
				waitForElementToLoad(addRolesObj.roleName);
				
				addRolesObj.addRoles(testdata[0], testdata[1]);
				waitForElementToLoad (addRolesObj.addRoleButton);
				addRolesObj.addRoleButton.click();	
				
					
				//search role from roles list as there is no specified search button this step integrated with edit
				RoleManagementData roleManagementDataObj1 = new RoleManagementData();
				testdata = roleManagementDataObj1.getAddRolesData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.roleManagement(testdata[0], testdata[1]);
				driver.findElement(By.xpath(" //td[contains(text(),'" + testdata[1] + "')]//following::td[contains(@value, 'Edit Role')]")).click();
				System.out.println(testdata[1]);
				
				//update the role if found
				RoleManagementData roleManagementDataObj2 = new RoleManagementData();
				testdata = roleManagementDataObj2.getAddRolesData(tdImport);
				expectedArray.add(testdata[0]);
				expectedArray.add(testdata[1]);
				expectedArray.add(testdata[2]);
			
				
				editRolesObj.editRoles(testdata[0], testdata[1], testdata[2]);
				Thread.sleep(2000);
				waitForElementToLoad (editRolesObj.cancelButton);
				editRolesObj.cancelButton.click();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid cancel edit failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
	}
	
	@Test(priority = 2)
	public void validroledeletion () {
		try {
				log.info("valid roles selection and delete");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify search");
				eTest.assignCategory("search user");

				// valid roles deletion once selected
				RoleManagementData roleManagementDataObj = new RoleManagementData();
				testdata = roleManagementDataObj.getAddRolesData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.roleManagement(testdata[0], testdata[1]);
				driver.findElement(By.xpath(" //td[contains(text(),'" + testdata[1] + "')]//following::td[contains(@value, 'Delete Role')]")).click();
				wait(500);
				driver.switchTo().alert().accept();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid deletion failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
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
			roleManagementObj = new RoleManagementObject(driver);
			addRolesObj = new AddRolesObject(driver);
			editRolesObj = new EditRolesObject(driver);
			tdImport.readExcel("LoginData");
				
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
