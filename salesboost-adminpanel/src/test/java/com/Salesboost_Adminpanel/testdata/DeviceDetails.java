package com.Salesboost_Adminpanel.testdata;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class DeviceDetails extends BaseClass {

	TestDataImport tdImport = new TestDataImport();
	String[] deviceData;
	
	public String[] getDeviceData() {
		deviceData = new String[4];
		deviceData[0] = tdImport.getValue(1, 0);
		deviceData[1] = tdImport.getValue(1, 1);
		deviceData[2] = tdImport.getValue(1, 2);
		deviceData[3] = tdImport.getValue(1, 4);
		return deviceData;
	}
}
