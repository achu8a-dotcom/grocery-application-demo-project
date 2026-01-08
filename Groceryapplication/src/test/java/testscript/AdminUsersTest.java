package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.Excelutility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	LogoutPage logoutpage;
	AdminUsersPage adminuserspage;

	@Test(priority = 1, groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "Testcase to create new admin credentials")
	public void verifyUserIsAbleToEnterNewAdminCredentials() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		// String user="admin";
		// String passwd="admin";
		String user = Excelutility.readStringData(1, 0, "Loginpage");
		String passwd = Excelutility.readStringData(1, 1, "Loginpage");
		loginpage.enterTheUsername(user).enterThePassword(passwd);
//	loginpage.enterThePassword(passwd);
		logoutpage = loginpage.clickSignin();
		// AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		FakerUtility fakerutility = new FakerUtility();
		String username = fakerutility.createRandomFirstName();
		String password = fakerutility.createRandomLastName();
		// String username=Excelutility.readStringData(1, 0,"Adminuser");
		// String password=Excelutility.readStringData(1, 1,"Adminuser");
		adminuserspage = logoutpage.clickAdminUsers();
		adminuserspage.clickAdminUsersNewButton().enterUserCredentials(username, password).selectUserType()
				.clickSaveUser();
		// adminuserspage.enterUsercredentials(username, password);
		// adminuserspage.selectUsertype();
		// adminuserspage.clickSaveUser();
		boolean alert = adminuserspage.isAlertDisplayed();
		Assert.assertTrue(alert);
		// adminuserspage.clickHomeButton();

	}

}
