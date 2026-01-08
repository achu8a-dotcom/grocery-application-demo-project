package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import utilities.Excelutility;

public class ManageContactTest extends Base {

	LogoutPage logoutpage;
	ManageContactPage managecontactpage;

	@Test(priority = 1, groups = { "regression" },description = "Testcase to update contact details")

	public void verifyUserIsAbleToUpdateContactDetails() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		// String user="admin";
		// String passwd="admin";
		String user = Excelutility.readStringData(1, 0, "Loginpage");
		String passwd = Excelutility.readStringData(1, 1, "Loginpage");
		loginpage.enterTheUsername(user).enterThePassword(passwd);
   //	loginpage.enterThePassword(passwd);
		logoutpage = loginpage.clickSignin();

		// ManageContactPage managecontactpage=new ManageContactPage(driver);
		String phone = Excelutility.readIntegerData(1, 0, "Managecontact");
		String email = Excelutility.readStringData(1, 1, "Managecontact");
		managecontactpage = logoutpage.clickManageContact();
		managecontactpage.clickManageContactEdit().enterContactDetails(phone, email).clickUpdateButton();

		// managecontactpage.enterContactDetails(phone, email);
		// managecontactpage.clickUpdatebutton();
		boolean alert = managecontactpage.isAlertDisplayed();
		Assert.assertTrue(alert);

	}

}
