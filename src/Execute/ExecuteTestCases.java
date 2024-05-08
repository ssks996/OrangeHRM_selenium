package Execute;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DriverScript;
import orangeHRM.Excel;

public class ExecuteTestCases {

	public static void main(String[] args) throws IOException {
	
		DriverScript ds = new DriverScript();
		ds.startTest();

		
		
		
	}	

}
