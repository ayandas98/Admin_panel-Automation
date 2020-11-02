package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class QuickSalesTipsData extends BaseClass{

	Locale local = new Locale("en-IND");
	String[] testdata;
	
	public String[] getSalesTipsData(TestDataImport tdImport) {
		testdata = new String[2];
		testdata[0] = tdImport.getValue(15, 0);
		testdata[1] = tdImport.getValue(15, 1);
		return testdata;
	}
	
	public String[] getAddSalesTipsData(TestDataImport tdImport) {
		testdata = new String[6];
		testdata[0] = tdImport.getValue(16, 0);
		testdata[1] = tdImport.getValue(16, 1);
		testdata[2] = tdImport.getValue(16, 2);
		testdata[3] = tdImport.getValue(16, 2);
		testdata[4] = tdImport.getValue(16, 2);
		testdata[5] = tdImport.getValue(16, 2);
		return testdata;
	}
	
	public String[] getEditSalesTipsData(TestDataImport tdImport) {
		testdata = new String[7];
		testdata[0] = tdImport.getValue(16, 0);
		testdata[1] = tdImport.getValue(16, 1);
		testdata[2] = tdImport.getValue(16, 2);
		testdata[3] = tdImport.getValue(16, 2);
		testdata[4] = tdImport.getValue(16, 2);
		testdata[5] = tdImport.getValue(16, 2);
		testdata[6] = tdImport.getValue(16, 2);
		return testdata;
	}
}
