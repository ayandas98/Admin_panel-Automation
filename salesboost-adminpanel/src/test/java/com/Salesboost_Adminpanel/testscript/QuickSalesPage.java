package com.Salesboost_Adminpanel.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
import com.Salesboost_Adminpanel.objectrepository.AddQuickSalesTips;
import com.Salesboost_Adminpanel.objectrepository.DashboardObject;
import com.Salesboost_Adminpanel.objectrepository.EditQuickSalesTip;
import com.Salesboost_Adminpanel.objectrepository.QuickTipsObject;
import com.Salesboost_Adminpanel.objectrepository.SignInObject;
import com.Salesboost_Adminpanel.testdata.QuickSalesTipsData;
import com.Salesboost_Adminpanel.testdata.TestDataImport;
import com.aventstack.extentreports.Status;

public class QuickSalesPage extends BaseClass{

	SignInObject signInObject;
	DashboardObject dashboardObj;
	QuickTipsObject quickTipsObj;
	AddQuickSalesTips addQuickSalesTips;
	EditQuickSalesTip editQuickSalesTip;
	QuickSalesTipsData quickSalesTipsData;
	TestDataImport tdImport;
	
	String getTextboxData="";
	String[] testdata;
	String[] testdata1;
	String[] testdata2;
	
	@Test(priority = 0)
	public void validAddSalesTips () {
		try {
				log.info("sales tips active: add new tips");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid add sales tip");
				eTest.assignCategory("quick sales");
				
				QuickSalesTipsData 	quickSalesTipsData = new 	QuickSalesTipsData();
				testdata = 	quickSalesTipsData.getAddSalesTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.salesTips.click();
				
				waitForElementToLoad(quickTipsObj.addButton);
				quickTipsObj.addButton.click();
				waitForElementToLoad(addQuickSalesTips.addButton);
				
				addQuickSalesTips.addQuickTips(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5]);
				waitForElementToLoad (addQuickSalesTips.postActive);
				waitForElementToLoad (addQuickSalesTips.addButton);
				addQuickSalesTips.postActive.click();
				addQuickSalesTips.addButton.click();	
				Thread.sleep(500);
				actualstring = addQuickSalesTips.actualVerificationText.getText();
				expectedstring = testdata[0];				
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid sales tips: post adding failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 1)
	public void validSalesTipsListing () {
		try {
				log.info("valid Sales tips listing");
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid sales tip listing");
				eTest.assignCategory("quick sales");

				// valid tracks selection
				QuickSalesTipsData 	quickSalesTipsData = new 	QuickSalesTipsData();
				testdata = 	quickSalesTipsData.getAddSalesTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.salesTips.click();

				waitForElementToLoad(quickTipsObj.addButton);
				quickTipsObj.quickTipsobject(testdata[0], testdata[1]);
				Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid sales tips listing failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
	}
	
	@Test(priority = 2)
	public void validInDeleteSalesTip () {
		try {
				log.info("valid Delete Sales tip");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("verify delete sales tip");
				eTest.assignCategory("quick sales");
/*				
				// add user	
				QuickSalesTipsData 	quickSalesTipsData = new QuickSalesTipsData();
				testdata = 	quickSalesTipsData.getAddSalesTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.salesTips.click();
				
				waitForElementToLoad(quickTipsObj.addButton);
				quickTipsObj.addButton.click();
				waitForElementToLoad(addQuickSalesTips.addButton);
				
				addQuickSalesTips.addQuickTips(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5]);
				waitForElementToLoad (addQuickSalesTips.addButton);
				addQuickSalesTips.addButton.click();	
				Thread.sleep(2000);
	*/			
				//search track from tracks list as there is no specified search button this step integrated with edit
				QuickSalesTipsData 	quickSalesTipsData1 = new 	QuickSalesTipsData();
				testdata = 	quickSalesTipsData1.getSalesTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.salesTips.click();

				waitForElementToLoad(quickTipsObj.addButton);
				quickTipsObj.quickTipsobject(testdata[0], testdata[1]);
				Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//delete sales tip
				Thread.sleep(1000);
				waitForElementToLoad (editQuickSalesTip.deleteButton);
				editQuickSalesTip.deleteButton.click();
				driver.switchTo().alert().accept();
				expectedstring = "Add New Sales Tip";
				actualstring = quickTipsObj.addButton.getText();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid delete sales tip failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertEquals(actualstring , expectedstring);
	}

	@Test(priority = 4)
	public void validEditSalesTip () {
		try {
				log.info("valid edit Sales tip");
				
				actualstring ="";
				actualArray = new ArrayList<>(); expectedArray = new ArrayList<String>();
				eTest = eReports.createTest("valid update sales tip");
				eTest.assignCategory("quick sales");
			
				// add user	
				QuickSalesTipsData 	quickSalesTipsData = new 	QuickSalesTipsData();
				testdata = 	quickSalesTipsData.getAddSalesTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.salesTips.click();
				
				waitForElementToLoad(quickTipsObj.addButton);
				quickTipsObj.addButton.click();
				waitForElementToLoad(addQuickSalesTips.addButton);
				
				addQuickSalesTips.addQuickTips(testdata[0], testdata[1], testdata[2], testdata[3], testdata[4], testdata[5]);
				waitForElementToLoad (addQuickSalesTips.addButton);
				addQuickSalesTips.addButton.click();	
				Thread.sleep(2000);
					
				//search track from tracks list as there is no specified search button this step integrated with edit
				QuickSalesTipsData 	quickSalesTipsData1 = new 	QuickSalesTipsData();
				testdata1 = 	quickSalesTipsData1.getSalesTipsData(tdImport);
			
				dashboardObj.contentTab.click();
				dashboardObj.salesTips.click();

				waitForElementToLoad(quickTipsObj.addButton);
				quickTipsObj.quickTipsobject(testdata1[0], testdata1[1]);
				//Thread.sleep(1000);
				driver.findElement(By.xpath(" //a[contains(text(),'" + testdata1[1] + "')]")).click();
				System.out.println(testdata[1]);
				
				//update the user if user found
				QuickSalesTipsData 	quickSalesTipsData2 = new 	QuickSalesTipsData();
				testdata2 = 	quickSalesTipsData2.getEditSalesTipsData(tdImport);
			
				editQuickSalesTip.editSalesTip(testdata2[0], testdata2[1], testdata2[2], testdata2[3], testdata2[4], testdata2[5], testdata2[6]);
				Thread.sleep(2000);
				waitForElementToLoad (editQuickSalesTip.tipActive);
				waitForElementToLoad (editQuickSalesTip.updateButton);	
				editQuickSalesTip.tipActive.click();
				editQuickSalesTip.updateButton.click();
				actualstring =editQuickSalesTip.actualVerificationText.getText();
				expectedstring = testdata[0];
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("valid edit sales tip failed");
			eTest.log(Status.FAIL,"Exception: "+ e);
		}	
		System.out.println("Actual: " + actualstring + "\nExpected: " + expectedstring);
		Assert.assertTrue(actualstring.contains(expectedstring));
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
			quickTipsObj = new QuickTipsObject(driver);
			addQuickSalesTips = new AddQuickSalesTips(driver);
			editQuickSalesTip = new EditQuickSalesTip(driver);
			tdImport.readExcel("SalesData");
				
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
