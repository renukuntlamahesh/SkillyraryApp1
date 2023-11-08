package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class AddNewCoursePage {
	//Declaration
	@FindBy(xpath = "//b[text()=\"Add New Course\"]")
	private WebElement PageHeader;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameTF ;
	
	@FindBy(id  = "category")
	private WebElement categoryDropdown;
	
	@FindBy(id = "price")
	private WebElement priceTF;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement photoButton;
	
	@FindBy (xpath = "//button[@name='add']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//html/body/p")
	private WebElement descriptionTextArea;
	
	@FindBy (xpath = "//iframe[@title='Rich Text Editor, editor1']")
	private WebElement descriptionFrame;
	
	//Initialization
	public AddNewCoursePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getPageHeader()
	{
		return PageHeader.getText();
		
	}
	
	public void setName(String CourseName)
	{
	  nameTF.sendKeys(CourseName);
	}
	
	public void selectCategory(WebDriverUtility web, String category)
	{
		web.handleDropdown(category, categoryDropdown);
	}
	 public void setprice(String price)
	 {
		 priceTF.sendKeys(price);
	 }
	 public void uoploadphoto(String photopath)
	 {
		 photoButton.sendKeys(photopath);
	 }
	 
	 public void setDescription(WebDriverUtility web,String text)
	 {
		 web.switchToFrame(descriptionFrame);
		 descriptionTextArea.sendKeys(text);
		 web.switchBackFromFrame();
	 }
	  public void clickSaveutton()
	  {
		  saveButton.click();
		 
	 }

}
