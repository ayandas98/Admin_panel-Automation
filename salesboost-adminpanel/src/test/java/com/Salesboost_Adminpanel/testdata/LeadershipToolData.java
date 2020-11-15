package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class LeadershipToolData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(9, 0);
		testdata[1] = tdImport.getValue(9, 1);
		return testdata;
	}
	public String[] getAddLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(10, 0);
		testdata[1] = tdImport.getValue(10, 1);
		testdata[2] = tdImport.getValue(10, 2);
		return testdata;
	}
	
	public String[] getEditLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(11, 0);
		testdata[1] = tdImport.getValue(11, 1);
		testdata[2] = tdImport.getValue(11, 2);
		return testdata;
	}
	
	public String[] getAddPrivateLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(12, 0);
		testdata[1] = tdImport.getValue(12, 1);
		testdata[2] = tdImport.getValue(12, 2);
		testdata[3] = tdImport.getValue(12, 3);
		return testdata;
	}
	
	public String[] getEditPrivateLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(13, 0);
		testdata[1] = tdImport.getValue(13, 1);
		testdata[2] = tdImport.getValue(13, 2);
		testdata[3] = tdImport.getValue(13, 3);
		return testdata;
	}
	
	public String[] getDuplicateLeadershipToolData (TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(13, 0);
		testdata[1] = tdImport.getValue(13, 0);
		testdata[2] = tdImport.getValue(13, 0);
		return testdata;
	}
}
