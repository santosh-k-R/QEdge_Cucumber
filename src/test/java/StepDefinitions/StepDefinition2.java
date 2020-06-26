package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition2 {
	WebDriver driver;
	String url="http://orangehrm.qedgetech.com";
	@When("^I open OrangeHRMS URL on \"([^\"]*)\"$")
	public void i_open_OrangeHRMS_URL_on(String brw) throws Throwable {
		if(brw.equalsIgnoreCase("firefox"))
		{
			System.out.println("Executing on firefox browser");
			driver=new FirefoxDriver();
			driver.get(url);
		}
		else if(brw.equalsIgnoreCase("chrome"))
		{
			System.out.println("Executing on chrome browser");
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		else
		{
			System.out.println("Browser is not matching");
		}
	    
	}

	@When("^I enter \"([^\"]*)\" in usernameField$")
	public void i_enter_in_usernameField(String username) throws Throwable {
	    driver.findElement(By.name("txtUsername")).sendKeys(username);
	}

	@When("^I enter \"([^\"]*)\" in passwordField$")
	public void i_enter_in_passwordField(String password) throws Throwable {
		driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^clicking Login Button$")
	public void clicking_Login_Button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(5000);
	}

	@Then("^I Should see dashboard in url$")
	public void i_Should_see_dashboard_in_url() throws Throwable {
	    if(driver.getCurrentUrl().contains("dash"))
	    {
	    	System.out.println("Login Success");
	    }
	    else
	    {
	    	System.out.println("Login Fail");
	    }
	}

	@When("^Closingbrowser$")
	public void closingbrowser() throws Throwable {
	   driver.close();
	}

}
