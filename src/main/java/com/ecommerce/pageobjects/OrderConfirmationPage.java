package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmMessag;

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateConfirmMessage() {
		String confirmMsg = confirmMessag.getText();
		return confirmMsg;
	}

}
