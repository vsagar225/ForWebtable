package pack1;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	 public String valueText=null;
    public String readExcel(String filePath,String fileName,String sheetName) throws IOException{
   
    //Create an object of File class to open xlsx file

    File file =    new File(filePath+"\\"+fileName);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);

    Workbook guru99Workbook = null;

    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    guru99Workbook = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of HSSFWorkbook class

        guru99Workbook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

    //Find number of rows in excel file

    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

    //Create a loop over all the rows of excel file to read it

    for (int i = 0; i < rowCount+1; i++) {

        Row row = guru99Sheet.getRow(i);

        //Create a loop to print cell values in a row

        for (int j = 0; j < row.getLastCellNum(); j++) {

            //Print Excel data in console

            System.out.print("Row=" +i+ " Column = "+j+"Value = "+row.getCell(j).getStringCellValue()+"|| ");
            valueText=row.getCell(j).getStringCellValue();
        }

        System.out.println();
    }
	return valueText; 

    }  


    public String ReadCellData(int vRow, int vColumn)  
    {  
//    String value;  
    String value3=null;//variable for storing the cell value  
    Workbook wb=null;           //initialize Workbook null  
    try  
    {  
    //reading data from a file in the form of bytes  
    FileInputStream fis=new FileInputStream("C:\\Sagar\\Selenium\\Test1.xlsx");  
    //constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
    wb=new XSSFWorkbook(fis);  
    }  
    catch(FileNotFoundException e)  
    {  
    e.printStackTrace();  
    }  
    catch(IOException e1)  
    {  
    e1.printStackTrace();  
    }  
    Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
    Row row=sheet.getRow(vRow); //returns the logical row  
    Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
    value3=cell.getStringCellValue();    //getting cell value  
//    value=(int) cell.getNumericCellValue();

    
    return value3;               //returns the cell value  
    }  
    

    
    
}