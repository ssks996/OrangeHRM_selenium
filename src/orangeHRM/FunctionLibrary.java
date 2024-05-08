package orangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary {



	// START BROWSER
	public static WebDriver startBrowser (WebDriver driver) throws IOException  {

		if (Inputs.fileInputs("Browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else 
			if(Inputs.fileInputs("Browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			else 
				if(Inputs.fileInputs("Browser").equalsIgnoreCase("ie")) {
					driver = new InternetExplorerDriver();
				}
		return driver;
	}

	// OPEN APPLICATION
	public static void openApp(WebDriver driver) throws IOException  {
		driver.navigate().to(Inputs.fileInputs("URL"));
		driver.manage().window().maximize();

	}


	//WAIT FOR ELEMENT
	public static  void waitForElement(WebDriver driver,String LocaterType,String LocaterValue,String waitTime) {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(waitTime)));
		if(LocaterType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocaterValue)));
		}
		else {
			if(LocaterType.equalsIgnoreCase("name")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated	(By.name(LocaterValue)));
			}
			else {
				if(LocaterType.equalsIgnoreCase("xpath")) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocaterValue)));
				}	
			}

		}

	}


	// USERNAME and PASSWORD
	public static void typeAction(WebDriver driver,String LocaterType,String  LocaterValue,String TestData) {
		if(LocaterType.equalsIgnoreCase("id")){
			
			driver.findElement(By.id(LocaterValue)).sendKeys(TestData);
		}
		else 
			if(LocaterType.equalsIgnoreCase("name")){
			
				driver.findElement(By.name(LocaterValue)).sendKeys(TestData);
			}
			else 
				if(LocaterType.equalsIgnoreCase("xpath")){
				
					driver.findElement(By.xpath(LocaterValue)).sendKeys(TestData);
				}

	}

	// CLICK ACTION
	public static void clickAction (WebDriver driver,String LocaterType,String LocaterValue) {
		if(LocaterType.equalsIgnoreCase("id")){
			driver.findElement(By.id(LocaterValue)).click();;
		}
		else 
			if(LocaterType.equalsIgnoreCase("name")){
				driver.findElement(By.name(LocaterValue)).click();;
			}
			else 
				if(LocaterType.equalsIgnoreCase("xpath")){
					driver.findElement(By.xpath(LocaterValue)).click();;
				}

	}
	
	//DATE
	public static String generateDate() {
		Date date = new Date();
		SimpleDateFormat sfs = new SimpleDateFormat("YYYY_MM_dd_SS");
		return sfs.format(date);
	}


	
	



}
