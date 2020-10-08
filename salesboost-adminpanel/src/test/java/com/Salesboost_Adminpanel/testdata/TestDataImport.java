package com.Salesboost_Adminpanel.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Salesboost_Adminpanel.baseclass.BaseClass;

public class TestDataImport extends BaseClass {
	
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static Cell cell;
	FileInputStream inFile;
	FileOutputStream outFile;
	String cellData = "";
	
	// Reading excel file
	public void readExcel(String sheetName) {
		try {
			log.info("Entered readExcel method");
			inFile = new FileInputStream(excelPath);
			wb = new XSSFWorkbook(inFile);

			log.info("sheets"+wb.getNumberOfSheets());
			System.out.println(sheetName);
			sh= wb.getSheet(sheetName);
			log.info(sh==null?"yes":"no");

			}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("readExcel Failed");
			}
	}
	
	// get values from file
	public String getValue(int i, int j) {
		try {
			log.info("Entered getValue method");
			cellData = sh.getRow(i).getCell(j).toString();
			System.out.println(cellData+"::");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cellData;
	}
	
	// set value in file
	public void setValue(int row, int col, String value) {
		try {
			outFile =new FileOutputStream(new File(excelPath));
			cell = sh.getRow(row).getCell(col);
			cell.setCellValue(value);          
            wb.write(outFile);
            outFile.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed");
		}
	}

}
