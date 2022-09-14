package Utility;
import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot {
	
	public static void captureScreenshot(WebDriver driver, String scsName){
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source= ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("./Screenshots/"+scsName+".png"));
			System.out.println("SCS");
		}
		catch(Exception e){
			System.out.println("no se pudo SCS");
		}
	}

}
