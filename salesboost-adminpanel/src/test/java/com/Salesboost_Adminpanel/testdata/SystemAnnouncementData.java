package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class SystemAnnouncementData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(26, 1);
		testdata[1] = tdImport.getValue(26, 2);
		return testdata;
	}
	
	public String[] getAddSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[8];
		testdata[0] = tdImport.getValue(28, 1);
		testdata[1] = tdImport.getValue(28, 2);
		testdata[2] = tdImport.getValue(28, 3);
		testdata[3] = tdImport.getValue(28, 4);
		testdata[4] = tdImport.getValue(28, 5);
		testdata[5] = tdImport.getValue(28, 6);
		testdata[6] = tdImport.getValue(28, 7);
		testdata[7] = tdImport.getValue(28, 8);
		return testdata;
	}
	
	public String[] getEditSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[11];
		testdata[0] = tdImport.getValue(30, 1);
		testdata[1] = tdImport.getValue(30, 2);
		testdata[2] = tdImport.getValue(30, 3);
		testdata[3] = tdImport.getValue(30, 4);
		testdata[4] = tdImport.getValue(30, 5);
		testdata[5] = tdImport.getValue(30, 6);
		testdata[6] = tdImport.getValue(30, 7);
		testdata[7] = tdImport.getValue(30, 8);
		testdata[8] = tdImport.getValue(30, 9);
		testdata[9] = tdImport.getValue(30, 10);
		testdata[10] = tdImport.getValue(30, 11);
		return testdata;
	}
}
