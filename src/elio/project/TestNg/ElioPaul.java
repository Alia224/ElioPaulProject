package elio.project.TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import elio.project.pages.Dashboardpage;
import elio.project.pages.LoginPage;
import elio.project.utils.CommonMethods;
import elio.project.utils.ConfigsReader;

public class ElioPaul extends CommonMethods {
//	Under com.neotech.test package please create 3 Test methods (The first one is done!)
//	Below are details of three test methods.
//	Please follow Page Object Model design.
//
//	TC 1: Orange HRM Application Valid Login: (Method name is validLogin)
//	Open Chrome browser
//	Go to https://hrm.neotechacademy.com/
//	Enter valid username and password
//	Click on login button
//	Verify user successfully logged in by verifying account name has the text "Jacqueline White".
//	Quit the browser
//
//	TC 2: Orange HRM Application Empty Password Login: (Method name is emptyPasswordLogin)
//	Open Chrome browser
//	Go to https://hrm.neotechacademy.com/
//	Enter valid username and leave password field empty
//	Click on login button
//	Verify error message with text "Password cannot be empty" is displayed.
//	Quit the browser
//
//	TC 3: Orange HRM Application Invalid Password Login: (Method name is invalidPasswordLogin)
//	Open Chrome browser
//	Go to https://hrm.neotechacademy.com/
//	Enter valid username and invalid password
//	Click on login button
//	Verify error message with text "Invalid Credentials" is displayed
//	Quit the browser
//
//	Then create a login.xml file.
//	It should include LoginTest class, but should exclude invalidPasswordLogin method.
//	It should also include Listeners
	@Test(groups="smoke")
	public void validLogin() {
//System.out.println(ConfigsReader.getProperty("username"));
		LoginPage lp = new LoginPage();
		Dashboardpage dp = new Dashboardpage();

		sendText(lp.username, ConfigsReader.getProperty("username"));

		sendText(lp.pass, ConfigsReader.getProperty("password"));

		click(lp.loginbutton);
		wait(2);

		String expected = "Jacqueline White";
		String actual = dp.accountname.getText();

		Assert.assertEquals(actual, expected, "Account name does not match");

	}

	@Test(groups="regression")
	public void invalidPasswordLogin() {
		LoginPage lp = new LoginPage();
		Dashboardpage dp = new Dashboardpage();

		sendText(lp.username, ConfigsReader.getProperty("username"));
		sendText(lp.pass, "ASd");
		click(lp.loginbutton);
		wait(2);
		
		String expected = "Invalid Credentials";
		String actual = lp.invalidpass.getText();
		
		Assert.assertEquals(expected, actual, "The msg is not the same");

	}

}
