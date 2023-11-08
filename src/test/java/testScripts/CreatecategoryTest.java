package testScripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class CreatecategoryTest extends BaseClass {  
	@Test
	
	public void createCategoryTest() throws InterruptedException
	{
		SoftAssert soft=new SoftAssert();
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertTrue(category.getpageHeader().contains("Category"));
		
		category.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addcategorypage.getPageHeader(), "Add New category");
		Map<String,String> map=excel.readFromExcel("sheet1", "Add category");
		String categoryName= map.get("Name")+jutil.generateRandomNum(100);
		addcategorypage.setName(categoryName);
		addcategorypage.clickSave();
		
		soft.assertTrue(category.getSuccessMessage().contains("Success"));
		boolean isPresent = false;
		List<WebElement> categoryList=category.getCategoryList();
		for(WebElement e: categoryList)
		{
			if(e.getText().equals(categoryName))
			{
				isPresent=true;
				break;
			}
		}
		soft.assertTrue(isPresent);
		
		category.clickDeleteButton(categoryName, driver);
		category.clickDelete();
		soft.assertTrue(category.getSuccessMessage().contains("success"));
		soft.assertAll();
		
	}

}
