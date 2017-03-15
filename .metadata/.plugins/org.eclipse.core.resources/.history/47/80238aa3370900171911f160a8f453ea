package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadNWrite {

	public static void main(String[] args) throws IOException {
//		XSSFWorkbook workbook = new XSSFWorkbook("C:/Users/admin/Documents/Sample.xlsx");
//		XSSFSheet sheet1 = workbook.getSheetAt(0);
//				
//		XSSFRow row = sheet1.getRow(0);
//		XSSFCell cell = row.getCell(0);
//		//System.out.println(cell.getStringCellValue());
//
//		
//		int sheetCount = workbook.getNumberOfSheets();
//		int rowCount = sheet1.getLastRowNum();		
//		int cellCount = row.getLastCellNum();
		
//		Iterator<Row> rowIterator = sheet1.iterator();
//		while(rowIterator.hasNext()){
//			Iterator<Cell> cellIterator = rowIterator.next().iterator();
//			while(cellIterator.hasNext())
//				System.out.print(cellIterator.next().getStringCellValue() + "\t");
//			System.out.println();
//		}
		
//		for(Row row1:sheet1){
//			for(Cell cell1:row1)
//				System.out.print(cell1.getStringCellValue() + "\t");
//			System.out.println();
//		}
//		
		//sheet1.getRow(6).getCell(0).setCellType(CellType.STRING);
		
		FileInputStream fis = new FileInputStream("C:/Users/admin/Documents/Sample1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		fis.close();
		
		workbook.getSheetAt(0).createRow(1).createCell(0).setCellValue("Writing");		
		FileOutputStream fos = new FileOutputStream("C:/Users/admin/Documents/Sample1.xlsx");
		workbook.write(fos);
		fos.close();

	}

}
