package genericLibraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;


	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Map;

	/**
	 * This class contains reusable to read data from excel file
	 * @author Nikhil
	 */

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Sheet;
	
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelUtility {
		private Workbook wb;
		
		/**
		 * This method is used to initialize excel
		 * @param excelPath
		 */
		public void excelIntialization(String excelPath) {
			FileInputStream fis=null;
			try {
				fis=new FileInputStream(excelPath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				 wb=WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		public Map<String ,String > readFromExcel(String sheetName,String exceptedTest)
		{
			Map<String , String> map=new HashMap<String, String>();
			
			DataFormatter df=new DataFormatter();
			
			Sheet sh=wb.getSheet(sheetName);
			
			for(int i=0;i<=sh.getLastRowNum();i++) 
			{
				
				if(df.formatCellValue(sh.getRow(i).getCell(1)).equals(exceptedTest))
				{
					for(int j=i;j<=sh.getLastRowNum();j++)
					{
						map.put(df.formatCellValue(sh.getRow(j).getCell(2)),df.formatCellValue(sh.getRow(j).getCell(3)) );
						
						if(df.formatCellValue(sh.getRow(j).getCell(2)).equals("####"))
						{
							break;
						}
						
					}
					break;
				}
			}
			return map;
		}
		
		/**
		 * This method is used to close excel
		 */
		public void closeExcel() {
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * This is method is used to update test status in excel
		 * @param SheetName 
		 * @param expectedTest
		 * @param status 
		 * @param excelPath
		 */
		public void writeToexcel(String sheetName,String expectedTest,String status ,String excelPath) {
			Sheet sh=wb.getSheet(sheetName);
			for(int i=0;i<=sh.getLastRowNum();i++) {
				
				if(sh.getRow(i).getCell(1).getStringCellValue().equals(expectedTest)) {
					sh.getRow(i).createCell(4).setCellValue(status);
					break;
				}
			}
			FileOutputStream fos=null;
			try {
				 fos=new FileOutputStream(excelPath);
			} catch (FileNotFoundException e){
				e.printStackTrace();
			
			}}}
		