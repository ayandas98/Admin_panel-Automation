package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class LeadershipToolData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(44, 1);
		testdata[1] = tdImport.getValue(44, 2);
		return testdata;
	}
	public String[] getAddLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(46, 1);
		testdata[1] = tdImport.getValue(46, 2);
		testdata[2] = tdImport.getValue(46, 3);
		return testdata;
	}
	
	public String[] getEditLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(48, 1);
		testdata[1] = tdImport.getValue(48, 2);
		testdata[2] = tdImport.getValue(48, 3);
		return testdata;
	}
	
	public String[] getAddPrivateLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(52, 1);
		testdata[1] = tdImport.getValue(52, 2);
		testdata[2] = tdImport.getValue(52, 3);
		testdata[3] = tdImport.getValue(52, 4);
		return testdata;
	}
	
	public String[] getEditPrivateLeadershipToolsData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(54, 1);
		testdata[1] = tdImport.getValue(54, 2);
		testdata[2] = tdImport.getValue(54, 3);
		testdata[3] = tdImport.getValue(54, 4);
		return testdata;
	}
	
	public String[] getDuplicateLeadershipToolData (TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(50, 1);
		testdata[1] = tdImport.getValue(50, 2);
		testdata[2] = tdImport.getValue(50, 3);
		return testdata;
	}
}
