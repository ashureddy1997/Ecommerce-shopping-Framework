package com.ecommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.dataprovider.DataProviders;
import com.ecommerce.pageobjects.HomePage;
import com.ecommerce.pageobjects.IndexPage;
import com.ecommerce.pageobjects.LoginPage;
import com.ecommerce.utility.Log;

public class LoginPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	@Test(groups={"Sanity","Smoke"},alwaysRun=true,dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable {
			Log.startTestCase("loginTest");
			indexpage= new IndexPage();
			Log.info("user is going to click on SignIn");
			loginpage=indexpage.clickOnSignIn();
			Log.info("Enter Username and Password");
		   //homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			homepage=loginpage.login(uname,pswd);
		    String actualURL=homepage.getCurrURL();
		    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		    Log.info("Verifying if user is able to login");
		    Assert.assertEquals(actualURL, expectedURL);
		    Log.info("Login is Sucess");
		    Log.endTestCase("loginTest");
		}
	}

