package Tests;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.LoginPage;
import Pages.BoardPage;
import junit.framework.Assert;

public class BoardTests {

	WebDriver driver;
	String PATH_DRIVER= "./src/test/resources/driver/chromedriver.exe";
	
	String TYPE_DRIVER= "webdriver.chrome.driver";
	String URL="https://trello.com/login";
	Pages.LoginPage loginPage;
	Pages.BoardPage boardPage;
	String user="michangaapp@gmail.com";
	
	@BeforeMethod
	public void setup(){
		System.setProperty(TYPE_DRIVER, PATH_DRIVER);
		
		//headless-------------
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver= new ChromeDriver(options);
		//---------------------
		
		driver.manage().window().maximize();
		driver.get(URL);
		loginPage=new LoginPage(driver);
		boardPage=new BoardPage(driver);
	}
	
	@Test(priority=1)
	public void testLoginOk(){
		loginPage.userLoginActionOk(user, "password123_");

		//verify
		//System.out.println(loginPage.getLoginMsg());
		try {
			//System.out.println(loginPage.getLoginUser());
			Assert.assertEquals(user,loginPage.getLoginUser());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void testCreateBoard(){
		loginPage.userLoginActionOk(user, "password123_");
		boardPage.userCreateBoardAction();
		
		//verify
		String expTableroName=boardPage.getTableroName();
		
		try {
			Assert.assertEquals(expTableroName,boardPage.getBoardName());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void testCreateList(){
		loginPage.userLoginActionOk(user, "password123_");
		boardPage.userCreateBoardAction();
		boardPage.userCreateListAction();
		String expListName=boardPage.getListName();
		
		//verify
		try {
			Assert.assertEquals(expListName,boardPage.getListaName());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	/*@After
	public void closeNav(){
		driver.quit();
	}*/
	
	@AfterMethod(alwaysRun = true)
	// si error - foto
	//else quit
	public void takeScs(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			Utility.Screenshot.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
