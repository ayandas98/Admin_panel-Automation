package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class SystemAnnouncementData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 0);
		testdata[1] = tdImport.getValue(2, 1);
		return testdata;
	}
	
	public String[] getAddSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[8];
		testdata[0] = tdImport.getValue(34, 0);
		testdata[1] = tdImport.getValue(34, 1);
		testdata[2] = tdImport.getValue(34, 2);
		testdata[3] = tdImport.getValue(34, 3);
		testdata[4] = tdImport.getValue(34, 4);
		testdata[5] = tdImport.getValue(34, 5);
		testdata[6] = tdImport.getValue(34, 6);
		testdata[7] = tdImport.getValue(34, 7);
		return testdata;
	}
	
	public String[] getEditSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[11];
		testdata[0] = tdImport.getValue(67, 0);
		testdata[1] = tdImport.getValue(67, 1);
		testdata[2] = tdImport.getValue(67, 2);
		testdata[3] = tdImport.getValue(67, 3);
		testdata[4] = tdImport.getValue(67, 4);
		testdata[5] = tdImport.getValue(67, 5);
		testdata[6] = tdImport.getValue(67, 6);
		testdata[7] = tdImport.getValue(67, 7);
		testdata[8] = tdImport.getValue(67, 8);
		testdata[9] = tdImport.getValue(67, 9);
		testdata[10] = tdImport.getValue(67, 10);
		return testdata;
	}
}
