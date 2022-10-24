package pageRepository;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.DriverContext;
public class linkedinPage  {
	
	static linkedinPage linkedinpage;
	
	
	
	@FindBy(name="session_key")
	WebElement edit_username;

	@FindBy(how = How.CSS, using = "input[id='session_password']") 
	WebElement edit_password;

	@FindBy(how = How.XPATH, using = "//button[contains(@class, 'sign-in-form__submit-button')]") 
	WebElement btn_submit;
	
	public linkedinPage()
	{
		PageFactory.initElements(DriverContext.getDriver(), this);
	}
	
	public static linkedinPage steps()
	{
		linkedinpage=new linkedinPage();
		return linkedinpage;
	}
	
	
	public  void login(String username,String password)
	{
		
		//URL launch
	 
		// identify element with Id
		edit_username.sendKeys(username);
		Reporter.log("Gave username");
		DriverContext.snapIt();
		//identify element with css
		edit_password.sendKeys(password);
		Reporter.log("Gave password");
		DriverContext.snapIt();
		btn_submit.click();
		Reporter.log("Clicked submit button");
		DriverContext.snapIt();
		Reporter.log("On Page: "+DriverContext.getDriver().getTitle());
	}
	
}
