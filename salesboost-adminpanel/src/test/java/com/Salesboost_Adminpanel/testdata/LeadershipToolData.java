package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class LeadershipToolData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 0);
		testdata[1] = tdImport.getValue(2, 1);
		return testdata;
	}
	public String[] getAddLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(2, 3);
		testdata[1] = tdImport.getValue(2, 4);
		testdata[2] = tdImport.getValue(2, 5);
		return testdata;
	}
	
	public String[] getEditLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(2, 7);
		testdata[1] = tdImport.getValue(2, 8);
		testdata[2] = tdImport.getValue(2, 9);
		return testdata;
	}

	public String[] getDuplicateLeadershipToolData (TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(2, 11);
		testdata[1] = tdImport.getValue(2, 12);
		testdata[2] = tdImport.getValue(2, 13);
		return testdata;
	}

	public String[] getAddSuppKitData (TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 15);
		testdata[1] = projectFolder + tdImport.getValue(2, 16);
		return testdata;
	}
	public String[] getEditSuppKitData (TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 15);
		testdata[1] = projectFolder + tdImport.getValue(2, 16);
		return testdata;
	}
}
