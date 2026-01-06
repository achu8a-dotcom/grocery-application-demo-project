package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement managenews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement managenewsnewbutton;
	@FindBy(xpath="//textarea[@id='news']")WebElement newstext;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement newssave;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")WebElement alertmsg;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickManageNews()
	{
		managenews.click();
	}
	
	public void clickManagenewsnewbutton()
	{
		managenewsnewbutton.click();
	}
	
	public void enterNewstext(String text)
	{
		newstext.sendKeys(text);
	}
	
	public void clickSaveNews()
	{
		newssave.click();
	}
	
	public boolean isAlertDisplayed()
	{
		return alertmsg.isDisplayed();
	}

	
	

}
