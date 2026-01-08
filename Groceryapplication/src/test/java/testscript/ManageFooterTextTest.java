package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import utilities.Excelutility;

public class ManageFooterTextTest extends Base {

	LogoutPage logoutpage;
	ManageFooterTextPage managefootertextpage;

	@Test(priority = 1, groups = { "regression" },description = "Testcase to update footer text details")
	public void verifyUserIsAbleToUpdateManageFooterDetails() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		// String user="admin";
		// String passwd="admin";
		String user = Excelutility.readStringData(1, 0, "Loginpage");
		String passwd = Excelutility.readStringData(1, 1, "Loginpage");
		loginpage.enterTheUsername(user).enterThePassword(passwd);
		logoutpage = loginpage.clickSignin();
		// ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		String phno = Excelutility.readIntegerData(1, 0, "Managecontact");
		String mailid = Excelutility.readStringData(1, 1, "Managecontact");
		managefootertextpage = logoutpage.clickManageFooterText();

		managefootertextpage.clickManageFooterEdit().UpdateContactDetails(phno,mailid).clickUpdateButton();

		// managefootertextpage.UpdateContactDetails(phone, email);
		// managefootertextpage.clickUpdatebutton();
		boolean alert = managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTNOTDISPLAYED);

	}

}
