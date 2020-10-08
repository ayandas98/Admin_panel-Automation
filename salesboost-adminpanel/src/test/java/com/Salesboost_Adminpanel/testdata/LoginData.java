package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

	public class LoginData extends BaseClass {
		
		Locale local = new Locale("en-IND");
////		TestDataImport tdImport = new TestDataImport();
//		TestDataImport tdImport;
		String[] testdata;
		
		public String[] getSignInData(TestDataImport tdImport) {

//			tdImport.readExcel("Data");
			testdata = new String[2];
			testdata[0] = tdImport.getValue(0, 0);
			testdata[1] = tdImport.getValue(0, 1);
			return testdata;
		}
}
