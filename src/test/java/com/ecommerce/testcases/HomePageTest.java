package com.ecommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.dataprovider.DataProviders;
import com.ecommerce.pageobjects.HomePage;
import com.ecommerce.pageobjects.IndexPage;
import com.ecommerce.pageobjects.LoginPage;
import com.ecommerce.utility.Log;

public class HomePageTest extends BaseClass {
	private IndexPage indexpage;
	private LoginPage loginpage;
	private HomePage homepage;
	
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		try {
		driver.quit();
		//Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		}catch(Exception e) {
			e.printStackTrace();	
		}
	}
	@Test(groups="Smoke",alwaysRun=true,dataProvider = "credentials", dataProviderClass = DataProviders.class,priority=1)
	public void wishListTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("wishListTest");
		indexpage= new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=loginpage.login(uname,pswd);
		Thread.sleep(5000);
		boolean result=homepage.validateMyWishList();
		System.out.println("Validate the wishlist" + "---"+ result);
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");
	}
	@Test(groups="Smoke",alwaysRun=true,dataProvider = "credentials", dataProviderClass = DataProviders.class,priority=2)
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("orderHistoryandDetailsTest");
		indexpage= new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=loginpage.login(uname,pswd);
		boolean result=homepage.validateOrderHistory();
		System.out.println("validate the order History and Details" + " ----"+ result);
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryandDetailsTest");
	}
}
