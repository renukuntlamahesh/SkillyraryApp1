package testScripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateCourseTest extends BaseClass
{
	@Test
	
	public void createCourseTest() throws InterruptedException
	{
		SoftAssert soft=new SoftAssert();
		home.clickCoursesTab();
		home.clickCourseListLink();
		
		soft.assertTrue(course.getPageHeader().contains(" Course List"));
		
		course.clickNewButton();
		Thread.sleep(3000);
		
		soft.assertEquals(addcoursepage.getPageHeader(),"Add New Course");
		
		Map<String, String> map=excel.readFromExcel("Sheet1", "Add Course");
		String courseName=map.get("Name")+jutil.generateRandomNum(100);
		addcoursepage.setName(courseName);
		addcoursepage.selectCategory(webUtil, map.get("Category"));
		addcoursepage.setprice(map.get("Price"));
		addcoursepage.uoploadphoto(map.get("Photo"));
		
		addcoursepage.setDescription(webUtil, map.get("Description"));
		
		boolean isPresent = false;
		List<WebElement> courseNameList=course.getCourseList();
		for(WebElement name: courseNameList)
		{
			if(name.getText().equals(courseName))
			{
				isPresent=true;
				break;
			}
		}
		soft.assertTrue(isPresent);
		
		course.clickDeleteButton(courseName, driver);
		course.clickDelete();
		soft.assertTrue(course.getSuccessMessage().contains("Success"));
		if(course.getSuccessMessage().contains("Success"))
			excel.writeToexcel("Sheet1", "Add Course", "Fail", IConstantPath.EXCEL_PATH);
		else
			excel.writeToexcel("Sheet1", "Add Course", "Fail", IConstantPath.EXCEL_PATH);
		
		soft.assertAll();
	}
}
