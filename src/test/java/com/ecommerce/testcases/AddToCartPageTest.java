package com.ecommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseClass;
import com.ecommerce.dataprovider.DataProviders;
import com.ecommerce.pageobjects.AddToCartPage;
import com.ecommerce.pageobjects.IndexPage;
import com.ecommerce.pageobjects.SearchResultPage;
import com.ecommerce.utility.Log;

public class AddToCartPageTest extends BaseClass {

	public IndexPage index;
	public SearchResultPage searchResultPage;
	public AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups={"Regression","Sanity"},alwaysRun=true,dataProvider = "getProduct", dataProviderClass = DataProviders.class,priority=2)
	public void addToCartTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("addToCartTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		System.out.println("Search product");
	     String actdesc=addToCartPage.validateDiscription();
		Assert.assertEquals(actdesc, "Faded Short Sleeve T-shirts");
		System.out.println("Actual Description of the product"+ "----"+ actdesc);
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result1=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result1);
		Log.endTestCase("addToCartTest");
		
	}
	
	
}

