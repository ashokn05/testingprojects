package com.demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestScript {
	private static String url = "http://localhost:8080/P01AutomateWebApp/index.jsp";

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Desktop\\servers\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get(url);
		screenshot(driver, "navbar");
		driver.findElement(By.cssSelector(".topnav > a:nth-child(2)")).click(); // login click

		addDetailsToLoginForm(driver, "ashok", "ashok@gmail.com", "ashok@123");// get login data
		addDetailToRegisterForm(driver, "ashok@gmail.com", "ashok", "ashok@123");// get register data

	}

	public static void screenshot(ChromeDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File(screenshotName + ".png"));
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void addDetailToRegisterForm(ChromeDriver driver, String email, String pswd, String rpswd)
			throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div/a[3]")).click();
		Thread.sleep(300);

		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"psw\"]")).sendKeys(pswd);
		driver.findElement(By.xpath("//*[@id=\"psw-repeat\"]")).sendKeys(rpswd);

		Boolean Display1 = driver.findElement(By.xpath("/html/body/form/div[1]/button")).isDisplayed();
		System.out.println("Button displayed is " + Display1);
		Boolean Enable1 = driver.findElement(By.xpath("/html/body/form/div[1]/button")).isEnabled();
		System.out.println("Button Enabled is " + Enable1);
		screenshot(driver, "registers");
		Thread.sleep(300);

		driver.findElement(By.xpath("/html/body/form/div[1]/button")).click();

		Thread.sleep(300);
		driver.navigate().to(url);

	}

	private static void addDetailsToLoginForm(ChromeDriver driver, String userName, String email, String Password)
			throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Password);
		Thread.sleep(3000);
		screenshot(driver, "loginss");

		Boolean Display = driver.findElement(By.xpath("/html/body/center/div/form/input[4]")).isDisplayed();
		System.out.println("Button displayed is " + Display);
		Boolean Enable = driver.findElement(By.xpath("/html/body/center/div/form/input[4]")).isEnabled();
		System.out.println("Button Enabled is " + Enable);

		driver.findElement(By.xpath("/html/body/center/div/form/input[4]")).click();
		Thread.sleep(2000);
		driver.navigate().to(url);

	}

}