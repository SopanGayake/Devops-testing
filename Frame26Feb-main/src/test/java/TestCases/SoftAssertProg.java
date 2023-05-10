package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertProg {

	@Test
	public void method1()
	{
		SoftAssert s = new SoftAssert();
		System.out.println("Method 1 started");
		AssertJUnit.assertEquals(false, false);
		System.out.println("Method 1");
		AssertJUnit.assertEquals(false, true);
		AssertJUnit.assertEquals(400, 201);
		System.out.println("Method 1 ended");
	}
	
	@Test
	public void method2()
	{
		SoftAssert s = new SoftAssert();
		System.out.println("Method 2 started");
		AssertJUnit.assertEquals(false, false);
		System.out.println("Method 2");
		AssertJUnit.assertEquals(false, true);
		AssertJUnit.assertEquals(400, 201);
		System.out.println("Method 2 ended");
		s.assertAll();
	}
}
