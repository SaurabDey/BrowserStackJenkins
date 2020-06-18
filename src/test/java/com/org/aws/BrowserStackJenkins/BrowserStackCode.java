package com.org.aws.BrowserStackJenkins;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStackCode {
	public static final String USERNAME = "saurabdey3";
	public static final String AUTOMATE_KEY = "g4pSxhMbR9S85gQptvtB";
	public static final String BaseURL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void start() throws MalformedURLException {

		System.out.println(">>>>>>Started execution in BrowserStack>>>>>>");
		System.out.println(">> We are running in AWS> Jenkins> Browserstack uising GIT code>>>>");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Safari");
		caps.setCapability("browser_version", "5.1");
		caps.setCapability("os", "OS X");
		caps.setCapability("os_version", "Snow Leopard");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("name", "Bstack-[Java] Sample Test");

		WebDriver driver = new RemoteWebDriver(new URL(BaseURL), caps);
		driver.get("http://demosite.center/wordpress/wp-login.php");
		WebElement user = driver.findElement(By.id("user_login"));
		user.sendKeys("admin");

		WebElement pass = driver.findElement(By.id("user_pass"));
		pass.sendKeys("demo123");

		WebElement loginButn = driver.findElement(By.id("wp-submit"));
		loginButn.click();

		System.out.println(driver.getTitle());
		driver.quit();
		
		System.out.println(">>>>>>Ended execution in BrowserStack>>>>>>");
	}

}
