package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import Pages.LoginPage;

public class LoginTests {

	WebDriver driver;
	String PATH_DRIVER= "./src/test/resources/driver/chromedriver.exe";
	
	String TYPE_DRIVER= "webdriver.chrome.driver";
	String URL="https://trello.com/login";
	Pages.LoginPage loginPage;
	
	@Before
	public void setup(){
		System.setProperty(TYPE_DRIVER, PATH_DRIVER);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		loginPage=new LoginPage(driver);
	}
	
	@Test
	public void testPage_loginError(){
		loginPage.userLoginActionError("rbarbosait", "test123");
		
		//verify
		String texto="There isn't an account for this username";
		//System.out.println(loginPage.getLoginMsg());
		try {
			Assert.assertEquals(texto,loginPage.getLoginMsg());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testPage_loginOk(){
		loginPage.userLoginActionOk("michangaapp@gmail.com", "password123_");
		
		//verify
		//String texto="There isn't an account for this username";
		//System.out.println(loginPage.getLoginMsg());
		//Assert.assertEquals(texto,loginPage.getLoginMsg());
	}
	
	@After
	public void closeNav(){
		driver.quit();
	}
	

}

