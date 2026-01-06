package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.Excelutility;

public class LoginTest extends Base {
	
	@Test(priority=1)
	
	public void verifyuserisabletologinusingvalidcredentials() throws IOException
	{
		LoginPage loginpage=new LoginPage(driver);
		//String user="admin";
		//String passwd="admin";
		String user=Excelutility.readStringData(1, 0,"Loginpage");
		String passwd=Excelutility.readStringData(1, 1, "Loginpage");
		loginpage.enterTheUsername(user);
		loginpage.enterThePassword(passwd);
		loginpage.clickSignin();
		boolean homepage=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage);
		
		
	}


}
