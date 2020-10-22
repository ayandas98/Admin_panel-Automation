package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class RoleManagementData extends BaseClass {

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getRolesData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(15, 0);
		testdata[1] = tdImport.getValue(15, 1);
		return testdata;
	}
	
	public String[] getAddRolesData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(16, 0);
		testdata[1] = tdImport.getValue(16, 1);
		testdata[2] = tdImport.getValue(16, 2);
		return testdata;
	}
	
	public String[] getEditRolesData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(17, 0);
		testdata[1] = tdImport.getValue(17, 1);
		testdata[2] = tdImport.getValue(17, 2);
		return testdata;
	}
}
