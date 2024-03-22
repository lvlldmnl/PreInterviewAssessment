package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.loginPage;


public class LoginDemoStep_POM {
	
	WebDriver driver = null;
	loginPage login;
	
	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - browser is open");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+ projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
	
	@And("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside Step - user is on login page");
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
	}

	@When("^User enter (.*) and (.*)$")
	public void user_enter_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("Inside Step - user enters username and password");
		
		login = new loginPage(driver);
		
		login.enterUsername(username);
		login.enterPassord(password);
		
		Thread.sleep(2000);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		System.out.println("Inside Step - user clicks on login button");
		
		login.clickLogin();
		
		Thread.sleep(2000);
		
	}

	@Then("User is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Inside Step - user is on home page");
		
		login.checkLogoutisDisplayed();
		login.loginSuccessfullyisDisplayed();
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
	}
	
	@Then("User receive error message your username is invalid")
	public void user_receive_error_message_invalid_username() throws InterruptedException {
		System.out.println("Inside Step - user cannot login because of invalid username");
		
		login.errorMessageInvalidUsernameisDisplayed();
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
	
	@Then("User receive error message your password is invalid")
	public void user_receive_error_message_invalid_password() throws InterruptedException {
		System.out.println("Inside Step - user cannot login because of invalid password");
		
		login.errorMessageInvalidPasswordisDisplayed();
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
	
	
}
