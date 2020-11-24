package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class RoleManagementData extends BaseClass {

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getRolesData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(20, 1);
		testdata[1] = tdImport.getValue(20, 2);
		return testdata;
	}
	
	public String[] getAddRolesData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(22, 1);
		testdata[1] = tdImport.getValue(22, 2);
		//testdata[2] = tdImport.getValue(16, 2);
		return testdata;
	}
	
	public String[] getEditRolesData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(24, 1);
		testdata[1] = tdImport.getValue(24, 2);
		testdata[2] = tdImport.getValue(24, 3);
		return testdata;
	}
}
