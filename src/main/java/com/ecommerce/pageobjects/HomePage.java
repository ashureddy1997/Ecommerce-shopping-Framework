package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;

public class HomePage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//span[text()='My wishlists']")
	private WebElement myWishList;

	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateMyWishList() throws Throwable {
		//action.fluentWait(driver, myWishList, 15);
		return action.isDisplayed(driver, myWishList);
	}

	public boolean validateOrderHistory() throws Throwable {
		//action.fluentWait(driver, orderHistory, 15);
		return action.isDisplayed(driver, orderHistory);
	}

	public String getCurrURL() throws Throwable {
		String homePageURL = action.getCurrentURL(driver);
		return homePageURL;
	}
	
}
