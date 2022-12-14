package TestNGFramework.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import TestNGFramework.utils.TestUtils;

public class BaseIntegration {
WebDriver driver;
Properties prop;
TestUtils test=new TestUtils();

@BeforeSuite
public void doSetup() throws IOException {
	prop=test.readProp();
	if(prop.getProperty("browser").equals("chrome")) {
		System.setProperty(prop.getProperty("chromekey"), prop.getProperty("chromeVal"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}else {
			//firefox
		}
	driver.get(prop.getProperty("siteUrl"));
}
 @AfterSuite
 public void tearDown() {
	 driver.close();
 }
}
