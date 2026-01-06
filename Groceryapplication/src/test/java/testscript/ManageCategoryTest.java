package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import pages.ManageFooterTextPage;
import utilities.Excelutility;

public class ManageCategoryTest extends Base{
	
	
@Test(priority=1,groups= {"regression"},retryAnalyzer=retry.Retry.class)	
	public void verifyuserisabletoenternewcategorydetails() throws IOException
	{
	
	LoginPage loginpage=new LoginPage(driver);
	//String user="admin";
	//String passwd="admin";
	String user=Excelutility.readStringData(1, 0,"Loginpage");
	String passwd=Excelutility.readStringData(1, 1, "Loginpage");
	loginpage.enterTheUsername(user);
	loginpage.enterThePassword(passwd);
	loginpage.clickSignin();
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		String category=Excelutility.readStringData(1, 0,"Managecategory");	
		managecategorypage.clickManageCategory();
		managecategorypage.clicknewManageCategory();
		managecategorypage.enterCategoryDetails(category);
		managecategorypage.clickSavebutton();
		boolean alert=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert);
		managecategorypage.clickHomeButton();
		
		
	}
	



}
