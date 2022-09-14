package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
 
	//variables 
	private By inputTextUserName= By.name("user");
	private By inputTextUserPassword= By.name("password");
	
	private By buttonLogin= By.xpath("//input[@id='login']");
	private By buttonLoginAtlasian= By.xpath("//button[@id='login-submit']");
	
	private By msgLogin= By.xpath("//div[@id='error']/p");
	private By userButton=By.xpath("//*[@id='header']/div[3]/button[3]");
	private By userName=By.xpath("/html/body/div[3]/div/section/div/nav/ul/div/div[2]/span");
	
	private WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void userLoginActionError(String user,String pass){
		driver.findElement(inputTextUserName).sendKeys(user);
		driver.findElement(inputTextUserPassword).sendKeys(pass);
		
		//click login button 
		WebElement loginButton = driver.findElement(buttonLogin);
        Actions builder = new Actions(driver);
        builder.moveToElement(loginButton).click(loginButton);
        builder.perform();

	}
	
	public void userLoginActionOk(String user,String pass){
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextUserName));
		
		driver.findElement(inputTextUserName).sendKeys(user);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
		//click login button 
		WebElement loginButton = driver.findElement(buttonLogin);
        Actions builder = new Actions(driver);
        builder.moveToElement(loginButton).click(loginButton);
        builder.perform();
        
        //wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        //click login with Atlasian
        WebElement loginButtonAtlasian = driver.findElement(buttonLogin);
        Actions builder2 = new Actions(driver);
        builder2.moveToElement(loginButton).click(loginButtonAtlasian);
        builder2.perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextUserPassword));
		driver.findElement(inputTextUserPassword).sendKeys(pass);
		driver.findElement(buttonLoginAtlasian).click();
		

	}
	
	public String getLoginMsg() throws InterruptedException{
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(msgLogin));

		return driver.findElement(msgLogin).getText();
	}
	
	public String getLoginUser() throws InterruptedException{
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(userButton));
		//driver.findElement(userButton).click();
		WebElement userProfileButton = driver.findElement(userButton);
        Actions builder = new Actions(driver);
        builder.moveToElement(userProfileButton).click(userProfileButton);
        builder.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		return driver.findElement(userName).getText();
	}
	
	

}
