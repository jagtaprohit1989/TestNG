package TestNGFramework.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends BaseIntegration {
	WebElement email1,pass,submit,logOut;
	String tName;
	
	@BeforeSuite
	public void getSetup() throws IOException{
		doSetup();
	}
	
	@BeforeMethod
	public void getXpath()  {
		email1=driver.findElement(By.xpath("//input[@type='text']"));
		email1.clear();
		pass=driver.findElement(By.xpath("//input[@type='password']"));
		pass.clear();		
		submit=driver.findElement(By.xpath("//button[@type='submit']"));
		 }
	
	@Test(dataProvider = "loginData")
	public void doLogin(String testName,String uName,String uPass) {
		tName=testName;
		email1.sendKeys(uName);
		pass.sendKeys(uPass);
		submit.click();
	}
	@AfterMethod
	public void doAssert() {
	String actResult=driver.getTitle();
		if (tName.equals("Both are Valid")){
		Assert.assertEquals(actResult, "Queue Codes | Dashboard");
	}else {
		Assert.assertEquals(actResult, "Queue Codes | Log in");
		}
	}
	
	@AfterSuite
	 public void tearDown() {
		 driver.close();
	 }
}


