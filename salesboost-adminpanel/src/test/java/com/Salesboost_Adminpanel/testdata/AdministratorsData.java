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
		testdata[0] = tdImport.getValue(3, 0);
		testdata[1] = tdImport.getValue(3, 1);
		testdata[2] = tdImport.getValue(3, 2);
		testdata[3] = tdImport.getValue(3, 3);
		return testdata;
	}
	
	public String[] getEditUserData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(4, 0);
		testdata[1] = tdImport.getValue(4, 1);
		testdata[2] = tdImport.getValue(4, 2);
		testdata[3] = tdImport.getValue(4, 3);
		return testdata;
	}
}
