package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.Excelutility;

public class ManageNewsTest extends Base {
	LogoutPage logoutpage;
	ManageNewsPage managenewspage;

	@Test(priority = 1, groups = { "regression" },description = "Testcase to enter new news details")

	public void verifyUserIsAbleToClickManageNewsAndEnterText() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		// String user="admin";
		// String passwd="admin";
		String user = Excelutility.readStringData(1, 0, "Loginpage");
		String passwd = Excelutility.readStringData(1, 1, "Loginpage");
		loginpage.enterTheUsername(user).enterThePassword(passwd);
		logoutpage = loginpage.clickSignin();

		// ManageNewsPage newspage=new ManageNewsPage(driver);
		String text = Excelutility.readStringData(0, 0, "Managenews");
		managenewspage = logoutpage.clickManageNews();
		managenewspage.clickManageNewsNewButton().enterNewsText(text).clickSaveNews();

		// newspage.clickSaveNews();
		boolean alert = managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTNOTDISPLAYED);

	}

}
