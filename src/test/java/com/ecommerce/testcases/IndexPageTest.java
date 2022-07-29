package com.ecommerce.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.pageobjects.IndexPage;
import com.ecommerce.utility.Log;

public class IndexPageTest extends BaseClass{
	private IndexPage indexPage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.close();
	}
	@Test(groups="Smoke",alwaysRun=true)
	public void verifyLogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		indexPage= new IndexPage();
		boolean result=indexPage.validateLogo();
		System.out.println(result);
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	@Test(groups="Smoke",alwaysRun=true)
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle=indexPage.getMyStoreTitle();
		System.out.println("Title of the application is " + "------" + actTitle);
		Assert.assertEquals(actTitle, "My Store");
		Log.endTestCase("verifyTitle");
	}
	
}
