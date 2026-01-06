package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	
	public WebDriver driver;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement managefootertext;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2' and @class='btn btn-sm btn btn-primary btncss']")WebElement managefooteredit;
	@FindBy(xpath="//input[@name='phone']")WebElement managefooterphone;
	@FindBy(xpath="//input[@name='email']")WebElement managefooteremail;
	@FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	@FindBy(xpath="//a[text()='Home']")WebElement homebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	
	public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickManageFooterText()
	{
		managefootertext.click();
	}
	
	public void clickManageFooteredit()
	{
		managefooteredit.click();
	}
	
	public void UpdateContactDetails(String phone,String email)
	{
		managefooteremail.clear();
		managefooteremail.sendKeys(email);
		managefooterphone.clear();
		managefooterphone.sendKeys(phone);
	
	}
	
	public void clickUpdatebutton()
	{
		Actions actions=new Actions(driver);
		actions.click(updatebutton).perform();
		
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
