package TestNGFramework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseIntegration {
	WebElement email,pass,submit,logOut;
	String tName;
	
	@BeforeMethod
	public void getXpath() throws InterruptedException {
		email=driver.findElement(By.xpath("//input[@type='text']"));
		email.clear();
		pass=driver.findElement(By.xpath("//input[@type='password']"));
		pass.clear();
		
		submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Thread.sleep(2000);
		  }
	
	@Test(dataProvider = "loginData")
	public void doLogin(String testName,String uName,String uPass) {
		tName=testName;
		email.sendKeys(uName);
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
	}


