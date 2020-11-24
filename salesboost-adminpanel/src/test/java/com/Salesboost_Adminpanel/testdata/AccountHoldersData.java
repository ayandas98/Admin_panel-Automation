package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AccountHoldersData extends BaseClass {

	Locale local = new Locale("en-IND");
	//TestDataImport tdImport = new TestDataImport();
	String[] testdata;
	
	public String[] getAccountHoldersData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(10, 0);
		testdata[1] = tdImport.getValue(10, 1);
		return testdata;
	}
	
	public String[] getAddAccountData(TestDataImport tdImport) {
		testdata = new String[6];
		testdata[0] = tdImport.getValue(12, 0);
		testdata[1] = tdImport.getValue(12, 1);
		testdata[2] = tdImport.getValue(12, 2);
		testdata[3] = tdImport.getValue(12, 3);
		testdata[4] = tdImport.getValue(12, 4);
		testdata[5] = tdImport.getValue(12, 5);
		return testdata;
	}
	
	public String[] getEditAccountData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(14, 0);
		testdata[1] = tdImport.getValue(14, 1);
		testdata[2] = tdImport.getValue(14, 2);
		testdata[3] = tdImport.getValue(14, 3);
		return testdata;
	}
	
	public String[] getAddWhitelabelAccountData(TestDataImport tdImport) {
		testdata = new String[15];
		testdata[0] = tdImport.getValue(16, 1);
		testdata[1] = tdImport.getValue(16, 2);
		testdata[2] = tdImport.getValue(16, 3);
		testdata[3] = tdImport.getValue(16, 4);
		testdata[4] = tdImport.getValue(16, 5);
		testdata[5] = tdImport.getValue(16, 6);
		testdata[6] = tdImport.getValue(16, 7);
		testdata[7] = tdImport.getValue(16, 8);
		testdata[8] = tdImport.getValue(16, 9);
		testdata[9] = tdImport.getValue(16, 10);
		testdata[10] = tdImport.getValue(16, 11);
		testdata[11] = tdImport.getValue(16, 12);
		testdata[12] = tdImport.getValue(16, 13);
		testdata[13] = tdImport.getValue(16, 14);
		testdata[14] = tdImport.getValue(16, 15);
		return testdata;
	}
	
	public String[] getEditWhitelabelAccountData(TestDataImport tdImport) {
		testdata = new String[13];
		testdata[0] = tdImport.getValue(18, 1);
		testdata[1] = tdImport.getValue(18, 2);
		testdata[2] = tdImport.getValue(18, 3);
		testdata[3] = tdImport.getValue(18, 4);
		testdata[4] = tdImport.getValue(18, 5);
		testdata[5] = tdImport.getValue(18, 6);
		testdata[6] = tdImport.getValue(18, 7);
		testdata[7] = tdImport.getValue(18, 8);
		testdata[8] = tdImport.getValue(18, 9);
		testdata[9] = tdImport.getValue(18, 10);
		testdata[10] = tdImport.getValue(18, 11);
		testdata[11] = tdImport.getValue(18, 12);
		testdata[12] = tdImport.getValue(18, 13);
		return testdata;
	}	
}
