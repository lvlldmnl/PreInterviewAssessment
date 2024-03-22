package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	protected WebDriver driver;
	//Text
	private By text_InvalidUsername = By.xpath("//div[text()='Your username is invalid!']");
	private By text_InvalidPassword = By.xpath("//div[text()='Your password is invalid!']");
	private By text_LoggedInSuccessfully = By.xpath("//div/h1[text()='Logged In Successfully']");
	private By text_CongratulationsStudent = By.xpath("//p/strong[text()='Congratulations student. You successfully logged in!']");
	
	//TextfieldAddBelow
	private By textfield_Username = By.id("username");
	private By textfield_Password = By.id("password");
	
	//ButtonAddBelow
	private By btn_Login = By.id("submit");
	private By btn_Logout = By.xpath("//div/a[text()='Log out']");
	private By btn_Menu = By.id("react-burger-menu-btn");
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		if(driver.getTitle().equals("https://practicetestautomation.com/practice-test-login/")) {
			throw new IllegalStateException("This is not login page"
			+driver.getCurrentUrl());
		}
	}
	
	public void enterUsername(String username) {
		driver.findElement(textfield_Username).sendKeys(username);
	}
	
	public void enterPassord(String password) {
		driver.findElement(textfield_Password).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btn_Login).click();
	}
	
	public void clickMenu() {
		driver.findElement(btn_Menu).click();
	}
	
	public void checkLogoutisDisplayed() {
		driver.findElement(btn_Logout).isDisplayed();
	}
	
	public void loginSuccessfullyisDisplayed() {
		driver.findElement(text_LoggedInSuccessfully).isDisplayed();
		driver.findElement(text_CongratulationsStudent).isDisplayed();
	}
	
	public void errorMessageInvalidUsernameisDisplayed() {
		driver.findElement(text_InvalidUsername).isDisplayed();
	}
	
	public void errorMessageInvalidPasswordisDisplayed() {
		driver.findElement(text_InvalidPassword).isDisplayed();
	}
	
	public void loginValidateUser(String username, String password) {
		driver.findElement(textfield_Username).sendKeys(username);
		driver.findElement(textfield_Password).sendKeys(password);
	}
	

}
