package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;

	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'
	// and @class='small-box-footer']")WebElement adminusers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement adminusersnewbutton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernametext;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordtext;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement usertypedropdown;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
	WebElement adminusersave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*
	 * public void clickAdminUsers() { adminusers.click(); }
	 */

	public AdminUsersPage clickAdminUsersNewButton() {
		adminusersnewbutton.click();
		return this;
	}

	public AdminUsersPage enterUserCredentials(String username, String password) {
		usernametext.sendKeys(username);
		passwordtext.sendKeys(password);
		return this;
	}

	public AdminUsersPage selectUserType() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndexMethod(usertypedropdown, 2);
		return this;

	}

	public AdminUsersPage clickSaveUser() {
		adminusersave.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

}
