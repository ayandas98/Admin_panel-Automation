package com.Salesboost_Adminpanel.testdata;
import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;
public class PrivateTracksData extends BaseClass{
	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getPrivateTracksData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(2, 0);
		testdata[1] = tdImport.getValue(2, 1);
		return testdata;
	}
	
	public String[] getAddPrivateTrackData(TestDataImport tdImport) {
		testdata = new String[4];
		testdata[0] = tdImport.getValue(2, 3);
		testdata[1] = tdImport.getValue(2, 4);
		testdata[2] = tdImport.getValue(2, 5);
		testdata[3] = tdImport.getValue(2, 6);
		return testdata;
	}
	
	public String[] getEditPrivateTrackData(TestDataImport tdImport) {
		testdata = new String[7];
		testdata[0] = tdImport.getValue(2, 8);
		testdata[1] = tdImport.getValue(2, 9);
		testdata[2] = tdImport.getValue(2, 10);
		testdata[3] = tdImport.getValue(2, 11);
		testdata[4] = tdImport.getValue(2, 12);
		testdata[5] = tdImport.getValue(2, 13);
		testdata[6] = tdImport.getValue(2, 14);
		return testdata;
	}
	
	public String[] getDeletePrivateTrackData(TestDataImport tdImport) {
		testdata = new String[1];
		testdata[0] = tdImport.getValue(2, 16);
		return testdata;
	}
	
}
