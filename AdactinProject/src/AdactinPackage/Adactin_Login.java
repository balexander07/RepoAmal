package AdactinPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Adactin_Login {
	public static void main (String args[])
	{
		System.setProperty("webdriver.gecko.driver", "C:/Users/admin/Downloads/geckodriver.exe");
		WebDriver wd = new FirefoxDriver();
		wd.get("http://www.adactin.com/hotelapp");
	}
}
