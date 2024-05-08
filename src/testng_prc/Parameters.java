package testng_prc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameters {
	
	@Test (dataProvider = "getData")
	public void empcreation(String Fname, String Lname) {
		
		System.out.println(Fname + " "+ Lname);
	}
	
	@DataProvider
	public Object[] getData(){
		Object [][] data = new Object[1][2];
		data [0][0] = "srikanth";
		data [0][1] = "srikanth222";
		
	/*	data [1][0] = "sri";
		data [1][1] = "srikanth";
	*/	
		return data;
		
	}
	
	
	

}
