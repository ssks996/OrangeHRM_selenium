package DriverFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import graphql.language.Description;
import orangeHRM.Excel;
import orangeHRM.FunctionLibrary;

public class DriverScript {
	WebDriver driver;
	public void startTest() throws IOException {
		Excel ex = new Excel();
		
		for(int i =1;i<=ex.rowCount("MasterTestCases");++i){
			String moduleTC;
			if(ex.getData("MasterTestCases", i, 2).equalsIgnoreCase("y")) {
				String TCModule = ex.getData("MasterTestCases", i, 1);
				for(int j=1;j<=ex.rowCount(TCModule);++j) {
					String Description = ex.getData(TCModule, j, 0);
					String Object_Name = ex.getData(TCModule, j, 1);
					String Locater_Type = ex.getData(TCModule, j, 2);
					String Locater_Value = ex.getData(TCModule, j, 3);
					String Test_Data = ex.getData(TCModule, j, 4);
					
					try {	
						if(Object_Name.equalsIgnoreCase("startBrowser")) {
							driver = FunctionLibrary.startBrowser(driver);
						}
						if(Object_Name.equalsIgnoreCase("openApp")) {
							FunctionLibrary.openApp(driver);
						}
						if(Object_Name.equalsIgnoreCase("waitForElement")) {
							FunctionLibrary.waitForElement(driver, Locater_Type, Locater_Value, Test_Data);
						}
						if(Object_Name.equalsIgnoreCase("typeAction")) {
							FunctionLibrary.typeAction(driver, Locater_Type, Locater_Value, Test_Data);
						}
						if(Object_Name.equalsIgnoreCase("clickAction")) {
							FunctionLibrary.clickAction(driver,Locater_Type,Locater_Value);
						}
							ex.setData(TCModule, j, 5, "PASS");
						
							moduleTC = "true";
							ex.setData("MasterTestCases", i, 3, "pass");
					}

					catch(Exception e) {
						ex.setData(TCModule, j, 5, "fail");
						ex.setData("MasterTestCases", i, 3, "FAIL");
						moduleTC = "false";
						TakesScreenshot ts = (TakesScreenshot) driver ;
						File srcFile = ts.getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(srcFile,new File("./Screenshots/"+Description+FunctionLibrary.generateDate()+".png")); 
						
							break;
					}

				}
			
			
			}
			else {	
				ex.setData("MasterTestCases", i, 3, "Not Executed");
			}
				
		}	

	
	}
}
