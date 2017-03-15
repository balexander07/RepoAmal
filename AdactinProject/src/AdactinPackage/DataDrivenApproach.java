package AdactinPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDrivenApproach {
	public static String excelPath, URL, Browser;
	public static XSSFWorkbook workbook;
	public static WebDriver wd;

	public static void loadConfig() throws IOException
	{
		excelPath = "C:/Users/admin/Downloads/SampleFile.xlsx";
		workbook = new XSSFWorkbook(excelPath);
		Browser = workbook.getSheet("Config").getRow(0).getCell(1).getStringCellValue();
		URL = workbook.getSheet("Config").getRow(1).getCell(1).getStringCellValue();
	}
	
	public static void Login()
	{
		//System.setProperty("webdriver.gecko.driver", "C:/Users/admin/Downloads/geckodriver.exe");
		//WebDriver wd = new FirefoxDriver();
		wd.get(URL);
		
		wd.findElement(By.id("username")).sendKeys(workbook.getSheet("Login").getRow(1).getCell(0).getStringCellValue());
		wd.findElement(By.id("password")).sendKeys(workbook.getSheet("Login").getRow(1).getCell(1).getStringCellValue());
		wd.findElement(By.id("login")).click();
	}
	
	public static void initDriver()
	{
		switch(Browser.toLowerCase().trim())
		{
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "C:/Users/admin/Downloads/geckodriver.exe");
				wd = new FirefoxDriver();
				break;
				
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Downloads/chromedriver.exe");
				wd = new ChromeDriver();
				break;
		}
	}
	
	public static void writeExcel() throws IOException
	{
		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		workbook.close();
		fos.close();
	}
	
}
