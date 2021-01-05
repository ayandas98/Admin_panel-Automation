package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class TracksData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getTracksData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(56, 1);
		testdata[1] = tdImport.getValue(56, 2);
		return testdata;
	}
	
	public String[] getAddTrackData(TestDataImport tdImport) {
		testdata = new String[3];
		testdata[0] = tdImport.getValue(58, 1);
		testdata[1] = tdImport.getValue(58, 2);
		testdata[2] = tdImport.getValue(58, 3);
		return testdata;
	}
	
	public String[] getEditTrackData(TestDataImport tdImport) {
		testdata = new String[5];
		testdata[0] = tdImport.getValue(60, 1);
		testdata[1] = tdImport.getValue(60, 2);
		testdata[2] = tdImport.getValue(60, 3);
		testdata[3] = tdImport.getValue(60, 4);
		testdata[4] = tdImport.getValue(60, 5);
		return testdata;
	}
	
	public String[] getAddPrivateTrackData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(62, 1);
		testdata[1] = tdImport.getValue(62, 2);
		testdata[2] = tdImport.getValue(62, 3);
		testdata[3] = tdImport.getValue(62, 4);
		return testdata;
	}
	
	public String[] getEditPrivateTrackData(TestDataImport tdImport) {
		testdata = new String[6];
		testdata[0] = tdImport.getValue(64, 1);
		testdata[1] = tdImport.getValue(64, 2);
		testdata[2] = tdImport.getValue(64, 3);
		testdata[3] = tdImport.getValue(64, 4);
		testdata[4] = tdImport.getValue(64, 5);
		testdata[5] = tdImport.getValue(64, 6);
		return testdata;
	}
	
}
