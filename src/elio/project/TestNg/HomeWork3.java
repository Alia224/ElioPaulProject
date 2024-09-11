package elio.project.TestNg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import elio.project.utils.CommonMethods;
import elio.project.utils.ConfigsReader;

public class HomeWork3 extends CommonMethods {
//	==================  Lesson 03 HW 1 =======================
//
//			Open chrome browser
//			Go to "https://hrm.neotechacademy.com/"
//			Login to the application
//			Add 3 different Employees and Create Login Details by providing:
//			First Name
//			Last Name
//			Username
//			Password
//			Verify Employee has been added successfully and take screenshot (you must have 3 different screenshots)
//			Close the browser
//			Specify a group for this test case, add it into specific suite and execute from the xml file.	
	@BeforeMethod
	public void setup() {
		setUp();
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		driver.findElement(By.xpath("//button[.='Login']")).click();
		wait(2);
		driver.findElement(By.xpath("//span[.='PIM']")).click();
		driver.findElement(By.xpath("//span[.='Add Employee']")).click();
		wait(5);

	}

	@AfterMethod
	public void teardown() {
		tearDown();
	}

	@Test(dataProvider="data")
	public void add(String firstname, String middlename, String lastname, String location, String username,
			String password) {
		sendText(driver.findElement(By.xpath("//input[@id='first-name-box']")), middlename);
		sendText(driver.findElement(By.xpath("//input[@id='middle-name-box']")), middlename);
		sendText(driver.findElement(By.xpath("//input[@id='last-name-box']")), lastname);
		selectDropdown(driver.findElement(By.id("location")), location);
		wait(3);
		click(driver.findElement(By.xpath("//div[@class='custom-control custom-switch']")));
		waitForVisibility(By.xpath("//label[.='User Name*']"));
		
		sendText(driver.findElement(By.xpath("//input[@id='username']")), username);
		sendText(driver.findElement(By.xpath("//input[@id='password']")), password);
		sendText(driver.findElement(By.xpath("//input[@id='confirmPassword']")), password);
		click(driver.findElement(By.xpath("//button[@id='modal-save-button']")));
		wait(2);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(source, new File("screenshots/"+firstname+"_"+lastname+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}
	
	@DataProvider
	public Object [][] data(){
		
		Object[][]data= {{"Elio","Tanios","Azar","Canadian Development Center","Alia","neotech"},
				{"paul","elie","saab","German Regional HQ","pas","nepas"},
				{"Geogre","fa","fars","M FAYAZ HUSSAIN BAIG","gs","sdsad"},
				};
		
		
		return data;
		
	}

}
