package TestNGFramework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseIntegration {
	WebElement email,pass,submit,logOut;
	
	@BeforeMethod
	public void getXpath() {
		email=driver.findElement(By.xpath("//input[@type='text']"));
		//email.clear();
		pass=driver.findElement(By.xpath("//input[@type='password']"));
		//pass.clear();
		submit=driver.findElement(By.xpath("//button[@type='submit']"));
		  }
	
	@Test
	public void doLogin() {
		email.sendKeys("queuecodes@gmail.com");
		pass.sendKeys("123456");
		submit.click();
	}
	@AfterMethod
	public void doAssert() {
		String actResult=driver.getTitle();
		Assert.assertEquals(actResult, "Queue Codes | Dashboard");
	}
	}


