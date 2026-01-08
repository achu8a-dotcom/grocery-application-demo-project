package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LogoutPage {

	public WebDriver driver;

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement adminuser;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminusers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	WebElement managecategory;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	WebElement managecontact;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement managefootertext;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement managenews;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUsersPage clickAdminUsers() {

		adminusers.click();
		return new AdminUsersPage(driver);
	}

	public ManageCategoryPage clickManageCategory() {
		managecategory.click();
		return new ManageCategoryPage(driver);
	}

	public ManageContactPage clickManageContact() {
		managecontact.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterTextPage clickManageFooterText() {
		managefootertext.click();
		return new ManageFooterTextPage(driver);
	}

	public ManageNewsPage clickManageNews() {
		managenews.click();
		return new ManageNewsPage(driver);
	}

	public void clickAdminUser() {
		adminuser.click();
	}

	public void clickLogout() {
		logout.click();
	}

}
