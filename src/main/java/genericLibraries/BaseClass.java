package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUsersPage;
import pomPages.AdminHomePage;
import pomPages.CategoryPage;
import pomPages.CourseListPage;
import pomPages.LoginPage;
import pomPages.UsersPage;
import pomPages.WelcomePage;

public class BaseClass  {
	
	//@BeforeSuite
	//@BeforeTest
	
	//**********
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;
	
	
	public static WebDriver sdriver; 
	public static JavaUtility sjutil;
	
	protected WelcomePage welcome;
	protected LoginPage login;
	protected AdminHomePage home;
	protected UsersPage users;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewCategoryPage addcategorypage;
	protected AddNewCoursePage addcoursepage;
	protected AddNewUsersPage adduserspage;
	
	@BeforeClass
	public  void classConfig() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil= new JavaUtility();
		webUtil=new WebDriverUtility();
		
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		driver=webUtil.launchchromeBrowser(property.readFromProperties("browser"));
		
		sdriver=driver;
		sjutil=jutil;
	}
	
	@BeforeMethod
	public void methodConfi()
	{
		excel.excelIntialization(IConstantPath.EXCEL_PATH);
		
		welcome =new WelcomePage(driver);
		login = new LoginPage(driver);
		home = new AdminHomePage(driver);
		users = new UsersPage(driver);
		course = new CourseListPage(driver);
		category= new CategoryPage(driver);
		adduserspage= new AddNewUsersPage(driver);
		addcoursepage=new AddNewCoursePage(driver);
		addcategorypage= new AddNewCategoryPage(driver);
		
		webUtil.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(welcome.getLogo(),"SkillRary-ECommerce");
		
		long time = Long.parseLong(property.readFromProperties("timeouts"));
		webUtil.waitTillElementFound(time);
		
		welcome.clickLoginButton();
		Assert.assertEquals(login.getpageHeader(),"Login"); 
		
		login.setEmail(property.readFromProperties("username"));
		login.setpassword(property.readFromProperties("password"));
		login.clickLoin();
		
		Assert.assertEquals(home.getAdminIcon(), "SkillRary Admin");
		
		
	}
	@AfterMethod
	public void methodTeardown()
	{
		excel.closeExcel();
		home.signOutofApp();
	}
	
	@AfterClass
	public void classTeardown()
	{
		webUtil.closeAllWindows();
		
	}
	//@AfterTest
	//@AfterSuite
	

}
