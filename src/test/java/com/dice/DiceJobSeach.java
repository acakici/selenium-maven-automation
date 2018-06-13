package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSeach {

	public static void main(String[] args) {
		
		/*
		 * 
		 * Test case:
      Title: dice job search 

      Step 1. Launch browser and navigate to https://dice.com 
        Expected: dice home page should be displayed

      Step 2. Insert search keyword and location then click on
      find tech jobs
      Expected: -Search results page should be loaded.
                -Page title should contain count of results , 
                along with search keyword.
                -Count of results should be displayed on the page.
      ====================
      Steps to automate:
        -Make sure you understand what functionality is being tested 
        and each step. What is expected, what is being tested.

        If you don't understand:  Ask manual tester/person who wrote it.
        BAs, Developers, Lead 

        -Manually test it and make sure , it is passing manually.
        And make sure no defects/bugs around it.
        -if a test case is failing manually, it does not qualify 
        for automation.
		 */
		
		
		
	//Set up chrome driver path
		WebDriverManager.chromedriver().setup();
		//invoke selenium webdriver
		WebDriver driver= new ChromeDriver();
		
		//making full screen
		driver.manage().window().fullscreen();
		//
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String url= "http://dice.com";
	
	driver.get(url);
	
		String actualTitle= driver.getTitle();
		String expectedTitle= "Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			
			System.out.println("Spet pass");
		}else {
			System.out.println("Step fail");
			throw new RuntimeException("Step fail. Dice");
			
		}
		
		
		
	
		String keyword= "javascript developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		String location= "77064";
		
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		
		driver.findElement(By.id("findTechJobs")).click();
		
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
	
		//ensure cont is more than 0
		
		int countResult= Integer.parseInt(count.replace(",",""));
		
		if(countResult>0) {
			
			System.out.println("Keyword: "+ keyword+ "search returned"+ countResult+ "results in"+ location);
			
	
		}else {
			System.out.println("Step fail: Keyword"+ keyword+ "search returned"+ countResult+ "results in"+ location);
			
		}
		
		driver.close();
		
}	
}
