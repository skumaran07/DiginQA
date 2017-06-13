package com.test.Automation.sel.Digin.Action;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.Automation.sel.Digin.testBase.TestBase;

public class RegUser {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	WebDriver driver;
	@FindBy(xpath = ".//*[@id='navigation']/ul[2]/li[2]/a")
	WebElement regButton;
	@FindBy(xpath = ".//*[@id='wrapper']/div/div/div[1]/form/div/p[2]/a")
	WebElement regLink;
	
	@FindBy(xpath = ".//*[@id='FirstName']")
	WebElement fname;
	
	@FindBy(xpath = ".//*[@id='MiddleName']")
	WebElement mname;
	@FindBy(xpath = ".//*[@id='LastName']")
	WebElement lname;
	@FindBy(xpath = ".//*[@id='Email']")
	WebElement email;
	@FindBy(xpath = ".//*[@id='Password']")
	WebElement password;
	@FindBy(xpath = ".//*[@id='ConfirmPassword']")
	WebElement cPassword;
	@FindBy(xpath = ".//*[@id='contact']/form/div[20]/div[1]/button")
	WebElement submit;
	@FindBy(xpath= ".//*[@id='GetQuote']")
	WebElement getQuote;
	
	public RegUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

public void registerForm(String fname, String mname, String lname, String email, String password, String cPassword){
	regButton.click();
	log.info("button is clicked" +regButton.toString());
	regLink.click();
	log.info("Link redirect to register form" +regLink.toString());
	this.fname.sendKeys(fname);
	log.info("First name is enter" +fname.toString());
	this.mname.sendKeys(mname);
	log.info("middle name is enter" +mname.toString());
	this.lname.sendKeys(lname);
	log.info("Last name is enter" +lname.toString());
	this.email.sendKeys(email);
	log.info("Email is enter" +email.toString());
	this.password.sendKeys(password);
	log.info("Password is enter" +password.toString());
	this.cPassword.sendKeys(cPassword);
	log.info("ConfirmPassword is enter" +cPassword.toString());
	submit.click();
}

public String loginPage()
{
	getQuote.isDisplayed();
	return getQuote.getText();
}
}