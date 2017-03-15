package KeywordDrivenPackage;

//import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class keywords extends KeywordDriver
{
	//static keywords objKeyword = new keywords();
	
	public static void performAction(String locator, String locatorValue, String keyword, String parameter)
	{
		//wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		switch(keyword.toLowerCase().trim())
		{
		case "entertext":
			enterText(getObj(locator, locatorValue), parameter);
			break;
			
		case "clickbutton":
			clickButton(getObj(locator, locatorValue));
			break;
		
		case "selectvalue":
			selectValue(getObj(locator, locatorValue), parameter);
			break;
			
		case "verifytext":
			verifyText(getObj(locator, locatorValue), parameter);
			break;
		}
	}
	
	public static void enterText(By by, String parameter)
	{
		wd.findElement(by).clear();
		wd.findElement(by).sendKeys(parameter);
	}
	
	public static void clickButton(By by)
	{
		wd.findElement(by).click();
	}
	
	public static void selectValue(By by, String parameter)
	{
		Select select = new Select(wd.findElement(by));
		select.selectByVisibleText(parameter);
	}
	
	public static Boolean verifyText(By by, String parameter)
	{
		String tmp = wd.findElement(by).getText();
		//System.out.println(tmp);
		//wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (tmp == parameter)
		{
			System.out.println("Matching");
			return true;
		}
		else
		{
			System.out.println("Not Matching");
			return false;
		}
	}
	
	public static String getParamValue(int rowNum, String value)
	{
		String text;
		if (value.charAt(0) != '<')
			text = value;
		else
		{
			int colNo;
			colNo = getColNo(value.substring(1, value.length()-1));
			text = workbook.getSheet("TestData").getRow(rowNum).getCell(colNo).getStringCellValue();
		}
		return text;
	}
	
	public static int getColNo(String text)
	{
		int column = -1;
		for (Cell cell:workbook.getSheet("TestData").getRow(0))
			if(cell.getStringCellValue().equals(text))
				column = cell.getColumnIndex();
		return column;
	}
	
	public static By getObj(String locator, String locatorValue)
	{
		By by = null;
		switch(locator.toLowerCase().trim())
		{
			case "id":
				by = By.id(locatorValue);
				break;
			
			case "xpath":
				by = By.xpath(locatorValue);
				break;
				
			case "linktext":
				by = By.linkText(locatorValue);
				break;
		}
		
		return by;
	}
}
