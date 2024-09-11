package elio.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import elio.project.utils.CommonMethods;

public class Dashboardpage extends CommonMethods {

	
	
	
	@FindBy(xpath="//span[@id='account-name']")
	public WebElement accountname;
	
	public Dashboardpage(){
		
		 PageFactory.initElements(driver, this);
	}
	
	
	
}
