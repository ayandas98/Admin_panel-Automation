package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class LeadershipTipsData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getLeadershipTipsData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 0);
		testdata[1] = tdImport.getValue(2, 1);
		return testdata;
	}
	
	public String[] getAddLeadershipTipsData(TestDataImport tdImport) {
		testdata = new String[7];
		testdata[0] = tdImport.getValue(35, 0);
		testdata[1] = tdImport.getValue(35, 1);
		testdata[2] = tdImport.getValue(35, 2);
		testdata[3] = tdImport.getValue(35, 3);
		testdata[4] = tdImport.getValue(35, 4);
		testdata[5] = tdImport.getValue(35, 5);
		testdata[6] = tdImport.getValue(35, 6);
		return testdata;
	}
	
	public String[] getEditLeadershipTipsData(TestDataImport tdImport) {
		testdata = new String[9];
		testdata[0] = tdImport.getValue(63, 0);
		testdata[1] = tdImport.getValue(63, 1);
		testdata[2] = tdImport.getValue(63, 2);
		testdata[3] = tdImport.getValue(63, 3);
		testdata[4] = tdImport.getValue(63, 4);
		testdata[5] = tdImport.getValue(63, 5);
		testdata[6] = tdImport.getValue(63, 6);
		testdata[7] = tdImport.getValue(63, 7);
		testdata[8] = tdImport.getValue(63, 8);
		return testdata;
	}
}
