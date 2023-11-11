package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	@FindBy(id = "loginClick")
	private WebElement pageHeader;
	
	@FindBy(id ="email")
	private WebElement emailTF;
	
	@FindBy (name = "password")
	private WebElement passwordTF;
	
	@FindBy (xpath = "//button[text()=\"Login\"]")
	private WebElement loginButton;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Utilization
	
	public String getpageHeader() {
		return pageHeader.getText();
		
		
	}
	public void setEmail(String email)
	{
		emailTF.sendKeys(email);
	}
	public void setpassword(String password)
	{
		passwordTF.sendKeys(password);
	}
	
	public void clickLoin() {
		loginButton.click();
	}
}
