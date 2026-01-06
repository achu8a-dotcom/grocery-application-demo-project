package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	
	public WebDriver driver;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusers;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement adminusersnewbutton;
	@FindBy(xpath="//input[@name='username']")WebElement usernametext;
	@FindBy(xpath="//input[@name='password']")WebElement passwordtext;
	@FindBy(xpath="//select[@name='user_type']")WebElement usertypedropdown;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Create']")WebElement adminusersave;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")WebElement homebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickAdminUsers()
	{
		adminusers.click();
	}
	
	public void clickAdminusersnewbutton()
	{
		adminusersnewbutton.click();
	}
	
	public void enterUsercredentials(String username,String password)
	{
		usernametext.sendKeys(username);
		passwordtext.sendKeys(password);
	}
	
	public void selectUsertype()
	{
		Select select=new Select(usertypedropdown);
		select.selectByIndex(2);
	}
	public void clickSaveUser()
	{
		adminusersave.click();
	}
	
	public boolean isAlertDisplayed()
	{
		return alertmsg.isDisplayed();
	}
	
	public void clickHomeButton()
	{
		homebutton.click();
	}
}
