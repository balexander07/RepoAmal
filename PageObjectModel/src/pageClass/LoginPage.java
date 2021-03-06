package pageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="username")
	WebElement txtUserName;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[5]/td[2]/div/b")
	WebElement txtInvalidLogin;
	
	public LoginPage()
	{
		PageFactory.initElements(Keywords.getDriver(), this);
	}
	
	public String getTextUserName()
	{
		return txtUserName.getAttribute("value");
	}
	
	public String getTextPassword()
	{
		return txtPassword.getAttribute("value");
	}
	
	public WebElement getBtnLogin()
	{
		return btnLogin;
	}
	
	public String getTextInvalidLogin()
	{
		return txtInvalidLogin.getText();
	}
	
	public void setTextUserName(String text)
	{
		txtUserName.clear();
		txtUserName.sendKeys(text);
	}
	
	public void setTextPassword(String text)
	{
		txtPassword.clear();
		txtPassword.sendKeys(text);
	}
	
	public void clickBtnLogin()
	{
		btnLogin.click();
	}
}
