package com.jenkins.JenkinsBankAccount;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.jenkins.PropertyManager.PropertyManager;

public class TestBankAccount {

	@Test
	public void simpleDebit(){
		BankAccount bankAccount = new BankAccount(10.0);
		double amount = bankAccount.debit(5.0);
		Assert.assertTrue(amount==5.0);
	}
	
	@Test
	public void overDraftReturnsCurrentBalance(){
		BankAccount bankAccount = new BankAccount(10.0);
		double amount = bankAccount.debit(11.0);
		Assert.assertTrue(amount==10.0);
	}
	
	@Test
	public void phantomJSDriverTest(){
		PropertyManager propertyManager = new PropertyManager();
		propertyManager.generateProperty();
		File src = new File(propertyManager.getPhantomJSDriver());
		//File src = new File("/usr/local/share/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
	    System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
	    WebDriver webdriver = new PhantomJSDriver();
	    webdriver.navigate().to("http://www.thetestroom.com/webapp/");
	    Assert.assertTrue(webdriver.getTitle().equals("Zoo Adoption | Home"));
	}
}
