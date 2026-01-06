package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.Excelutility;

public class LogoutTest extends Base{

	@Test
	public void verifyuserisabletologoutfrompage() throws IOException
	{
	
	LoginPage loginpage=new LoginPage(driver);
	//String user="admin";
	//String passwd="admin";
	String user=Excelutility.readStringData(1, 0,"Loginpage");
	String passwd=Excelutility.readStringData(1, 1, "Loginpage");
	loginpage.enterTheUsername(user);
	loginpage.enterThePassword(passwd);
	loginpage.clickSignin();
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.clickAdminUser();
		logoutpage.clickLogout();

}
	
}

