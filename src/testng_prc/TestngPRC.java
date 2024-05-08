package testng_prc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngPRC {

	@Test 
	public void sub() {
		System.out.println("sub");
	}
	
	@Test
	public void mul() {
		System.out.println("mul");
	}
	
	@BeforeClass
	public void add() {
		System.out.println("Before Class");
	}
	
	@BeforeTest
	public void div() {
		System.out.println("BeforeTest");
	}
	
	@BeforeSuite
	public void suite() {
		System.out.println("Before suite");
	}
	
	@BeforeMethod
	public void before() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("After Method");
	}
}
