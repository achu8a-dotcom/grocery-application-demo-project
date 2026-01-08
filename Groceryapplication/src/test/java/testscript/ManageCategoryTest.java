package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import pages.ManageFooterTextPage;
import utilities.Excelutility;

public class ManageCategoryTest extends Base {
	LogoutPage logoutpage;
	ManageCategoryPage managecategorypage;

	@Test(priority = 1, groups = { "regression" },description = "Testcase to create new category details")
	public void verifyUserIsAbleToEnterNewCategoryDetails() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		// String user="admin";
		// String passwd="admin";
		String user = Excelutility.readStringData(1, 0, "Loginpage");
		String passwd = Excelutility.readStringData(1, 1, "Loginpage");
		loginpage.enterTheUsername(user).enterThePassword(passwd);
  //	loginpage.enterThePassword(passwd);
		logoutpage = loginpage.clickSignin();
		// ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		String categ = Excelutility.readStringData(1, 0, "Managecategory");
		managecategorypage = logoutpage.clickManageCategory();
		managecategorypage.clickNewManageCategory().enterCategoryDetails(categ).clickSaveButton();
		// managecategorypage.enterCategoryDetails(category);
		// managecategorypage.clickSavebutton();
		boolean alert = managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTNOTDISPLAYED);

	}

}
