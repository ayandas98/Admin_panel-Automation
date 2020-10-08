package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class TracksData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getTracksData(TestDataImport tdImport) {
		testdata = new String[1];
		testdata[0] = tdImport.getValue(9, 0);
		return testdata;
	}
	
	public String[] getAddTrackData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(10, 0);
		testdata[1] = tdImport.getValue(10, 1);
		testdata[2] = tdImport.getValue(10, 2);
		testdata[3] = tdImport.getValue(10, 3);
		return testdata;
	}
}
