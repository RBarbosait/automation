package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardPage {
	private WebDriver driver;
	private By linkCrearTablero=By.xpath("//div[@id='content']/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/ul/li/div/p/span");
	private By inputBoardName=By.xpath("/html/body/div[3]/div/section/div/form/div[1]/label/input");
	private By buttonCrearBoard=By.xpath("/html/body/div[3]/div/section/div/form/button");
	//private By buttonAddList=By.xpath("//*[@id='board']/div[4]/form/a/span");
	private By buttonAddList=By.xpath("//*[@id='board']/div/form/a/span");
	//private By inputListName=By.xpath("/html/body");
	private By inputListName=By.xpath("//*[@id='board']/div/form/input");
	private By buttonConfirmList=By.xpath("//*[@id='board']/div/form/div/input");
	private By spanTableroName=By.xpath("//*[@id='popover-boundary']/div/div[1]/nav/div[1]/div/div/div[2]/div/div[3]/ul/div[2]/li/a");
	private By spanListaName=By.xpath("//*[@id='board']/div[1]/div/div[1]/h2");
	private By body=By.xpath("//*[@id='board']");
	
	private String tableroName="tableroTest";
	private String listName="ListaTest";
	
	public BoardPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void userCreateBoardAction(){
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(linkCrearTablero));
		driver.findElement(linkCrearTablero).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputBoardName));
		driver.findElement(inputBoardName).sendKeys(tableroName);
		
		//click crearBoard button 
			/*	WebElement crearButton = driver.findElement(buttonCrearBoard);
		        Actions builder = new Actions(driver);
		        builder.moveToElement(crearButton).click(crearButton);
		        builder.perform();*/
		driver.findElement(buttonCrearBoard).click();
	}
	
	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public void userCreateListAction(){
		Duration time = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver, time);
		/*WebElement bodyDobleClick = driver.findElement(body);
        Actions builder = new Actions(driver);
        builder.moveToElement(bodyDobleClick).doubleClick(bodyDobleClick);
        builder.perform();*/
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddList));
		//driver.findElement(buttonAddList).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputListName));
		driver.findElement(inputListName).click();
		driver.findElement(inputListName).sendKeys(listName);
		driver.findElement(buttonConfirmList).click();
	}
	
	public String getBoardName() throws InterruptedException{
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(spanTableroName));

		return driver.findElement(spanTableroName).getText();
	}
	
	public String getListaName() throws InterruptedException{
		
		/*Duration time = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(spanListaName));
*/
		return driver.findElement(spanListaName).getText();
	}

	public String getTableroName() {
		return tableroName;
	}

	public void setTableroName(String tableroName) {
		this.tableroName = tableroName;
	}
	

}
