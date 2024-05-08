package testng_prc;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DriverFactory.DriverScript;
import Execute.ExecuteTestCases;
import dev.failsafe.internal.util.Durations;
import orangeHRM.Excel;
import orangeHRM.FunctionLibrary;
import orangeHRM.Inputs;

public class DriverFact  {
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws IOException {
		
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.navigate().to(Inputs.fileInputs("URL"));
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
	}
	@Test(dataProvider = "getData")
	public void Login(String username,String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@DataProvider
	public Object[] getData() throws IOException {
		Object ob [][]=new Object[1][2];
		ob[0][0]= "Admin";
		ob[0][1]="admin123";
		return ob;
		
	}
	@Test
	public void click() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
}
