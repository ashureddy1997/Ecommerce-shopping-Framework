package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Action;
import com.ecommerce.base.BaseClass;

public class LoginPage extends BaseClass {
	
Action action= new Action();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pswd) throws Throwable {
		//action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		//action.fluentWait(driver, signInBtn, 15);
		action.click(driver, signInBtn);
		//action.fluentWait(driver, signInBtn, 15);
		return new HomePage();
		
	}
	
	public AddressPage login1(String uname, String pswd) throws Throwable {
		//action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		//action.fluentWait(driver, signInBtn, 15);
		action.click(driver, signInBtn);
		return new AddressPage();
		 
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.type(emailForNewAccount, newEmail);
		action.fluentWait(driver, createNewAccountBtn, 15);
		action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
	}

}
