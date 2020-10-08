package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AccountHoldersData extends BaseClass {

	Locale local = new Locale("en-IND");
	//TestDataImport tdImport = new TestDataImport();
	String[] testdata;
	
	public String[] getAccountHoldersData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(5, 0);
		testdata[1] = tdImport.getValue(5, 1);
		return testdata;
	}
	
	public String[] getAddAccountData(TestDataImport tdImport) {
		testdata = new String[6];
		testdata[0] = tdImport.getValue(6, 0);
		testdata[1] = tdImport.getValue(6, 1);
		testdata[2] = tdImport.getValue(6, 2);
		testdata[3] = tdImport.getValue(6, 3);
		testdata[4] = tdImport.getValue(6, 4);
		testdata[5] = tdImport.getValue(6, 5);
		return testdata;
	}
	
	public String[] getEditAccountData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(7, 0);
		testdata[1] = tdImport.getValue(7, 1);
		testdata[2] = tdImport.getValue(7, 2);
		testdata[3] = tdImport.getValue(7, 3);
		return testdata;
	}
	
}
