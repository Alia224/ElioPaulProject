package elio.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import elio.project.utils.CommonMethods;

public class LoginPage extends CommonMethods {
 
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement pass;
	
	@FindBy(xpath="//button[.='Login']")
	public WebElement loginbutton;
	
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement invalidpass;
	
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
}
