package com.example.invalid;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class InvalidLogin {
	String driverPath="C:\\Users\\DELL\\Desktop\\servers\\chromedriver\\chromedriver.exe";
	public WebDriver driver;
  @Test
  public void f() throws IOException, InterruptedException 
  {
    driver.manage().window().maximize();
	driver.get("https://www.browserstack.com/users/sign_in?utm_source=google&utm_medium=cpc&utm_campaign=Search-Brand-India");
	
	driver.findElement(By.id("user_email_login")).sendKeys("xxx@gmail.com");
	TakesScreenshot ts = (TakesScreenshot) driver;	
	File rs = ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(rs,new File("InvalidLogin_Email.png"));
	
	driver.findElement(By.id("user_password")).sendKeys("xxxxxx");
	TakesScreenshot r = (TakesScreenshot) driver;	
	File k = r.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(k,new File("InvalidLogin_Password.png"));
	
	Thread.sleep(10);
	//driver.findElement(By.id("tnc_checkbox")).click();
	driver.findElement(By.name("commit")).click();
	Thread.sleep(10);
	
	TakesScreenshot p = (TakesScreenshot) driver;	
	File f = p.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(f,new File("InvalidLogin_Signin.png"));
	String actualUrl = "https://www.browserstack.com/users/sign_in?utm_source=google&utm_medium=cpc&utm_campaign=Search-Brand-India";
	String expectedUrl = driver.getCurrentUrl();
	Assert.assertEquals(expectedUrl, actualUrl);		
	
}
@BeforeTest
public void beforeTest() 
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Desktop\\servers\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();

}
@AfterTest
public void afterTest() 
{
		 System.out.println("After test is running");
}	 
}