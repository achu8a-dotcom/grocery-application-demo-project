	package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

public class LoginPage {
			
		@FindBy(name="username")WebElement username;
		@FindBy(name="password")WebElement password;
		@FindBy(xpath="//button[@type='submit']")WebElement signin;
		@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
		@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")WebElement alertmsg;
		
		public WebDriver driver;
		
		public LoginPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}

		public void enterTheUsername(String user)
		{
			username.sendKeys(user);
		}
		
		public void enterThePassword(String passwd)
		{
			password.sendKeys(passwd);
		}
		
		public void clickSignin()
		{
			signin.click();
		}
		
		public boolean isHomePageDisplayed()
		{
			return dashboard.isDisplayed();
			
		}
		
		public boolean isAlertDisplayed()
		{
			return alertmsg.isDisplayed();
		}

		
		
		
	}



