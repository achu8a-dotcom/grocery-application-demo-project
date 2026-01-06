package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.Excelutility;

public class ManageNewsTest extends Base {
	
@Test(priority=1,groups= {"regression"},retryAnalyzer=retry.Retry.class)
	
	public void verifyuserisabletoclickmanagenewsandentertext() throws IOException
	{
	
	LoginPage loginpage=new LoginPage(driver);
	//String user="admin";
	//String passwd="admin";
	String user=Excelutility.readStringData(1, 0,"Loginpage");
	String passwd=Excelutility.readStringData(1, 1, "Loginpage");
	loginpage.enterTheUsername(user);
	loginpage.enterThePassword(passwd);
	loginpage.clickSignin();
		ManageNewsPage newspage=new ManageNewsPage(driver);
		String text=Excelutility.readStringData(0, 0,"Managenews");
		newspage.clickManageNews();
		newspage.clickManagenewsnewbutton();
		newspage.enterNewstext(text);
		newspage.clickSaveNews();
		boolean alert=newspage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
		
	}
	

}
