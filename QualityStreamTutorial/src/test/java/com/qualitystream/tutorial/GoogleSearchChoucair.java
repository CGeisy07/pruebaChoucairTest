package com.qualitystream.tutorial;


import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchChoucair {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.drive", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testchoucairTPage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));

		searchbox.clear();
		
		searchbox.sendKeys("https://www.choucairtesting.com/servicio/");
		
		searchbox.submit();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("servicios", driver.getTitle());
		
	}
	@After
	public void tearDown() {
		driver.quit();
	}

}
