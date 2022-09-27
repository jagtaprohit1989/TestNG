package TestNGFramework.tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest extends BaseIntegration {
	WebElement name,email,mobile,password,submit;
	
	@BeforeSuite
	public void getSetup() throws IOException{
		doSetup();
	}
	
	@BeforeTest
	public void gotoRegisterPage() {
		if(driver.getTitle().equals("Queue Codes | Log in"));{
			driver.findElement(By.partialLinkText("Register a new membership")).click();
			
		}
	}
	@BeforeMethod
	public void getXpath1() {
		name=driver.findElement(By.id("name"));
		name.clear();
		mobile=driver.findElement(By.id("mobile"));
		mobile.clear();
		email=driver.findElement(By.id("email"));
		email.clear();
		password=driver.findElement(By.id("password"));
		password.clear();
		submit=driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	@Test(dataProvider = "registerData")
	public void doRegister(String testName,String Uname,String uMobile,String uEmail,String uPassword) {
		tName=testName;
		name.sendKeys(Uname);
		mobile.sendKeys(uMobile);
		email.sendKeys(uEmail);
		password.sendKeys(uPassword);
		submit.click();
	}
	/*@Test
	public void doRegister() {
		name.sendKeys("Queue");
		mobile.sendKeys("9561884745");
		email.sendKeys("queue@gmail.com");
		password.sendKeys("12345");
		submit.click();
	}
	@AfterMethod
	public void doAssert() {
		Alert alt=driver.switchTo().alert();
		String actResult=alt.getText();
		alt.accept();
		Assert.assertEquals(actResult, "User registered successfully.");
	}*/
	@AfterMethod
	public void doAssert() {
		String actResult;
		if(tName.equals("All fields are valid")) {
		Alert alt=driver.switchTo().alert();
		actResult=alt.getText();
		alt.accept();
		Assert.assertEquals(actResult, "User registered successfully.");
	}else {
		actResult=driver.getTitle();
		Assert.assertEquals(actResult, "Queue Codes | Registration Page");
	}
 }
	@AfterSuite
	 public void tearDown() {
		 driver.close();
	 }
}
