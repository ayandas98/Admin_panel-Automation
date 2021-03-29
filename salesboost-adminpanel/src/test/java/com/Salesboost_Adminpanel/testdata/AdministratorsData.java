package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class AdministratorsData extends BaseClass {

	Locale local = new Locale("en-IND");
	//TestDataImport tdImport = new TestDataImport();
	String[] testdata;
	
	public String[] getAdministratorPageData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 0);
		testdata[1] = tdImport.getValue(2, 1);
		return testdata;
	}

	public String[] getAddUserData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(2, 3);
		testdata[1] = tdImport.getValue(2, 4);
		testdata[2] = tdImport.getValue(2, 5);
		testdata[3] = tdImport.getValue(2, 6);
		return testdata;
	}

	public String[] getEditUserData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(2, 8);
		testdata[1] = tdImport.getValue(2, 9);
		testdata[2] = tdImport.getValue(2, 10);
		testdata[3] = tdImport.getValue(2, 11);
		return testdata;
	}
}
