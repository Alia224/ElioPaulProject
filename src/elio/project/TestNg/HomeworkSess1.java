package elio.project.TestNg;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import elio.project.utils.CommonMethods;
import elio.project.utils.ConfigsReader;

public class HomeworkSess1 extends CommonMethods {
//	Homework 1: HRMS Application Negative Login: 
//
//	    1. Open chrome browser
//	    2. Go to "https://hrm.neotechacademy.com/"
//	    3. Enter valid username
//	    4. Leave password field empty
//	    5. Verify error message with text "Password cannot be empty" is displayed.
	@BeforeMethod
	public void setup() {
		setUp();
	}

	@AfterMethod
	public void teardown() {
		tearDown();
	}
	@Test()
	public void test() throws Exception {
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.xpath("//button[.='Login']")).click();
		boolean isdisplayed=driver.findElement(By.id("txtPassword-error")).isDisplayed();
		String actualresult=driver.findElement(By.id("txtPassword-error")).getText();
		
		if(isdisplayed && actualresult.equals("Password cannot be empty")) {
			System.out.println("Test is Passed");
		}else {
			System.out.println("Test is Failed");
			throw new Exception();
		}
		
	}
	
	
	

}
