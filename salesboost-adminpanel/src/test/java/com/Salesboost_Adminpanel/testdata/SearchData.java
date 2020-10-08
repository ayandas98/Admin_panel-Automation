package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class SearchData extends BaseClass {

	Locale local = new Locale("en-IND");
	//TestDataImport tdImport = new TestDataImport();
	String[] testdata;
	
	public String[] getSearchPageData(TestDataImport tdImport) {
		testdata = new String[1];
		testdata[0] = tdImport.getValue(8, 0);
		return testdata;
	}
}
