package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
	String[] testdata2;
	
	@Test(priority = 0)
	public void validaddroles () {
		try {
				log.info("add new role");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid add role");
				eTest.assignCategory("role management");
				
				RoleManagementData roleManagementDataObj = new RoleManagementData();
				testdata = roleManagementDataObj.getAddRolesData(tdImport);
				
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.addButton.click();
				waitForElementToLoad(addRolesObj.roleName);
				
				addRolesObj.addRoles(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addRolesObj.addRoleButton);
				addRolesObj.addRoleButton.click();	
				Thread.sleep(2000);
				actualstring = rolesNameText(testdata[0]).getText();
				expectedstring = testdata[0];				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid role adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	/*
	@Test(priority = 1)
	public void validcanceladdroles () {
		try {
				log.info("cancel add new role");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("cancel add role");
				eTest.assignCategory("role management");
				
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
				
				addRolesObj.addRoles(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addRolesObj.cancelButton);
				addRolesObj.cancelButton.click();	
				Thread.sleep(2000);
								
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid cancel role adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}		
	}		*/
	
	@Test(priority = 2)
	public void validrolesselection () {
		try {
				log.info("valid roles selection");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid roles listing");
				eTest.assignCategory("role management");

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
	public void validroledeletion () {
		try {
				log.info("valid roles selection and delete");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify delete role");
				eTest.assignCategory("role management");
		/*		
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
				
				addRolesObj.addRoles(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addRolesObj.addRoleButton);
				addRolesObj.addRoleButton.click();
		*/		
				// valid roles deletion once selected
				RoleManagementData roleManagementDataObj1 = new RoleManagementData();
				testdata = roleManagementDataObj1.getRolesData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.roleManagement(testdata[0], testdata[1]);
				driver.findElement(By.xpath("//td[contains(text(),'" + testdata[1] + "')]//following::input[2]")).click();
				driver.switchTo().alert().accept();
				expectedstring = "Role Name";
				actualstring = roleManagementObj.valid.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid deletion failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}
	
	@Test(priority = 4)
	public void validEditRoles () {
		try {
				log.info("valid edit role");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify update role");
				eTest.assignCategory("role management");
				
				// add role
				RoleManagementData roleManagementDataObj = new RoleManagementData();
				testdata = roleManagementDataObj.getAddRolesData(tdImport);
				
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.addButton.click();
				waitForElementToLoad(addRolesObj.roleName);
				
				addRolesObj.addRoles(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addRolesObj.addRoleButton);
				addRolesObj.addRoleButton.click();	
				Thread.sleep(1000);
				
				//search role from roles list as there is no specified search button this step integrated with edit
				RoleManagementData roleManagementDataObj1 = new RoleManagementData();
				testdata = roleManagementDataObj1.getRolesData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.roleManagement(testdata[0], testdata[1]);
				
				RoleManagementData roleManagementDataObj2 = new RoleManagementData();
				testdata2 = roleManagementDataObj2.getEditRolesData(tdImport);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//td[contains(text(),'" + testdata[1] + "')]//following::input[1]")));
				driver.findElement(By.xpath("//td[contains(text(),'" + testdata[1] + "')]//following::input[1]")).click();
				Thread.sleep(1000);
					
				//update the role if found
				editRolesObj.editRoles(testdata2[0], testdata2[1], testdata2[2], testdata2[3]);
				waitForElementToLoad (editRolesObj.updateRoleButton);
				editRolesObj.updateRoleButton.click();
				expectedstring = testdata[0];
				actualstring = rolesNameText(testdata[0]).getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	} 
	/*
	@Test(priority = 4)
	public void validCancelEditRoles () {
		try {
				log.info("valid cancel edit role");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify cancel update role");
				eTest.assignCategory("role management");
				
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
				
				addRolesObj.addRoles(testdata[0], testdata[1], testdata[2]);
				waitForElementToLoad (addRolesObj.addRoleButton);
				addRolesObj.addRoleButton.click();	
						
				//search role from roles list as there is no specified search button this step integrated with edit
				RoleManagementData roleManagementDataObj1 = new RoleManagementData();
				testdata = roleManagementDataObj1.getAddRolesData(tdImport);
				dashboardObj.contentTab.click();
				dashboardObj.roleManagement.click();
				waitForElementToLoad(roleManagementObj.addButton);
				roleManagementObj.roleManagement(testdata[0], testdata[1]);
				RoleManagementData roleManagementDataObj2 = new RoleManagementData();
				testdata2 = roleManagementDataObj2.getAddRolesData(tdImport);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//td[contains(text(),'" + testdata[1] + "')]//following::input[1]")));
				driver.findElement(By.xpath("//td[contains(text(),'" + testdata[1] + "')]//following::input[1]")).click();
				System.out.println(testdata[1]);
				
				//update the role if found
				expectedArray.add(testdata[0]);
				expectedArray.add(testdata[1]);
				expectedArray.add(testdata[2]);
						
				editRolesObj.editRoles(testdata2[0], testdata2[1], testdata2[2], testdata2[3]);
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
	*/
	
	public static WebElement rolesNameText(String rolesName)
	{
	    WebElement rolesVerificationText =  driver.findElement(By.xpath("//td[contains(text(),'"+rolesName+"')]"));
	    return rolesVerificationText;
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
			tdImport.readExcel("RoleManagementData");
				
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
