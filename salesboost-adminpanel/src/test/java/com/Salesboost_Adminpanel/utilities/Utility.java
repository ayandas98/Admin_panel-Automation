package com.Salesboost_Adminpanel.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class Utility extends BaseClass {
	
	TakesScreenshot takeScreenshot;
	File source, destination, dir;
	File[] files;
	byte[] buffer;
	FileOutputStream fos;
	ZipOutputStream zos;
	FileInputStream fis;
	int length;
	String screenshotPath = "";	
	String zipFile="C:\\Salesboost_Automation\\Report_Zip\\Report_"+reportTimestamp+".zip";

	public String[] directoryPath = {"C:/Salesboost_Automation","C:/Salesboost_Automation/Logs", "C:/Salesboost_Automation/Reports", 
			"C:/Salesboost_Automation/Reports/Report_"+reportTimestamp,"C:/Salesboost_Automation/Report_Zip","C:/Salesboost_Automation/Report_Zip/Report_"+reportTimestamp+".zip",zipFile};
	
	public String getScreenshot(WebDriver driver, String screenshotName) {
		try {
			takeScreenshot = (TakesScreenshot) driver;
			source = takeScreenshot.getScreenshotAs(OutputType.FILE);
			screenshotPath = reportDir+"/"+screenshotName+".png";
			destination = new File(screenshotPath);
			FileUtils.copyFile(source, destination);
			String[] relatvePath = destination.toString().split("Report_"+reportTimestamp);
	        screenshotPath = ".\\" + relatvePath[1];
		}catch(Exception e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}
	
	public void createZip(String source) {
		try {			
			buffer = new byte[1024];			 
            fos = new FileOutputStream(zipFile); 
            zos = new ZipOutputStream(fos); 
            dir = new File(source); 
            files = dir.listFiles();
			
            for (int i = 0; i < files.length; i++) {
            	 fis = new FileInputStream(files[i]);
            	 
            	 zos.putNextEntry(new ZipEntry(files[i].getName()));
            	             	 
                 while ((length = fis.read(buffer)) > 0) {
                     zos.write(buffer, 0, length);
                 }
                 zos.closeEntry();
                 fis.close();
            }
            zos.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void createDirectoryIfNotExist() {
		try {
			for(int i=0;i<directoryPath.length;i++) {
				directory = new File(directoryPath[i] + "[i].getFileName()");
				
			    if (! directory.exists()){			    	
			        directory.mkdir();
			        System.out.println(String.format("diretory %s created", directory));
			    }
			}			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
}