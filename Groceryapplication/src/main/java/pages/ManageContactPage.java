package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class ManageContactPage {

	public WebDriver driver;

//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement managecontact;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1' and @class='btn btn-sm btn btn-primary btncss']")
	WebElement managecontactedit;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement managecontactphone;
	@FindBy(xpath = "//input[@name='email']")
	WebElement managecontactemail;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*
	 * public void clickManageContact() { managecontact.click(); }
	 */

	public ManageContactPage clickManageContactEdit() {
		managecontactedit.click();
		return this;
	}

	public ManageContactPage enterContactDetails(String phone, String email) {
		managecontactphone.clear();
		managecontactphone.sendKeys(phone);
		managecontactemail.clear();
		managecontactemail.sendKeys(email);
		return this;
	}

	public ManageContactPage clickUpdateButton() {
		PageUtility pageutility = new PageUtility();
		pageutility.ClickMethod(updatebutton,driver);
		return this;

	}

	public boolean isAlertDisplayed() {
		return alertmsg.isDisplayed();
	}

}
