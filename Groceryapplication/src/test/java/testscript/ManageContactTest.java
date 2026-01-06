package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.Excelutility;

public class ManageContactTest extends Base {
	
	@Test
	
	public void verifyuserisabletoupdatecontactdetails() throws IOException
	{
	
	LoginPage loginpage=new LoginPage(driver);
	//String user="admin";
	//String passwd="admin";
	String user=Excelutility.readStringData(1, 0,"Loginpage");
	String passwd=Excelutility.readStringData(1, 1, "Loginpage");
	loginpage.enterTheUsername(user);
	loginpage.enterThePassword(passwd);
	loginpage.clickSignin();
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		String phone=Excelutility.readIntegerData(1, 0,"Managecontact");
		String email=Excelutility.readStringData(1, 1,"Managecontact");		
		managecontactpage.clickManageContact();
		managecontactpage.clickManageContactedit();
		managecontactpage.enterContactDetails(phone, email);
		managecontactpage.clickUpdatebutton();
		boolean alert=managecontactpage.isAlertDisplayed();
		Assert.assertTrue(alert);
		managecontactpage.clickHomeButton();
		
		
	}
	

}
