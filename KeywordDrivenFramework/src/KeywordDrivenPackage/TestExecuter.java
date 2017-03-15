package KeywordDrivenPackage;

//import java.io.IOException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;

public class TestExecuter extends KeywordDriver{
	
	public static keywords objKeyword = new keywords();
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		loadConfig();
		initDriver();
		Login();
		Thread.sleep(1000);
		
		for(Row rownum1:workbook.getSheet("TestData"))
		{
			if (rownum1 == workbook.getSheet("TestData").getRow(0))
				continue;
			
			for(Row rownum:workbook.getSheet("TestCase"))
			{
				if (rownum == workbook.getSheet("TestCase").getRow(0))
					continue;
				
				String locator = rownum.getCell(0).getStringCellValue();
				String locatorValue = rownum.getCell(1).getStringCellValue();
				String keyword = rownum.getCell(2).getStringCellValue();
				String parameter;
				
				if (rownum.getCell(3)!=null)
					//parameter = rownum.getCell(3).getStringCellValue();
					parameter = keywords.getParamValue(rownum1.getRowNum(), rownum.getCell(3).getStringCellValue());
				else
					parameter = "";
				
				/*if (parameter.matches("<Username>"))
				{
					if (rownum1 != workbook.getSheet("TestData").getRow(0))
						parameter = rownum1.getCell(0).getStringCellValue();
				}
				
				if (parameter.matches("<Password>"))
				{
					if (rownum1 != workbook.getSheet("TestData").getRow(0))
						parameter = rownum1.getCell(1).getStringCellValue();
				}*/
				
				keywords.performAction(locator, locatorValue, keyword, parameter);
				wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		}
	}
}
