package com.Salesboost_Adminpanel.testdata;

import java.util.Locale;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class CoursesDataImport extends BaseClass{
	Locale local = new Locale("en-IND");
	
	//TestDataImport tdImport = new TestDataImport();
	String[] testData;
	
	public String[] AddCourseData(TestDataImport tdImport) {
		testData = new String[9];	
		testData[0] = tdImport.getValue(1, 2);
		testData[1] = tdImport.getValue(1, 3);
		testData[2] = tdImport.getValue(1, 4);
		testData[3] = tdImport.getValue(1, 5);
		testData[4] = tdImport.getValue(1, 6);
		testData[5] = tdImport.getValue(1, 7);
		testData[6] = projectFolder +tdImport.getValue(1, 8);
		testData[7] = tdImport.getValue(1, 9);
		testData[8] = tdImport.getValue(7, 0);
		return testData;
	}
	
	public String[] LATData(TestDataImport tdImport) {
		testData = new String[4];	
		testData[0] = projectFolder +tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		testData[3] = tdImport.getValue(7, 0);
		return testData;
	
	}
	
	public String[] PVOData(TestDataImport tdImport) {
		testData = new String[12];	
		testData[0] = projectFolder +tdImport.getValue(2, 0);
		testData[1] = projectFolder +tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		testData[3] = tdImport.getValue(2, 3);
		testData[4] = tdImport.getValue(2, 4);
		testData[5] = tdImport.getValue(2, 5);
		testData[6] = tdImport.getValue(2, 6);
		testData[7] = tdImport.getValue(2, 7);
		testData[8] = tdImport.getValue(2, 8);
		testData[9] = tdImport.getValue(2, 9);
		testData[10] = tdImport.getValue(2, 10);
		testData[11] = tdImport.getValue(7, 0);
		
		return testData;
	}
	
	public String[] FAQData(TestDataImport tdImport) {
		testData = new String[3];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(7, 0);
	
		return testData;
	}
	
	public String[] ATAData(TestDataImport tdImport) {
		testData = new String[7];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = projectFolder +tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		testData[3] = projectFolder +tdImport.getValue(2, 3);
		testData[4] = tdImport.getValue(2, 4);
		testData[5] = tdImport.getValue(2, 5);
		testData[6] = tdImport.getValue(7, 0);
		
		return testData;
	}
	
	public String[] AssociatedFilesData(TestDataImport tdImport) {
		testData = new String[4];	
		testData[0] = projectFolder +tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		testData[3] = tdImport.getValue(7, 0);
	
		return testData;
	}
	
	public String[] AwardData(TestDataImport tdImport) {
		testData = new String[6];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		testData[3] = projectFolder +tdImport.getValue(2, 3);
		testData[4] = projectFolder +tdImport.getValue(2, 4);
		testData[5] = tdImport.getValue(7, 0);
		
		return testData;
	}
	public String[] coursesFilterList(TestDataImport tdImport) {
		testData = new String[3];	
		testData[0] = tdImport.getValue(2, 0);
		testData[1] = tdImport.getValue(2, 1);
		testData[2] = tdImport.getValue(2, 2);
		
		
		return testData;
		
	}
	
	public String[] ProcessRequestPageData(TestDataImport tdImport) {
		testData = new String[10];	
		testData[0] = tdImport.getValue(2, 0);//userName
		testData[1] = tdImport.getValue(2, 1);//First Name
		testData[2] = tdImport.getValue(2, 2);//Last Name
		testData[3] = tdImport.getValue(2, 3);//Email
		testData[4] = tdImport.getValue(2, 4);//Phone
		testData[5] = tdImport.getValue(2, 5);//Account Name
		testData[6] = tdImport.getValue(2, 6);//Property name
		testData[7] = tdImport.getValue(2, 7);//Level
		testData[8] = tdImport.getValue(2, 8);//Focus Track
		testData[9] = tdImport.getValue(2, 9);//Reporting manager
				
		return testData;
	}
}

