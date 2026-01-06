package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;

public class ManageCategoryPage {
	
	public WebDriver driver;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement managecategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add' and @class='btn btn-rounded btn-danger']")WebElement managecategorynewbutton;
	@FindBy(xpath="//input[@id='category']")WebElement categoryname;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement groupname;
	@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
	@FindBy(xpath="//button[@type='submit']")WebElement savebutton;
	@FindBy(xpath="//a[text()='Home']")WebElement homebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void clickManageCategory()
	{
		managecategory.click();
	}
	
	public void clicknewManageCategory()
	{
		managecategorynewbutton.click();
	}
	
	public void enterCategoryDetails(String category)
	{
		categoryname.sendKeys(category);
		groupname.click();
		FileUploadUtility.fileUploadUsingSendkeys(choosefile,Constant.IMAGEFILE);
		
	}
	
	public void clickSavebutton()
	{
		Actions actions=new Actions(driver);
		actions.click(savebutton).perform();
		
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
