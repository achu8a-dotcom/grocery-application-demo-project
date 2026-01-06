package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.Excelutility;

public class AdminUsersTest extends Base{
	
	
	@Test
	public void verifyuserisabletoenternewadmincredentials() throws IOException
	{
	
	LoginPage loginpage=new LoginPage(driver);
	//String user="admin";
	//String passwd="admin";
	String user=Excelutility.readStringData(1, 0,"Loginpage");
	String passwd=Excelutility.readStringData(1, 1, "Loginpage");
	loginpage.enterTheUsername(user);
	loginpage.enterThePassword(passwd);
	loginpage.clickSignin();
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		String username=Excelutility.readStringData(1, 0,"Adminuser");
		String password=Excelutility.readStringData(1, 1,"Adminuser");		
		adminuserspage.clickAdminUsers();
		adminuserspage.clickAdminusersnewbutton();
		adminuserspage.enterUsercredentials(username, password);
		adminuserspage.selectUsertype();
		adminuserspage.clickSaveUser();
		boolean alert=adminuserspage.isAlertDisplayed();
		Assert.assertTrue(alert);
		adminuserspage.clickHomeButton();
		
		
	}
	

}
