package com.example.valid;
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
public class ValidRegistration {
	String driverPath="C:\\Users\\DELL\\Desktop\\servers\\chromedriver\\chromedriver.exe";
	public WebDriver driver;
  @Test
  public void f() throws IOException, InterruptedException 
  {
    driver.manage().window().maximize();
	driver.get("https://www.browserstack.com/users/sign_up");
	
	driver.findElement(By.id("user_full_name")).sendKeys("N Ashok");
	TakesScreenshot tsc = (TakesScreenshot) driver;	
	File rsc = tsc.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(rsc,new File("ValidRegistration_UserName.png"));
	
	driver.findElement(By.id("user_email_login")).sendKeys("ashok@gmail.com");
	TakesScreenshot ts = (TakesScreenshot) driver;	
	File rs = ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(rs,new File("ValidRegistration_Email.png"));
	
	driver.findElement(By.id("user_password")).sendKeys("Ashok@321");
	TakesScreenshot r = (TakesScreenshot) driver;	
	File k = r.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(k,new File("ValidRegistration_Password.png"));
	Thread.sleep(10);
	driver.findElement(By.id("tnc_checkbox")).click();
	
	driver.findElement(By.name("commit")).click();
	TakesScreenshot p = (TakesScreenshot) driver;	
	File f = p.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(f,new File("ValidRegistration_Signup.png"));
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