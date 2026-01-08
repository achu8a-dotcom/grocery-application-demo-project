package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.Excelutility;

public class LoginTest extends Base {

	@Test(priority = 1, groups = { "regression" },description = "Testcase to verify login using different username & password combinations")

	public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		// String user="admin";
		// String passwd="admin";
		String user = Excelutility.readStringData(1, 0, "Loginpage");
		String passwd = Excelutility.readStringData(1, 1, "Loginpage");
		loginpage.enterTheUsername(user);
		loginpage.enterThePassword(passwd);
		loginpage.clickSignin();
		boolean homepage = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage, Constant.LOGINVALIDCREDENTIALS);

	}

	@Test(priority = 2)
	public void verifyUserIsUnableToLoginUsingInvalidUsernameAndValidPassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		// String user="admin58";
		// String passwd="admin";
		String user = Excelutility.readStringData(2, 0, "Loginpage");
		String passwd = Excelutility.readStringData(2, 1, "Loginpage");
		loginpage.enterTheUsername(user);
		loginpage.enterThePassword(passwd);
		loginpage.clickSignin();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTNOTDISPLAYED);
	}

	@Test(priority = 3)
	public void verifyUserIsUnableToLoginUsingValidUsernameAndInvalidPassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		// String user="admin";
		// String passwd="adam";
		String user = Excelutility.readStringData(3, 0, "Loginpage");
		String passwd = Excelutility.readStringData(3, 1, "Loginpage");
		loginpage.enterTheUsername(user);
		loginpage.enterThePassword(passwd);
		loginpage.clickSignin();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTNOTDISPLAYED);

	}

	@Test(priority = 4)
	public void verifyUserIsUnableToLoginUsingInvalidUsernameAndInvalidPassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		// String user="admin58";
		// String passwd="adam";
		String user = Excelutility.readStringData(4, 0, "Loginpage");
		String passwd = Excelutility.readStringData(4, 1, "Loginpage");
		loginpage.enterTheUsername(user);
		loginpage.enterThePassword(passwd);
		loginpage.clickSignin();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ALERTNOTDISPLAYED);

	}

}
