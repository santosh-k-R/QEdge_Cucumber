package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition1 {
	WebDriver driver;
	@When("^launch url in chrome$")
	public void launch_url_in_chrome() throws Throwable {
	   driver= new ChromeDriver();
	   driver.get("http://orangehrm.qedgetech.com/");
	   driver.manage().window().maximize();
	}

	@When("^i enter username and password$")
	public void i_enter_username_and_password() throws Throwable {
	    
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");

	}

	@When("^i click on  login button$")
	public void i_click_on_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	}

	@Then("^i should see welocome link on home page$")
	public void i_should_see_welocome_link_on_home_page() throws Throwable {
	    String expected="Welcome";
	    String actual=driver.findElement(By.id("welcome")).getText();
	    if(actual.contains(expected))
	    {
	    	System.out.println("Login success");
	    }
	    else
	    {
	    	System.out.println("login fail");
	    }
		
	}

	@When("^i close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.close();
	   
	}



}
