package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class TracksData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getTracksData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 0);
		testdata[1] = tdImport.getValue(2, 1);
		return testdata;
	}
	
	public String[] getAddTrackData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(2, 3);
		testdata[1] = tdImport.getValue(2, 4);
		testdata[2] = tdImport.getValue(2, 5);
		return testdata;
	}
	
	public String[] getEditTrackData(TestDataImport tdImport) {
		testdata = new String[5];
		testdata[0] = tdImport.getValue(2, 7);
		testdata[1] = tdImport.getValue(2, 8);
		testdata[2] = tdImport.getValue(2, 9);
		testdata[3] = tdImport.getValue(2, 10);
		testdata[4] = tdImport.getValue(2, 11);
		testdata[5] = tdImport.getValue(2, 12);
		return testdata;
	}
}
