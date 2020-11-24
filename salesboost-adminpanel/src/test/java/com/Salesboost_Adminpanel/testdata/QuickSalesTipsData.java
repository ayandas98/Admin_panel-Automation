package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class QuickSalesTipsData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getSalesTipsData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(32, 1);
		testdata[1] = tdImport.getValue(32, 2);
		return testdata;
	}
	
	public String[] getAddSalesTipsData(TestDataImport tdImport) {
		testdata = new String[6];
		testdata[0] = tdImport.getValue(34, 1);
		testdata[1] = tdImport.getValue(34, 2);
		testdata[2] = tdImport.getValue(34, 3);
		testdata[3] = tdImport.getValue(34, 4);
		testdata[4] = tdImport.getValue(34, 5);
		testdata[5] = tdImport.getValue(34, 6);
		return testdata;
	}
	
	public String[] getEditSalesTipsData(TestDataImport tdImport) {
		testdata = new String[7];
		testdata[0] = tdImport.getValue(36, 1);
		testdata[1] = tdImport.getValue(36, 2);
		testdata[2] = tdImport.getValue(36, 3);
		testdata[3] = tdImport.getValue(36, 4);
		testdata[4] = tdImport.getValue(36, 5);
		testdata[5] = tdImport.getValue(36, 6);
		testdata[6] = tdImport.getValue(36, 7);
		return testdata;
	}
}
