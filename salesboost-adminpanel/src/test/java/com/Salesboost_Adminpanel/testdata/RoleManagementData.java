package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class RoleManagementData extends BaseClass {

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getRolesData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 0);
		testdata[1] = tdImport.getValue(2, 1);
		return testdata;
	}
	
	public String[] getAddRolesData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(2, 3);
		testdata[1] = tdImport.getValue(2, 4);
		testdata[2] = projectFolder + tdImport.getValue(2, 5);
		return testdata;
	}
	
	public String[] getEditRolesData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(2, 7);
		testdata[1] = tdImport.getValue(2, 8);
		testdata[2] = projectFolder + tdImport.getValue(2, 9);
		testdata[3] = tdImport.getValue(2, 10);
		return testdata;
	}
}
