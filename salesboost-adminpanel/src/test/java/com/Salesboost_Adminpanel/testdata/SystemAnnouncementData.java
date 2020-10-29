package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class SystemAnnouncementData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(9, 0);
		testdata[1] = tdImport.getValue(9, 1);
		return testdata;
	}
	
	public String[] getAddSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[8];
		testdata[0] = tdImport.getValue(10, 0);
		testdata[1] = tdImport.getValue(10, 1);
		testdata[2] = tdImport.getValue(10, 2);
		testdata[3] = tdImport.getValue(10, 2);
		testdata[4] = tdImport.getValue(10, 2);
		testdata[5] = tdImport.getValue(10, 2);
		testdata[6] = tdImport.getValue(10, 2);
		testdata[7] = tdImport.getValue(10, 2);
		return testdata;
	}
	
	public String[] getEditSystemAnnouncementData(TestDataImport tdImport) {
		testdata = new String[11];
		testdata[0] = tdImport.getValue(11, 0);
		testdata[1] = tdImport.getValue(11, 1);
		testdata[2] = tdImport.getValue(11, 2);
		testdata[3] = tdImport.getValue(11, 3);
		testdata[4] = tdImport.getValue(11, 4);
		testdata[5] = tdImport.getValue(11, 4);
		testdata[6] = tdImport.getValue(11, 4);
		testdata[7] = tdImport.getValue(11, 4);
		testdata[8] = tdImport.getValue(11, 4);
		testdata[9] = tdImport.getValue(11, 4);
		testdata[10] = tdImport.getValue(11, 4);
		return testdata;
	}
}
