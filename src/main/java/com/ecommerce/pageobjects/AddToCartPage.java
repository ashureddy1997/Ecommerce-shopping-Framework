package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;

public class AddToCartPage extends BaseClass {
Action action= new Action();
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	@FindBy(xpath="//h1[@itemprop='name']")
	private WebElement desc;
	
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		//action.fluentWait(driver, quantity, 15);
		action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		//action.fluentWait(driver, size, 15);
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		Thread.sleep(7000);
		//action.fluentWait(driver, addToCartBtn, 15);
		action.click(driver, addToCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		Thread.sleep(7000);
		//action.fluentWait(driver, addToCartMessag, 10);
		return action.isDisplayed(driver, addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		Thread.sleep(7000);
		//action.fluentWait(driver, proceedToCheckOutBtn, 10);
		action.click(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
	
	public String validateDiscription() {
		String text = desc.getText();
		System.out.println("DEscription" + "----" + text);
	   return text;

	}
}
