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
	
	public String[] getAddWhitelabelAccountData(TestDataImport tdImport) {
		testdata = new String[15];
		testdata[0] = tdImport.getValue(14, 0);
		testdata[1] = tdImport.getValue(14, 1);
		testdata[2] = tdImport.getValue(14, 2);
		testdata[3] = tdImport.getValue(14, 3);
		testdata[4] = tdImport.getValue(14, 4);
		testdata[5] = tdImport.getValue(14, 5);
		testdata[6] = tdImport.getValue(14, 6);
		testdata[7] = tdImport.getValue(14, 7);
		testdata[8] = tdImport.getValue(14, 8);
		testdata[9] = tdImport.getValue(14, 9);
		testdata[10] = tdImport.getValue(14, 10);
		testdata[11] = tdImport.getValue(14, 11);
		testdata[12] = tdImport.getValue(14, 12);
		testdata[13] = tdImport.getValue(14, 13);
		testdata[14] = tdImport.getValue(14, 14);
		return testdata;
	}
	
	public String[] getEditWhitelabelAccountData(TestDataImport tdImport) {
		testdata = new String[13];
		testdata[0] = tdImport.getValue(15, 0);
		testdata[1] = tdImport.getValue(15, 1);
		testdata[2] = tdImport.getValue(15, 2);
		testdata[3] = tdImport.getValue(15, 3);
		testdata[4] = tdImport.getValue(15, 4);
		testdata[5] = tdImport.getValue(15, 5);
		testdata[6] = tdImport.getValue(15, 6);
		testdata[7] = tdImport.getValue(15, 7);
		testdata[8] = tdImport.getValue(15, 8);
		testdata[9] = tdImport.getValue(15, 9);
		testdata[10] = tdImport.getValue(15, 10);
		testdata[11] = tdImport.getValue(15, 11);
		testdata[12] = tdImport.getValue(15, 12);
		return testdata;
	}	
}
