package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import utilities.Excelutility;

public class ManageFooterTextTest extends Base{
	
	@Test
	public void verifyuserisabletoupdatemanagefooterdetails() throws IOException
	{
	
	LoginPage loginpage=new LoginPage(driver);
	//String user="admin";
	//String passwd="admin";
	String user=Excelutility.readStringData(1, 0,"Loginpage");
	String passwd=Excelutility.readStringData(1, 1, "Loginpage");
	loginpage.enterTheUsername(user);
	loginpage.enterThePassword(passwd);
	loginpage.clickSignin();
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		String phone=Excelutility.readIntegerData(1, 0,"Managecontact");
		String email=Excelutility.readStringData(1, 1,"Managecontact");		
		managefootertextpage.clickManageFooterText();
		managefootertextpage.clickManageFooteredit();
		managefootertextpage.UpdateContactDetails(phone, email);
		managefootertextpage.clickUpdatebutton();
		boolean alert=managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(alert);
		managefootertextpage.clickHomeButton();
		
		
	}
	

}
