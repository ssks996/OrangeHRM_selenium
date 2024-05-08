package testng_prc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertPRC {

	@Test
	public void validation() {
	String src ="sss";
	String src1 = "sss";
	
	Assert.assertEquals(src, src1,"both are not Equal");
	
}
}