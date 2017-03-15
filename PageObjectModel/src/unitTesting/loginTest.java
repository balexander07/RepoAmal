package unitTesting;


import java.util.concurrent.TimeUnit;

import pageClass.LoginPage;
import pageClass.Keywords;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class loginTest {

	LoginPage loginObj = new LoginPage();
	@Test
	public void testbTxtUserName() {
		loginObj.setTextUserName("alexander07");
		Assert.assertEquals("alexander07", loginObj.getTextUserName());
	}
	
	@Test
	public void testcTxtPassword() {
		loginObj.setTextPassword("dhanaraj07");
		Assert.assertEquals("dhanaraj07", loginObj.getTextPassword());
	}
	
	@Test
	public void testdclickBtnLogin() {
		loginObj.clickBtnLogin();
		Assert.assertEquals("AdactIn.com - Hotel Reservation System", Keywords.getDriver().getTitle());
	}
	
	@Test
	public void testaclickBtnLogin() {
		loginObj.setTextUserName("test");
		loginObj.setTextPassword("test");
		loginObj.clickBtnLogin();
		Keywords.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Assert.assertEquals("Invalid Login Details", loginObj.getTextInvalidLogin());
	}

}
