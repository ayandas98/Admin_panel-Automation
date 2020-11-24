package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class LeadershipTipsData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getLeadershipTipsData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(38, 1);
		testdata[1] = tdImport.getValue(38, 2);
		return testdata;
	}
	
	public String[] getAddLeadershipTipsData(TestDataImport tdImport) {
		testdata = new String[7];
		testdata[0] = tdImport.getValue(40, 1);
		testdata[1] = tdImport.getValue(40, 2);
		testdata[2] = tdImport.getValue(40, 3);
		testdata[3] = tdImport.getValue(40, 4);
		testdata[4] = tdImport.getValue(40, 5);
		testdata[5] = tdImport.getValue(40, 6);
		testdata[6] = tdImport.getValue(40, 7);
		return testdata;
	}
	
	public String[] getEditLeadershipTipsData(TestDataImport tdImport) {
		testdata = new String[9];
		testdata[0] = tdImport.getValue(42, 1);
		testdata[1] = tdImport.getValue(42, 2);
		testdata[2] = tdImport.getValue(42, 3);
		testdata[3] = tdImport.getValue(42, 4);
		testdata[4] = tdImport.getValue(42, 5);
		testdata[5] = tdImport.getValue(42, 6);
		testdata[6] = tdImport.getValue(42, 7);
		testdata[7] = tdImport.getValue(42, 8);
		testdata[8] = tdImport.getValue(42, 9);
		return testdata;
	}
}
